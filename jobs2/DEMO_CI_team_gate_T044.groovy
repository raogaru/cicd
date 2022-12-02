// ######################################################################
pipelineJob('DEMO-CI-team-gate-T044') {
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
		vTEAM = 'T044'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T044-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T044-START' } } 

		stage('Team-Gate-T044-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T044',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T044-Enter') 		{ steps { sh './ci.sh Team-Gate-T044-Enter' } }

		stage('Team-Gate-Build-T044-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T044-Enter' } }
		stage('Team-Gate-Build-T044-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T044-DB1' } }
		stage('Team-Gate-Build-T044-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T044-DB2' } }
		stage('Team-Gate-Build-T044-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T044-WWW' } }
		stage('Team-Gate-Build-T044-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T044-APP1' } }
		stage('Team-Gate-Build-T044-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T044-APP2' } }
		stage('Team-Gate-Build-T044-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T044-APP3' } }
		stage('Team-Gate-Build-T044-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T044-' } }

		stage('Team-Gate-Deploy-T044-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T044-Enter' } }
		stage('Team-Gate-Deploy-T044-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T044-DB1' } }
		stage('Team-Gate-Deploy-T044-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T044-DB2' } }
		stage('Team-Gate-Deploy-T044-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T044-WWW' } }
		stage('Team-Gate-Deploy-T044-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T044-APP1' } }
		stage('Team-Gate-Deploy-T044-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T044-APP2' } }
		stage('Team-Gate-Deploy-T044-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T044-APP3' } }
		stage('Team-Gate-Deploy-T044-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T044-Exit' } }

		stage('Team-Gate-Test-T044-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T044-Enter' } }
		stage('Team-Gate-Test-T044-Functional') { steps { sh './ci.sh Team-Gate-Test-T044-Functional' } }
		stage('Team-Gate-Test-T044-Performance'){ steps { sh './ci.sh Team-Gate-Test-T044-Performance' } }
		stage('Team-Gate-Test-T044-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T044-Security' } }
		stage('Team-Gate-Test-T044-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T044-Exit' } }

		stage('Team-Gate-T044-Exit') { steps { sh './ci.sh Team-Gate-T044-Exit' } }

		stage('Team-Gate-T044-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T044-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
