pipeline {
 agent any
   tools {
        maven 'Maven3'
    }
 environment {
    DOCKER_USERNAME = "saimohan2026"
    IMAGE_TAG = "v${BUILD_NUMBER}"
    IMAGE_NAME = "${DOCKER_USERNAME}/${JOB_NAME}:${IMAGE_TAG}"
}
 stages {
  stage('Checkout'){steps{checkout scm}}
  stage('Build'){steps{sh 'mvn clean package -DskipTests'}}
  stage('Docker Build'){steps{sh 'docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .'}}
  stage('Docker Login'){steps{withCredentials([usernamePassword(credentialsId:'dockerhub-creds',usernameVariable:'DOCKER_USER',passwordVariable:'DOCKER_PASS')]){sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'}}}
  stage('Push'){steps{sh 'docker push $IMAGE_NAME'}}
 }
}
