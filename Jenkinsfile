pipeline {
    agent any

    stages {

        stage('Build & Test') {
            steps {
                sh '/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=testng.xml'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**', allowEmptyArchive: true
        }
    }
}