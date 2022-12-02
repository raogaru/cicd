// ######################################################################
pipelineJob('DEMO-CI-team-gate-T030') {
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
		vTEAM = 'T030'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T030-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T030-START' } } 

		stage('Team-Gate-T030-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T030',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T030-Enter') 		{ steps { sh './ci.sh Team-Gate-T030-Enter' } }

		stage('Team-Gate-Build-T030-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T030-Enter' } }
		stage('Team-Gate-Build-T030-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T030-DB1' } }
		stage('Team-Gate-Build-T030-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T030-DB2' } }
		stage('Team-Gate-Build-T030-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T030-WWW' } }
		stage('Team-Gate-Build-T030-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T030-APP1' } }
		stage('Team-Gate-Build-T030-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T030-APP2' } }
		stage('Team-Gate-Build-T030-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T030-APP3' } }
		stage('Team-Gate-Build-T030-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T030-' } }

		stage('Team-Gate-Deploy-T030-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T030-Enter' } }
		stage('Team-Gate-Deploy-T030-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T030-DB1' } }
		stage('Team-Gate-Deploy-T030-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T030-DB2' } }
		stage('Team-Gate-Deploy-T030-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T030-WWW' } }
		stage('Team-Gate-Deploy-T030-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T030-APP1' } }
		stage('Team-Gate-Deploy-T030-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T030-APP2' } }
		stage('Team-Gate-Deploy-T030-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T030-APP3' } }
		stage('Team-Gate-Deploy-T030-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T030-Exit' } }

		stage('Team-Gate-Test-T030-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T030-Enter' } }
		stage('Team-Gate-Test-T030-Functional') { steps { sh './ci.sh Team-Gate-Test-T030-Functional' } }
		stage('Team-Gate-Test-T030-Performance'){ steps { sh './ci.sh Team-Gate-Test-T030-Performance' } }
		stage('Team-Gate-Test-T030-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T030-Security' } }
		stage('Team-Gate-Test-T030-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T030-Exit' } }

		stage('Team-Gate-T030-Exit') { steps { sh './ci.sh Team-Gate-T030-Exit' } }

		stage('Team-Gate-T030-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T030-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
