pipeline {
    agent any

    environment {
    IMAGE_NAME = "traineeapp"
    DOCKERHUB_USER = "dishashukla24"
    DOCKER_PATH = "/Applications/Docker.app/Contents/Resources/bin/docker"
    PATH = "/Applications/Docker.app/Contents/Resources/bin:/usr/bin:/bin:/usr/sbin:/sbin"
}

    stages {

        stage('Build JAR') {
            steps {
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh '$DOCKER_PATH build -t $IMAGE_NAME .'
            }
        }

        stage('Login to DockerHub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS'
                )]) {
                    sh '''
                    echo $PASS | $DOCKER_PATH login -u $USER --password-stdin
                    '''
                }
            }
        }

        stage('Tag Image') {
            steps {
                sh '$DOCKER_PATH tag $IMAGE_NAME $DOCKERHUB_USER/$IMAGE_NAME:latest'
            }
        }

        stage('Push to DockerHub') {
            steps {
                sh '$DOCKER_PATH push $DOCKERHUB_USER/$IMAGE_NAME:latest'
            }
        }

        stage('Run Containers') {
            steps {
                sh '''
                $DOCKER_PATH rm -f postgres-db || true
				$DOCKER_PATH rm -f springboot-app || true

				$DOCKER_PATH compose down || true
				$DOCKER_PATH compose up -d --build
                '''
            }
        }
    }
}