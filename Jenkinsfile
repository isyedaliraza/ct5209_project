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
        stage('Archive') {
            steps {
                archiveArtifacts allowEmptyArchive: true, artifacts: '**/demo.war'
            }
        }
        stage('Approval') {
            steps {
                input message: 'Do you want to deploy this build?', ok: 'Deploy'
            }
        }
        stage('Deploy') {
            steps {
                sh "sudo docker build -f Dockerfile -t petitions ."
            }
        }
    }
}