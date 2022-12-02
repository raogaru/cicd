// ######################################################################
pipelineJob('DEMO-CI-team-gate-T038') {
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
		vTEAM = 'T038'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T038-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T038-START' } } 

		stage('Team-Gate-T038-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T038',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T038-Enter') 		{ steps { sh './ci.sh Team-Gate-T038-Enter' } }

		stage('Team-Gate-Build-T038-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T038-Enter' } }
		stage('Team-Gate-Build-T038-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T038-DB1' } }
		stage('Team-Gate-Build-T038-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T038-DB2' } }
		stage('Team-Gate-Build-T038-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T038-WWW' } }
		stage('Team-Gate-Build-T038-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T038-APP1' } }
		stage('Team-Gate-Build-T038-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T038-APP2' } }
		stage('Team-Gate-Build-T038-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T038-APP3' } }
		stage('Team-Gate-Build-T038-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T038-' } }

		stage('Team-Gate-Deploy-T038-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T038-Enter' } }
		stage('Team-Gate-Deploy-T038-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T038-DB1' } }
		stage('Team-Gate-Deploy-T038-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T038-DB2' } }
		stage('Team-Gate-Deploy-T038-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T038-WWW' } }
		stage('Team-Gate-Deploy-T038-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T038-APP1' } }
		stage('Team-Gate-Deploy-T038-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T038-APP2' } }
		stage('Team-Gate-Deploy-T038-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T038-APP3' } }
		stage('Team-Gate-Deploy-T038-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T038-Exit' } }

		stage('Team-Gate-Test-T038-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T038-Enter' } }
		stage('Team-Gate-Test-T038-Functional') { steps { sh './ci.sh Team-Gate-Test-T038-Functional' } }
		stage('Team-Gate-Test-T038-Performance'){ steps { sh './ci.sh Team-Gate-Test-T038-Performance' } }
		stage('Team-Gate-Test-T038-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T038-Security' } }
		stage('Team-Gate-Test-T038-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T038-Exit' } }

		stage('Team-Gate-T038-Exit') { steps { sh './ci.sh Team-Gate-T038-Exit' } }

		stage('Team-Gate-T038-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T038-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
