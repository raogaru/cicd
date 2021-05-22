pipeline {
  agent any
  stages {
    stage('m1') {
      steps {
        echo 'main-gate-stage1'
        sh 'echo \'shell main-gate-stage1\''
      }
    }

    stage('m2') {
      steps {
        echo 'main-gate-stage2'
        sh 'echo \'shell main-gate-stage2\''
      }
    }

    stage('tg') {
      parallel {
        stage('tg-1') {
          steps {
            echo 't-mars'
            echo 't-1-build'
            echo 't-1-deploy'
            echo 't-1-test'
          }
        }

        stage('tg-2') {
          steps {
            echo 't-venus'
            echo 't-2-build'
            echo 't-2-deploy'
            echo 't-2-test'
          }
        }

        stage('tg-3') {
          steps {
            echo 't-pluto'
            echo 't-3-build'
            echo 't-3-deploy'
            echo 't-3-tet'
          }
        }

      }
    }

    stage('sg') {
      steps {
        echo 'sg-entry'
        echo 'sg-build'
        echo 'sg-deploy'
        echo 'sg-test'
        echo 'sg-exit'
      }
    }

  }
  environment {
    vPROCEED = 'YES'
  }
}