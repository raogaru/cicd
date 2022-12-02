// ######################################################################
pipelineJob('DEMO-CI-team-gate-T026') {
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
		vTEAM = 'T026'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T026-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T026-START' } } 

		stage('Team-Gate-T026-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T026',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T026-Enter') 		{ steps { sh './ci.sh Team-Gate-T026-Enter' } }

		stage('Team-Gate-Build-T026-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T026-Enter' } }
		stage('Team-Gate-Build-T026-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T026-DB1' } }
		stage('Team-Gate-Build-T026-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T026-DB2' } }
		stage('Team-Gate-Build-T026-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T026-WWW' } }
		stage('Team-Gate-Build-T026-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T026-APP1' } }
		stage('Team-Gate-Build-T026-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T026-APP2' } }
		stage('Team-Gate-Build-T026-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T026-APP3' } }
		stage('Team-Gate-Build-T026-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T026-' } }

		stage('Team-Gate-Deploy-T026-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T026-Enter' } }
		stage('Team-Gate-Deploy-T026-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T026-DB1' } }
		stage('Team-Gate-Deploy-T026-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T026-DB2' } }
		stage('Team-Gate-Deploy-T026-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T026-WWW' } }
		stage('Team-Gate-Deploy-T026-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T026-APP1' } }
		stage('Team-Gate-Deploy-T026-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T026-APP2' } }
		stage('Team-Gate-Deploy-T026-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T026-APP3' } }
		stage('Team-Gate-Deploy-T026-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T026-Exit' } }

		stage('Team-Gate-Test-T026-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T026-Enter' } }
		stage('Team-Gate-Test-T026-Functional') { steps { sh './ci.sh Team-Gate-Test-T026-Functional' } }
		stage('Team-Gate-Test-T026-Performance'){ steps { sh './ci.sh Team-Gate-Test-T026-Performance' } }
		stage('Team-Gate-Test-T026-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T026-Security' } }
		stage('Team-Gate-Test-T026-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T026-Exit' } }

		stage('Team-Gate-T026-Exit') { steps { sh './ci.sh Team-Gate-T026-Exit' } }

		stage('Team-Gate-T026-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T026-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
