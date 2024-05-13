pipeline {
    agent any
    stages {
        stage('Start') {
            steps {
                echo 'welcome to the build'
                sh 'whoami'
                sh 'ls ~/'
                sh 'ls ~/.ssh'
            }
        }
        stage('Checkout') {
            steps {
                echo 'checkout'
                git branch: 'develocity-1',
                    credentialsId: 'github',
                    changelog: true,
                    url: 'git@github.com:marcoman/lucene.git'
            }
        }
        stage('Build') {
            steps {
                echo 'gradle clean build'
            }
        }
    }
}