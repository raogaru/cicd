// ######################################################################
pipelineJob('DEMO-CI-team-gate-T009') {
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
		vTEAM = 'T009'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T009-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T009-START' } } 

		stage('Team-Gate-T009-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T009',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T009-Enter') 		{ steps { sh './ci.sh Team-Gate-T009-Enter' } }

		stage('Team-Gate-Build-T009-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T009-Enter' } }
		stage('Team-Gate-Build-T009-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T009-DB1' } }
		stage('Team-Gate-Build-T009-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T009-DB2' } }
		stage('Team-Gate-Build-T009-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T009-WWW' } }
		stage('Team-Gate-Build-T009-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T009-APP1' } }
		stage('Team-Gate-Build-T009-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T009-APP2' } }
		stage('Team-Gate-Build-T009-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T009-APP3' } }
		stage('Team-Gate-Build-T009-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T009-' } }

		stage('Team-Gate-Deploy-T009-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T009-Enter' } }
		stage('Team-Gate-Deploy-T009-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T009-DB1' } }
		stage('Team-Gate-Deploy-T009-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T009-DB2' } }
		stage('Team-Gate-Deploy-T009-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T009-WWW' } }
		stage('Team-Gate-Deploy-T009-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T009-APP1' } }
		stage('Team-Gate-Deploy-T009-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T009-APP2' } }
		stage('Team-Gate-Deploy-T009-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T009-APP3' } }
		stage('Team-Gate-Deploy-T009-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T009-Exit' } }

		stage('Team-Gate-Test-T009-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T009-Enter' } }
		stage('Team-Gate-Test-T009-Functional') { steps { sh './ci.sh Team-Gate-Test-T009-Functional' } }
		stage('Team-Gate-Test-T009-Performance'){ steps { sh './ci.sh Team-Gate-Test-T009-Performance' } }
		stage('Team-Gate-Test-T009-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T009-Security' } }
		stage('Team-Gate-Test-T009-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T009-Exit' } }

		stage('Team-Gate-T009-Exit') { steps { sh './ci.sh Team-Gate-T009-Exit' } }

		stage('Team-Gate-T009-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T009-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
