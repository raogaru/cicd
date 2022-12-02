// ######################################################################
pipelineJob('DEMO-CI-team-gate-T062') {
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
		vTEAM = 'T062'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T062-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T062-START' } } 

		stage('Team-Gate-T062-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T062',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T062-Enter') 		{ steps { sh './ci.sh Team-Gate-T062-Enter' } }

		stage('Team-Gate-Build-T062-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T062-Enter' } }
		stage('Team-Gate-Build-T062-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T062-DB1' } }
		stage('Team-Gate-Build-T062-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T062-DB2' } }
		stage('Team-Gate-Build-T062-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T062-WWW' } }
		stage('Team-Gate-Build-T062-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T062-APP1' } }
		stage('Team-Gate-Build-T062-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T062-APP2' } }
		stage('Team-Gate-Build-T062-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T062-APP3' } }
		stage('Team-Gate-Build-T062-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T062-' } }

		stage('Team-Gate-Deploy-T062-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T062-Enter' } }
		stage('Team-Gate-Deploy-T062-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T062-DB1' } }
		stage('Team-Gate-Deploy-T062-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T062-DB2' } }
		stage('Team-Gate-Deploy-T062-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T062-WWW' } }
		stage('Team-Gate-Deploy-T062-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T062-APP1' } }
		stage('Team-Gate-Deploy-T062-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T062-APP2' } }
		stage('Team-Gate-Deploy-T062-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T062-APP3' } }
		stage('Team-Gate-Deploy-T062-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T062-Exit' } }

		stage('Team-Gate-Test-T062-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T062-Enter' } }
		stage('Team-Gate-Test-T062-Functional') { steps { sh './ci.sh Team-Gate-Test-T062-Functional' } }
		stage('Team-Gate-Test-T062-Performance'){ steps { sh './ci.sh Team-Gate-Test-T062-Performance' } }
		stage('Team-Gate-Test-T062-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T062-Security' } }
		stage('Team-Gate-Test-T062-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T062-Exit' } }

		stage('Team-Gate-T062-Exit') { steps { sh './ci.sh Team-Gate-T062-Exit' } }

		stage('Team-Gate-T062-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T062-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
