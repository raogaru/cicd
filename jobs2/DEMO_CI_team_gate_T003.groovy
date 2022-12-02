// ######################################################################
pipelineJob('DEMO-CI-team-gate-T003') {
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
		vGATE = 'TEAM'
		vSTAGE = ''
		vTEAM = 'T003'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T003-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T003-START' } } 

		stage('Team-Gate-T003-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T003',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T003-Enter') 		{ steps { sh './ci.sh Team-Gate-T003-Enter' } }

		stage('Team-Gate-Build-T003-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T003-Enter' } }
		stage('Team-Gate-Build-T003-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T003-DB1' } }
		stage('Team-Gate-Build-T003-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T003-DB2' } }
		stage('Team-Gate-Build-T003-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T003-WWW' } }
		stage('Team-Gate-Build-T003-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T003-APP1' } }
		stage('Team-Gate-Build-T003-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T003-APP2' } }
		stage('Team-Gate-Build-T003-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T003-APP3' } }
		stage('Team-Gate-Build-T003-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T003-' } }

		stage('Team-Gate-Deploy-T003-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T003-Enter' } }
		stage('Team-Gate-Deploy-T003-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T003-DB1' } }
		stage('Team-Gate-Deploy-T003-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T003-DB2' } }
		stage('Team-Gate-Deploy-T003-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T003-WWW' } }
		stage('Team-Gate-Deploy-T003-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T003-APP1' } }
		stage('Team-Gate-Deploy-T003-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T003-APP2' } }
		stage('Team-Gate-Deploy-T003-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T003-APP3' } }
		stage('Team-Gate-Deploy-T003-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T003-Exit' } }

		stage('Team-Gate-Test-T003-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T003-Enter' } }
		stage('Team-Gate-Test-T003-Functional') { steps { sh './ci.sh Team-Gate-Test-T003-Functional' } }
		stage('Team-Gate-Test-T003-Performance'){ steps { sh './ci.sh Team-Gate-Test-T003-Performance' } }
		stage('Team-Gate-Test-T003-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T003-Security' } }
		stage('Team-Gate-Test-T003-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T003-Exit' } }

		stage('Team-Gate-T003-Exit') { steps { sh './ci.sh Team-Gate-T003-Exit' } }

		stage('Team-Gate-T003-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T003-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
