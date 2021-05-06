pipeline {
  agent any
  stages {
    stage('Entry') {
      steps {
        echo 'Hello World'
      }
    }

    stage('Git') {
      steps {
        git(url: 'https://github.com/raogaru/cicd.git', branch: 'master', credentialsId: 'raogaru')
      }
    }

    stage('TeamGateEntry') {
      steps {
        sh './demo.sh USER_BUILD raogaru'
      }
    }

    stage('TeamGate') {
      parallel {
        stage('TeamGate-MARS') {
          steps {
            sh './demo.sh TEAM_BUILD MARS 1'
            sh './demo.sh TEAM_BUILD MARS 2'
            sh './demo.sh TEAM_DEPLOY MARS 1'
            sh './demo.sh TEAM_DEPLOY MARS 2'
            sh './demo.sh TEAM_TEST MARS 1'
            sh './demo.sh TEAM_TEST MARS 2'
          }
        }

        stage('TeamGate-VENUS') {
          steps {
            sh './demo.sh TEAM_BUILD VENUS 1'
            sh './demo.sh TEAM_BUILD VENUS 2'
            sh './demo.sh TEAM_DEPLOY VENUS 1'
            sh './demo.sh TEAM_DEPLOY VENUS 2'
            sh './demo.sh TEAM_TEST VENUS 1'
            sh './demo.sh TEAM_TEST VENUS 2'
          }
        }

        stage('TeamGate-PLUTO') {
          steps {
            sh './demo.sh TEAM_BUILD PLUTO 1'
            sh './demo.sh TEAM_BUILD PLUTO 2'
            sh './demo.sh TEAM_DEPLOY PLUTO 1'
            sh './demo.sh TEAM_DEPLOY PLUTO 2'
            sh './demo.sh TEAM_TEST PLUTO 1'
            sh './demo.sh TEAM_TEST PLUTO 2'
          }
        }

      }
    }

    stage('SystemGate') {
      steps {
        sh './demo.sh SYSTEM_BUILD 1'
        sh './demo.sh SYSTEM_BUILD 2'
        sh './demo.sh SYSTEM_DEPLOY 1'
        sh './demo.sh SYSTEM_DEPLOY 2'
        sh './demo.sh SYSTEM_TEST 1'
        sh './demo.sh SYSTEM_TEST 2'
      }
    }

    stage('ReleaseGate') {
      steps {
        sh './demo.sh RELEASE PREPARE'
        sh './demo.sh RELEASE VERIFY'
        sh './demo.sh RELEASE BUILD'
        sh './demo.sh RELEASE VERIFY'
        sh './demo.sh RELEASE PUBLISH'
        sh './demo.sh RELEASE PUBLISH'
        build(wait: true, job: 'job1')
      }
    }

    stage('MainExit') {
      steps {
        sh './demo.sh MAIN EXIT'
      }
    }

  }
}