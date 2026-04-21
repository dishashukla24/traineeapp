pipeline {
    agent any

    environment {
        IMAGE_NAME = "traineeapp"
        DOCKERHUB_USER = "dishashukla24"
    }

    stages {

        stage('Build JAR') {
    steps {
        sh './mvnw clean package -DskipTests'
    }
}
stage('Check Docker') {
    steps {
        sh 'docker --version'
    }
}

stage('Check PATH') {
    steps {
        sh 'echo $PATH'
    }
}
stage('Check Docker Path') {
    steps {
        sh '/usr/local/bin/docker --version'
    }
}

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
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
                    echo $PASS | docker login -u $USER --password-stdin
                    '''
                }
            }
        }

        stage('Tag Image') {
            steps {
                sh 'docker tag $IMAGE_NAME $DOCKERHUB_USER/$IMAGE_NAME:latest'
            }
        }

        stage('Push to DockerHub') {
            steps {
                sh 'docker push $DOCKERHUB_USER/$IMAGE_NAME:latest'
            }
        }

        stage('Run Containers') {
            steps {
                sh '''
                docker compose down || true
                docker compose up -d --build
                '''
            }
        }
    }
}