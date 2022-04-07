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
        echo 'git leaks'
    }
}
