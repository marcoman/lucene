pipeline {
    agent {
        label 'linux'

    }
    stages {
        stage('Checkout') {
            steps {
                echo 'checkout'
                checkout changelog: true,
                    poll: true,
                    git branch: 'develocity-*',
                    credentialsId: 'github'
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