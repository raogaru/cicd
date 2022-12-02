// ######################################################################
pipelineJob('DEMO-CI-team-gate-T029') {
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
		vTEAM = 'T029'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T029-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T029-START' } } 

		stage('Team-Gate-T029-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T029',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T029-Enter') 		{ steps { sh './ci.sh Team-Gate-T029-Enter' } }

		stage('Team-Gate-Build-T029-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T029-Enter' } }
		stage('Team-Gate-Build-T029-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T029-DB1' } }
		stage('Team-Gate-Build-T029-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T029-DB2' } }
		stage('Team-Gate-Build-T029-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T029-WWW' } }
		stage('Team-Gate-Build-T029-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T029-APP1' } }
		stage('Team-Gate-Build-T029-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T029-APP2' } }
		stage('Team-Gate-Build-T029-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T029-APP3' } }
		stage('Team-Gate-Build-T029-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T029-' } }

		stage('Team-Gate-Deploy-T029-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T029-Enter' } }
		stage('Team-Gate-Deploy-T029-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T029-DB1' } }
		stage('Team-Gate-Deploy-T029-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T029-DB2' } }
		stage('Team-Gate-Deploy-T029-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T029-WWW' } }
		stage('Team-Gate-Deploy-T029-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T029-APP1' } }
		stage('Team-Gate-Deploy-T029-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T029-APP2' } }
		stage('Team-Gate-Deploy-T029-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T029-APP3' } }
		stage('Team-Gate-Deploy-T029-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T029-Exit' } }

		stage('Team-Gate-Test-T029-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T029-Enter' } }
		stage('Team-Gate-Test-T029-Functional') { steps { sh './ci.sh Team-Gate-Test-T029-Functional' } }
		stage('Team-Gate-Test-T029-Performance'){ steps { sh './ci.sh Team-Gate-Test-T029-Performance' } }
		stage('Team-Gate-Test-T029-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T029-Security' } }
		stage('Team-Gate-Test-T029-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T029-Exit' } }

		stage('Team-Gate-T029-Exit') { steps { sh './ci.sh Team-Gate-T029-Exit' } }

		stage('Team-Gate-T029-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T029-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
