pipeline {
  agent any
  stages {
    stage('Prep') {
      steps {
        withMaven(maven: 'M3', jdk: 'JDK8', publisherStrategy: 'IMPLICIT', mavenLocalRepo: '~/.M2/') {
          sh 'mvn clean'
        }

      }
    }

  }
}