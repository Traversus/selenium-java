pipeline {
  agent any
  stages {
    stage('Prep') {
      steps {
        withMaven(maven: 'M3', jdk: 'JDK8')
      }
    }

    stage('Build') {
      steps {
        sh 'mvn clean'
      }
    }

  }
}