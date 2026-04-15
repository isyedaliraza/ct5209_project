pipeline {
    agent any

    parameters {
        booleanParam(name: 'DEPLOY', defaultValue: false, description: 'Do you want to deploy this build?')
    }

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
        stage('Deploy') {
            steps {
                echo "The user manually approved? ${params.DEPLOY}"
            }
        }
    }
}