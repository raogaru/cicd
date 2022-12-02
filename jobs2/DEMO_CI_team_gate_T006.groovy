// ######################################################################
pipelineJob('DEMO-CI-team-gate-T006') {
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
		vTEAM = 'T006'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T006-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T006-START' } } 

		stage('Team-Gate-T006-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T006',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T006-Enter') 		{ steps { sh './ci.sh Team-Gate-T006-Enter' } }

		stage('Team-Gate-Build-T006-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T006-Enter' } }
		stage('Team-Gate-Build-T006-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T006-DB1' } }
		stage('Team-Gate-Build-T006-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T006-DB2' } }
		stage('Team-Gate-Build-T006-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T006-WWW' } }
		stage('Team-Gate-Build-T006-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T006-APP1' } }
		stage('Team-Gate-Build-T006-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T006-APP2' } }
		stage('Team-Gate-Build-T006-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T006-APP3' } }
		stage('Team-Gate-Build-T006-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T006-' } }

		stage('Team-Gate-Deploy-T006-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T006-Enter' } }
		stage('Team-Gate-Deploy-T006-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T006-DB1' } }
		stage('Team-Gate-Deploy-T006-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T006-DB2' } }
		stage('Team-Gate-Deploy-T006-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T006-WWW' } }
		stage('Team-Gate-Deploy-T006-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T006-APP1' } }
		stage('Team-Gate-Deploy-T006-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T006-APP2' } }
		stage('Team-Gate-Deploy-T006-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T006-APP3' } }
		stage('Team-Gate-Deploy-T006-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T006-Exit' } }

		stage('Team-Gate-Test-T006-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T006-Enter' } }
		stage('Team-Gate-Test-T006-Functional') { steps { sh './ci.sh Team-Gate-Test-T006-Functional' } }
		stage('Team-Gate-Test-T006-Performance'){ steps { sh './ci.sh Team-Gate-Test-T006-Performance' } }
		stage('Team-Gate-Test-T006-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T006-Security' } }
		stage('Team-Gate-Test-T006-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T006-Exit' } }

		stage('Team-Gate-T006-Exit') { steps { sh './ci.sh Team-Gate-T006-Exit' } }

		stage('Team-Gate-T006-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T006-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
