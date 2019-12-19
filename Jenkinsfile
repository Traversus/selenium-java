pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        withMaven(maven: 'M3', jdk: 'JDK8', publisherStrategy: 'IMPLICIT', mavenLocalRepo: '~/.M2/') {
          sh 'mvn clean'
        }

      }
    }

    stage('Serenity Aggregate') {
      steps {
        withMaven(jdk: 'JDK8', maven: 'M3', mavenLocalRepo: '~/.M2/') {
          sh 'mvn -B serenity:aggregate'
        }

      }
    }

  }
}