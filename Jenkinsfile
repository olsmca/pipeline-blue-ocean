pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''gradle clean
gradle bootJar'''
        echo 'Compilando Proyecto'
      }
    }
    stage('Test') {
      steps {
        input 'Quiere ejecutar test'
      }
    }
    stage('Test Unitarios') {
      parallel {
        stage('Test Unitarios') {
          steps {
            sh 'gradle test'
          }
        }
        stage('Test Integarcion') {
          steps {
            echo 'Ejecutando Test Integracion'
          }
        }
      }
    }
    stage('Deploy') {
      steps {
        input 'Desea Desplegar en el Ambiente'
        echo 'Desplegando'
      }
    }
  }
}