pipeline {
  agent any

  parameters{
        string(name:'ChannelSlack', defaultValue: '#pipeline-as-code', description: "channel a utilizar")
        string(name:'ChannelSlack', defaultValue: '#pipeline-as-code', description: "channel a utilizar")

    }

  stages {
    stage('Build') {
      steps {
        echo 'Compilando Proyecto'
        sh ''' gradle clean
                gradle bootJar
           '''
      }
      post {
        always {
            echo 'One way or another, I have finished'
            /*deleteDir() */
        }
        success {
            echo 'Build generado con exito!'
            slackSend teamDomain: 'negocio-eps',
                      channel: '#pipeline-as-code',
                      token: 'kXvuJfAZwudfk6lHSxvduEaY',
                      color: 'good',
                      message: "The pipeline ${currentBuild.fullDisplayName} completed successfully."
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed :('
        }
        changed {
            echo 'Things were different before...'
        }
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