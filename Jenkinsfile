pipeline {
    agent any

    triggers {
            pollSCM('* * * * *')
    }

    environment {
        APPLICATION_NAME = 'proposal'
    }

    stages {
        stage('Build') {
            steps {
                sh './mvnw clean install'
            }
        }
    }
}
