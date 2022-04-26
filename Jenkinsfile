pipeline{
    agent any
    
    environment{
        DOCKER_IMAGE_NAME = "foodkart_backend"
    }

    stages{
        
        stage('Initializing Environment'){
            steps{
                initializeEnvironment()
            }
        }

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

        stage('Sonar Scan'){
            steps{
                sonarScan()
            }
        }

        stage('Docker File Security'){
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
    }
}

//=============================================//

def initializeEnvironment(){
    cleanWs()
    //env.ANG_REPO_URL="https://gitlab.xpanxion.com/foodkart/xpanxion_angular_poc.git"
    env.JAVA_REPO_URL="https://gitlab.xpanxion.com/digitalassetshub/devops/devsecops/DevSecOps_Java_Backend.git"
    sh '''
        echo "PATH = ${PATH}"
        echo "M2_HOME = ${M2_HOME}"
    '''
}

def maintainLatestFiveBuilds() {
	properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '10', numToKeepStr: '5'))])
}

def checkoutSCM(){
    checkout([$class: 'GitSCM', branches: [[name: '*/dev']], extensions: [], userRemoteConfigs: [[credentialsId: 'gitlab-hrugved', url: env.JAVA_REPO_URL]]])
    
}

def secretCheck(){
    script{
        sh'''
        docker pull zricethezav/gitleaks:latest
        '''
        docker.image('zricethezav/gitleaks').inside('--entrypoint=""') {
        sh "gitleaks --source=/var/lib/jenkins/workspace/Java_Backend/  detect"
        }    
    }
}

def mavenUnitTest(){
    script{
        sh '''
        cd ecommerceapi/
        mvn test
        '''
    }
}

def sonarScan(){
    script{
        sh '''
            cd ecommerceapi/
            mvn sonar:sonar \
            -Dsonar.projectKey=backend_java \
            -Dsonar.host.url=http://54.219.255.25:9000 \
            -Dsonar.login=7f142680193c076ea24720a7a2c200f047e41add
        '''
    }
}

def dockerFileSecurity(){
    script{
       sh'''
       docker pull cr0hn/dockerfile-sec
       '''
       docker.image('cr0hn/dockerfile-sec').inside('--entrypoint=""') {
        sh "dockerfile-sec /var/lib/jenkins/workspace/Java_Backend/ecommerceapi/Dockerfile"
        }    
    }
}

def buildDockerImage(){
    script{
        echo 'builing docker image'
    }
}

def ecrPushScan(){
    script{
        echo 'ecr push and ecr scan'
    }
}
