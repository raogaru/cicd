// ######################################################################
pipelineJob('DEMO-CI-40-release-gate') {
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
		vGATE = 'RELEASE'
		vSTAGE = ''
		vTEAM = ''
		vPROCEED = 'YES'
	}

	stages {
		stage('Release-Gate-Start') { steps { echo 'CI-PIPELINE-RELEASE-GATE-START' } } 

		stage('Release-Gate-Git') 	{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
		} }

		stage('Release-Gate-Enter') { steps { sh './ci.sh DUMMY' } }

		stage('Release-Gate-Build-Enter') { steps { sh './ci.sh DUMMY' } }

		//stage('Release-Gate-Build') { parallel {
		stage('Release-Gate-Build-DB-Docker') { steps { sh './ci.sh DUMMY' } }
		stage('Release-Gate-Build-Web-Docker') { steps { sh './ci.sh DUMMY' } }
		stage('Release-Gate-Build-App-Docker') { steps { sh './ci.sh DUMMY' } }
		//} }

		stage('Release-Gate-Artifact') { steps { sh './ci.sh DUMMY' } }

		stage('Release-Gate-Verify') { steps { sh './ci.sh DUMMY' } }

		stage('Release-Gate-Publish') { steps { sh './ci.sh DUMMY' } }

		stage('Release-Gate-Notify') { steps { sh './ci.sh DUMMY' } }

		stage('Release-Gate-Exit') { steps { sh './ci.sh DUMMY' } }

		stage('Release-Gate-End') { steps { echo 'CI-PIPELINE-RELEASE-GATE-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
