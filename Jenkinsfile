pipeline {
    agent any

    stages {
        stage('Fetch') {
            steps {
                git branch: 'main', url: 'https://github.com/isyedaliraza/ct5209_project.git'
            }
        }
        stage('Build') {
            steps {
                sh "mvn clean"
                sh "mvn package"
            }
        }
    }

    post {
        success {
            archiveArtifacts allowEmptyArchive: true, artifacts: '**/demo*.war'
        }
    }
}