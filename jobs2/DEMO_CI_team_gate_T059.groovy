// ######################################################################
pipelineJob('DEMO-CI-team-gate-T059') {
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
		vTEAM = 'T059'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T059-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T059-START' } } 

		stage('Team-Gate-T059-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T059',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T059-Enter') 		{ steps { sh './ci.sh Team-Gate-T059-Enter' } }

		stage('Team-Gate-Build-T059-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T059-Enter' } }
		stage('Team-Gate-Build-T059-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T059-DB1' } }
		stage('Team-Gate-Build-T059-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T059-DB2' } }
		stage('Team-Gate-Build-T059-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T059-WWW' } }
		stage('Team-Gate-Build-T059-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T059-APP1' } }
		stage('Team-Gate-Build-T059-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T059-APP2' } }
		stage('Team-Gate-Build-T059-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T059-APP3' } }
		stage('Team-Gate-Build-T059-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T059-' } }

		stage('Team-Gate-Deploy-T059-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T059-Enter' } }
		stage('Team-Gate-Deploy-T059-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T059-DB1' } }
		stage('Team-Gate-Deploy-T059-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T059-DB2' } }
		stage('Team-Gate-Deploy-T059-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T059-WWW' } }
		stage('Team-Gate-Deploy-T059-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T059-APP1' } }
		stage('Team-Gate-Deploy-T059-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T059-APP2' } }
		stage('Team-Gate-Deploy-T059-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T059-APP3' } }
		stage('Team-Gate-Deploy-T059-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T059-Exit' } }

		stage('Team-Gate-Test-T059-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T059-Enter' } }
		stage('Team-Gate-Test-T059-Functional') { steps { sh './ci.sh Team-Gate-Test-T059-Functional' } }
		stage('Team-Gate-Test-T059-Performance'){ steps { sh './ci.sh Team-Gate-Test-T059-Performance' } }
		stage('Team-Gate-Test-T059-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T059-Security' } }
		stage('Team-Gate-Test-T059-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T059-Exit' } }

		stage('Team-Gate-T059-Exit') { steps { sh './ci.sh Team-Gate-T059-Exit' } }

		stage('Team-Gate-T059-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T059-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
