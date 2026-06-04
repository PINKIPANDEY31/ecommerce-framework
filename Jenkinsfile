pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/PINKIPANDEY31/ecommerce-framework.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test -DsuiteXmlFile=testng.xml'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**', allowEmptyArchive: true
        }
    }
}