pipeline {
    agent any

    environment {
        REPOSITORY_URL = 'https://github.com/YourUsername/your-springboot-app'
        DOCKER_IMAGE = 'your-springboot-app'
        CONTAINER_NAME = 'springbootapp'
        EC2_IP = '3.110.114.23'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git url: "${REPOSITORY_URL}", branch: 'master'
            }
        }

        stage('Build with Maven') {
            steps {
                // Build Spring Boot application with Maven
                sh 'mvn clean package -Dskiptests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Spring Boot Docker image
                    sh "docker build -t ${DOCKER_IMAGE} ."
                }
            }
        }

        stage('Deploy Docker Compose on EC2') {
            steps {
                script {
                    // Copy docker-compose.yml to EC2 and deploy the application
                    sh '''
                    scp -o StrictHostKeyChecking=no docker-compose.yml ec2-user@${EC2_IP}:/home/ec2-user/
                    ssh -o StrictHostKeyChecking=no ec2-user@${EC2_IP} "
                      docker-compose down || true &&
                      docker-compose up -d --build"
                    '''
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
