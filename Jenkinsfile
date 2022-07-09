pipeline{
    agent {
            kubernetes {
               containerTemplate {
                    name 'maven'
                    image 'maven:3.8.6-openjdk-11-slim'
                    ttyEnabled true
                    command 'cat'
                }
        }
    }
    
    environment{
        DOCKER_IMAGE_NAME = "foodkart_backend"
        AWS_ACCOUNT_ID = "232120535331"
        AWS_DEFAULT_REGION = "us-west-1" 
        IMAGE_REPO_NAME = "devsecops-backend"
        IMAGE_TAG = "latest"
        REPOSITORY_URI = "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}"
        TASK_FAMILY = "devsecops-backend"
        SERVICE_NAME = "ecs-backend"
        DESIRED_COUNT ="2" 
        SHORT_COMMIT = "${GIT_COMMIT[0..7]}"
        EXECUTION_ROLE_ARN = "arn:aws:iam::232120535331:role/ecsTaskExecutionRole"
        CLUSTER_NAME = "DevSecOps-demo"

        SONAR_AUTH_TOKEN = "03baa10c2812ddd7e8be281c1d960a96c2029bf7"
        JAVA_REPO_URL="git@gitlab.xpanxion.com:digitalassetshub/devops/devsecops/DevSecOps_Java_Backend.git"
        REPO_PATH="/home/jenkins/agent/workspace/backend_pipeline/"
        DIR_PATH="/home/jenkins/agent/workspace/backend_pipeline/ecommerceapi/"
    }

    stages{
        
        /*stage('Initializing Environment'){
            steps{
                initializeEnvironment()
            }
        }*/

        stage('Maintain Latest 5 Builds'){
                steps{
                    maintainLatestFiveBuilds()
                }
            
        }

        stage('Checkout Source Code'){
            steps{
                checkoutSCM()
            }
        }

        stage('Check Secrets'){
            steps{
                secretCheck()
            }
        }

        stage('Maven Unit Test'){
            steps{
                mavenUnitTest()
            }
        }

        /*stage('Sonar Scan'){
            steps{
                sonarScan()
            }
        }*/

       /* stage('Quality Gate'){
            steps{
                qualityGate()
            }
        }*/

        stage('Docker File Security'){
            agent {
                    kubernetes {
                    containerTemplate {
                            name 'dockerfile-sec'
                            image 'cr0hn/dockerfile-sec'
                            ttyEnabled true
                            command 'cat'
                        }
                }
            }
            steps{
                dockerFileSecurity()
            }
        }

        stage('Build Docker Image'){
            steps{
                buildDockerImage()
            }
        }

        stage("ECR Push & ECR Scan"){
            steps{
                ecrPushScan()
            }
        }
        stage("Deploy to ECS"){
            steps{
                ecsDeploy()
            }
        }
    }
}

//=============================================//

/*def initializeEnvironment(){
    cleanWs()
    //env.ANG_REPO_URL="https://gitlab.xpanxion.com/foodkart/xpanxion_angular_poc.git"
    env.
    sh '''
        echo "PATH = ${PATH}"
        echo "M2_HOME = ${M2_HOME}"
    '''
}*/

def maintainLatestFiveBuilds() {
	properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '10', numToKeepStr: '5'))])
}

def checkoutSCM(){
    checkout([$class: 'GitSCM', branches: [[name: '*/dev']], extensions: [], userRemoteConfigs: [[credentialsId: 'gitlab-ssh-key', url: JAVA_REPO_URL]]])
    
}

def secretCheck(){
    script{
        try{
            sh'''
            docker pull zricethezav/gitleaks:latest
            '''
            docker.image('zricethezav/gitleaks').inside('--entrypoint=""') {
                sh "gitleaks --source=${REPO_PATH}  detect -r leak.json"
            }
        }
        catch(Exception e){
            input("Do you want to proceed?")
        }   
    }
}

def mavenUnitTest(){
    script{
        dir("${DIR_PATH}"){
            sh '''
            mvn test
            '''
        }
    }
}

def sonarScan(){
    script{
        withSonarQubeEnv('SonarQube') {
            dir("${DIR_PATH}"){
                sh '''
                mvn sonar:sonar \
                -Dsonar.projectKey=backend_java \
                -Dsonar.host.url=http://54.153.54.18:9000 \
                -Dsonar.login="${SONAR_AUTH_TOKEN}"
                '''
            }
        }
    }
}

def qualityGate(){
    script{
        sh 'sleep 10'
        timeout(time: 1, unit: 'HOURS') {
            waitForQualityGate abortPipeline: true
        }
    }
}

def dockerFileSecurity(){
    script{
        sh'''
        "dockerfile-sec -o results.json Dockerfile
        '''
    }
}

def buildDockerImage(){
    script{
        dir("${DIR_PATH}"){
             docker.build "${IMAGE_REPO_NAME}:${IMAGE_TAG}"
        }
       

    }
}

def ecrPushScan(){
    script{
        
        sh '''
            aws ecr get-login-password --region us-west-1 | docker login --username AWS --password-stdin 232120535331.dkr.ecr.us-west-1.amazonaws.com
            docker tag ${IMAGE_REPO_NAME}:${IMAGE_TAG} ${REPOSITORY_URI}:$IMAGE_TAG
            docker push ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}:${IMAGE_TAG}
        '''
    }
}

def ecsDeploy(){
    script{
        sh """sed -e "s;%REPOSITORY_URI%;${REPOSITORY_URI};g" -e "s;%VERSION%;${IMAGE_TAG};g" -e "s;%TASK_FAMILY%;${TASK_FAMILY};g" -e "s;%SERVICE_NAME%;${SERVICE_NAME};g" -e "s;%EXECUTION_ROLE_ARN%;${EXECUTION_ROLE_ARN};g" taskdef.json > taskdef_${SHORT_COMMIT}.json"""

                    sh "aws ecs register-task-definition --output json --cli-input-json file://${WORKSPACE}/taskdef_${SHORT_COMMIT}.json > ${env.WORKSPACE}/temp.json"
                    
                    def projects = readJSON file: "${env.WORKSPACE}/temp.json"
                    def TASK_REVISION = projects.taskDefinition.revision

                    sh "aws ecs update-service --cluster ${CLUSTER_NAME} --service ${SERVICE_NAME} --task-definition ${TASK_FAMILY}:${TASK_REVISION} --desired-count ${DESIRED_COUNT}"
    }
}
