pipeline {
  agent any
  
  parameters {
    string(name: 'teamDomain', defaultValue: 'negocio-eps', description: 'teamDomain a utilizar')
    string(name: 'channel', defaultValue: '#pipeline-as-code', description: 'channel a utilizar')
    string(name: 'token', defaultValue: 'kXvuJfAZwudfk6lHSxvduEaY', description: 'token a utilizar')
  }
  
  stages {
    stage('Build') {
      post {
        always {
          echo 'One way or another, I have finished'
        }

        success {
          echo 'Build generado con exito!'
          slackSend(teamDomain: "${params.Greeting}", channel: "${params.Greeting}", token: "${params.Greeting}", color: 'good', message: "${env.JOB_NAME}, ${currentBuild.fullDisplayName} completado con exito")
        }

        unstable {
          echo 'I am unstable :/'
          slackSend(teamDomain: "${params.Greeting}", channel: "${params.Greeting}", token: "${params.Greeting}", color: 'warning', message: "${env.JOB_NAME}, ${currentBuild.fullDisplayName} inestable.")
        }

        failure {
          echo 'I failed :('

        }

        changed {
          echo 'Things were different before...'

        }

      }
      steps {
        echo 'Compilando Proyecto BlueOcean'
        sh ''' gradle clean
                gradle bootJar
           '''
      }
    }
    stage('Test') {
      steps {
        input 'Quiere ejecutar test'
      }
    }
    stage('Test en Paralelo') {
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
