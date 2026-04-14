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
                sh "mvn validate"
                sh "mvn compile"
            }
        }
        stage('Execute') {
            steps {
                sh "mvn spring-boot:run"
            }
        }
    }
}