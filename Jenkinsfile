pipeline {
    agent {
        label 'linux'

    }
    stages {
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