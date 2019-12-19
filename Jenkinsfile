pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
    }

    stage('Report') {
      parallel {
        stage('Cucumber Report') {
          steps {
            cucumber '**/*.json'
          }
        }

        stage('Serenity Report') {
          steps {
            sh 'mvn -B serenity:aggregate'
          }
        }

      }
    }

  }
}