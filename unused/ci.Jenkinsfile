pipeline {
	agent any
	options { 
		colorizeOutput()
		timestamps()
		ansiColor('xterm')
		disableConcurrentBuilds()
		timeout(59)
		buildDiscarder(logRotator(numToKeepStr: '5', daysToKeepStr: '1'))
//		ws('/tmp/cicd')
	}

	triggers {
		cron('@hourly')
	}

	stages { 

	stage('Banner') { steps { echo 'CI-PIPELINE-START' } } 

	stage('Git-CICD') { steps { git(url: 'https://github.com/raogaru/cicd.git', branch: 'master', credentialsId: 'raogaru', poll: 'false') } }
	stage('Git-MyApp') { steps { dir('myapp') { git(url: 'https://github.com/raogaru/myapp.git', branch: 'master', credentialsId: 'raogaru', poll: 'false') } } }
	}

	stages {
		stage('Main-Gate-Enter') { steps { sh './ci.sh DUMMY' } }
		stage('Main-Gate-Checkin') { steps { sh './ci.sh DUMMY' } }
		stage('Main-Gate-Build') { 
			parallel {
				stage('Main-Gate-Build-DB-Docker') { steps { sh './ci.sh mgBuild.sh DB-Docker' } }
				stage('Main-Gate-Build-Web-Docker') { steps { sh './ci.sh mgBuild.sh Web-Docker' } }
				stage('Main-Gate-Build-App-Docker') { steps { sh './ci.sh mgBuild.sh App-Docker' } }
			} }
		stage('Main-Gate-Verify') { steps { sh './ci.sh DUMMY' } }
	}

	stages {
		stage('System-Gate-Enter') { steps { sh './ci.sh DUMMY' } }
		stage('System-Gate-Build-Enter') { steps { sh './ci.sh DUMMY' } }
		parallel {
				stage('System-Gate-Build-DB-Docker') { steps { sh './ci.sh mgBuild.sh DB-Docker' } }
				stage('System-Gate-Build-Web-Docker') { steps { sh './ci.sh mgBuild.sh Web-Docker' } }
				stage('System-Gate-Build-App-Docker') { steps { sh './ci.sh mgBuild.sh App-Docker' } }
			} 
    stage('System-Gate-Build-Exit') { steps { sh './ci.sh DUMMY' } }
	}

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
