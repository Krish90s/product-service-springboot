pipeline {
    agent any

    environment {
        REPOSITORY_URL = 'https://github.com/Krish90s/product-service-springboot'
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
    }

    post {
        always {
            cleanWs()
        }
    }
}
