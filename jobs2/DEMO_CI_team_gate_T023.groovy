// ######################################################################
pipelineJob('DEMO-CI-team-gate-T023') {
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
		vTEAM = 'T023'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T023-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T023-START' } } 

		stage('Team-Gate-T023-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T023',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T023-Enter') 		{ steps { sh './ci.sh Team-Gate-T023-Enter' } }

		stage('Team-Gate-Build-T023-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T023-Enter' } }
		stage('Team-Gate-Build-T023-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T023-DB1' } }
		stage('Team-Gate-Build-T023-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T023-DB2' } }
		stage('Team-Gate-Build-T023-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T023-WWW' } }
		stage('Team-Gate-Build-T023-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T023-APP1' } }
		stage('Team-Gate-Build-T023-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T023-APP2' } }
		stage('Team-Gate-Build-T023-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T023-APP3' } }
		stage('Team-Gate-Build-T023-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T023-' } }

		stage('Team-Gate-Deploy-T023-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T023-Enter' } }
		stage('Team-Gate-Deploy-T023-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T023-DB1' } }
		stage('Team-Gate-Deploy-T023-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T023-DB2' } }
		stage('Team-Gate-Deploy-T023-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T023-WWW' } }
		stage('Team-Gate-Deploy-T023-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T023-APP1' } }
		stage('Team-Gate-Deploy-T023-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T023-APP2' } }
		stage('Team-Gate-Deploy-T023-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T023-APP3' } }
		stage('Team-Gate-Deploy-T023-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T023-Exit' } }

		stage('Team-Gate-Test-T023-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T023-Enter' } }
		stage('Team-Gate-Test-T023-Functional') { steps { sh './ci.sh Team-Gate-Test-T023-Functional' } }
		stage('Team-Gate-Test-T023-Performance'){ steps { sh './ci.sh Team-Gate-Test-T023-Performance' } }
		stage('Team-Gate-Test-T023-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T023-Security' } }
		stage('Team-Gate-Test-T023-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T023-Exit' } }

		stage('Team-Gate-T023-Exit') { steps { sh './ci.sh Team-Gate-T023-Exit' } }

		stage('Team-Gate-T023-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T023-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
