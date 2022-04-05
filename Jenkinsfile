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
    env.ANG_REPO_URL="https://gitlab.xpanxion.com/foodkart/xpanxion_angular_poc.git"
    env.JAVA_REPO_URL="https://gitlab.xpanxion.com/foodkart/Xpanxion_Java_Poc.git"
    sh '''
        echo "PATH = ${PATH}"
        echo "M2_HOME = ${M2_HOME}"
    '''
}

def maintainLatestTenBuilds() {
	properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '10', numToKeepStr: '5'))])
}

def checkoutSCM(){
    checkout([$class: 'GitSCM', branches: [[name: '*/dev']], extensions: [], userRemoteConfigs: [[credentialsId: 'git-token', url: env.ANG_REPO_URL]]])

    sh 'ls -ltr; mkdir output; whoami'

    checkout([$class: 'GitSCM', branches: [[name: '*/dev']], extensions: [], userRemoteConfigs: [[credentialsId: GIT_CREDENTIALS_ID, url: env.JAVA_REPO_URL]]])
}

def secretCheck(){
    script{
        echo "checking secrets"
    }
}
