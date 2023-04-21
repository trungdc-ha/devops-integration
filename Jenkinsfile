pipeline {
    agent any
    tools {
        maven 'maven_3_8_1'
    }
    environment {
        DOCKER_IMAGE = "trungdc68/devops-integration"
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/trungdc-ha/devops-integration.git']])
                sh 'mvn clean install'
            }
        }
        stage("Junit Test") {
            steps {
                sh "mvn test"
            }
        }
//        stage('Report JUNIT') {
//            steps([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
//        }
        stage('Build docker image') {
            environment {
                DOCKER_TAG = "${GIT_BRANCH.tokenize('/').pop()}-${BUILD_NUMBER}-${GIT_COMMIT.substring(0, 7)}"
            }
            steps {
                script {
//                    sh 'docker build -t trungdc68/devops-integration .'
                     sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} . "
                }
            }
        }
        stage('Push image to Hub') {
            environment {
                DOCKER_TAG = "${GIT_BRANCH.tokenize('/').pop()}-${BUILD_NUMBER}-${GIT_COMMIT.substring(0, 7)}"
            }
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u trungdc68 -p ${dockerhubpwd}'
                    }
//                    sh 'docker push trungdc68/devops-integration'
                    sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
                clean to save disk
                sh "docker image rm ${DOCKER_IMAGE}:${DOCKER_TAG}"
            }
        }
    }
    post {
        success {
            echo "SUCCESSFUL"
        }
        failure {
            echo "FAILED"
        }
    }
}