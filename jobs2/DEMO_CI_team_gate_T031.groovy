// ######################################################################
pipelineJob('DEMO-CI-team-gate-T031') {
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
		vTEAM = 'T031'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T031-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T031-START' } } 

		stage('Team-Gate-T031-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T031',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T031-Enter') 		{ steps { sh './ci.sh Team-Gate-T031-Enter' } }

		stage('Team-Gate-Build-T031-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T031-Enter' } }
		stage('Team-Gate-Build-T031-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T031-DB1' } }
		stage('Team-Gate-Build-T031-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T031-DB2' } }
		stage('Team-Gate-Build-T031-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T031-WWW' } }
		stage('Team-Gate-Build-T031-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T031-APP1' } }
		stage('Team-Gate-Build-T031-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T031-APP2' } }
		stage('Team-Gate-Build-T031-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T031-APP3' } }
		stage('Team-Gate-Build-T031-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T031-' } }

		stage('Team-Gate-Deploy-T031-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T031-Enter' } }
		stage('Team-Gate-Deploy-T031-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T031-DB1' } }
		stage('Team-Gate-Deploy-T031-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T031-DB2' } }
		stage('Team-Gate-Deploy-T031-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T031-WWW' } }
		stage('Team-Gate-Deploy-T031-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T031-APP1' } }
		stage('Team-Gate-Deploy-T031-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T031-APP2' } }
		stage('Team-Gate-Deploy-T031-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T031-APP3' } }
		stage('Team-Gate-Deploy-T031-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T031-Exit' } }

		stage('Team-Gate-Test-T031-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T031-Enter' } }
		stage('Team-Gate-Test-T031-Functional') { steps { sh './ci.sh Team-Gate-Test-T031-Functional' } }
		stage('Team-Gate-Test-T031-Performance'){ steps { sh './ci.sh Team-Gate-Test-T031-Performance' } }
		stage('Team-Gate-Test-T031-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T031-Security' } }
		stage('Team-Gate-Test-T031-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T031-Exit' } }

		stage('Team-Gate-T031-Exit') { steps { sh './ci.sh Team-Gate-T031-Exit' } }

		stage('Team-Gate-T031-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T031-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
