// ######################################################################
pipelineJob('DEMO-CI-30-system-gate') {
  definition {
    cps {
      script('''
pipeline {
	agent any
	options { 
		timestamps()
		ansiColor('xterm')
		disableConcurrentBuilds()
		timeout(59)
		buildDiscarder(logRotator(numToKeepStr: '5', daysToKeepStr: '1'))
//		ws('/tmp/cicd')
	}
	environment {
		vGATE = 'SYSTEM'
		vSTAGE = ''
		vTEAM = ''
		vPROCEED = 'YES'
	}

	stages {
		stage('System-Gate-Start') { steps { echo 'CI-PIPELINE-SYSTEM-GATE-START' } } 

		stage('System-Gate-Git') { steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-MARS',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('System-Gate-Enter') { steps { sh './ci.sh DUMMY' } }

		stage('System-Gate-Build-Enter') { steps { sh './ci.sh DUMMY' } }

		//stage('System-Gate-Build') { parallel {
		stage('System-Gate-Build-DB-Docker') { steps { sh './ci.sh DUMMY' } }
		stage('System-Gate-Build-Web-Docker') { steps { sh './ci.sh DUMMY' } }
		stage('System-Gate-Build-App-Docker') { steps { sh './ci.sh DUMMY' } }
		//} }

		stage('System-Gate-Build-Exit') { steps { sh './ci.sh DUMMY' } }

		stage('System-Gate-Deploy-Enter') { steps { sh './ci.sh DUMMY' } }

		//stage('System-Gate-Deploy') { parallel {
		stage('System-Gate-Deploy-DB-Docker') { steps { sh './ci.sh DUMMY' } }
		stage('System-Gate-Deploy-Web-Docker') { steps { sh './ci.sh DUMMY' } }
		stage('System-Gate-Deploy-App-Docker') { steps { sh './ci.sh DUMMY' } }
		//} }

		stage('System-Gate-Deploy-Exit') { steps { sh './ci.sh DUMMY' } }

		stage('System-Gate-Test-Enter') { steps { sh './ci.sh DUMMY' } }

		//stage('System-Gate-Test') { parallel {
		stage('System-Gate-Test-Functional') { steps { sh './ci.sh DUMMY' } }
		stage('System-Gate-Test-Performance') { steps { sh './ci.sh DUMMY' } }
		stage('System-Gate-Test-Security') { steps { sh './ci.sh DUMMY' } }
		//} }

		stage('System-Gate-Test-Exit') { steps { sh './ci.sh DUMMY' } }

		stage('System-Gate-Exit') { steps { sh './ci.sh DUMMY' } }

		stage('System-Gate-End') { steps { echo 'CI-PIPELINE-SYSTEM-GATE-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
