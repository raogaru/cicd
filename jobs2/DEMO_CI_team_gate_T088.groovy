// ######################################################################
pipelineJob('DEMO-CI-team-gate-T088') {
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
		vTEAM = 'T088'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T088-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T088-START' } } 

		stage('Team-Gate-T088-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T088',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T088-Enter') 		{ steps { sh './ci.sh Team-Gate-T088-Enter' } }

		stage('Team-Gate-Build-T088-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T088-Enter' } }
		stage('Team-Gate-Build-T088-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T088-DB1' } }
		stage('Team-Gate-Build-T088-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T088-DB2' } }
		stage('Team-Gate-Build-T088-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T088-WWW' } }
		stage('Team-Gate-Build-T088-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T088-APP1' } }
		stage('Team-Gate-Build-T088-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T088-APP2' } }
		stage('Team-Gate-Build-T088-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T088-APP3' } }
		stage('Team-Gate-Build-T088-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T088-' } }

		stage('Team-Gate-Deploy-T088-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T088-Enter' } }
		stage('Team-Gate-Deploy-T088-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T088-DB1' } }
		stage('Team-Gate-Deploy-T088-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T088-DB2' } }
		stage('Team-Gate-Deploy-T088-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T088-WWW' } }
		stage('Team-Gate-Deploy-T088-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T088-APP1' } }
		stage('Team-Gate-Deploy-T088-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T088-APP2' } }
		stage('Team-Gate-Deploy-T088-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T088-APP3' } }
		stage('Team-Gate-Deploy-T088-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T088-Exit' } }

		stage('Team-Gate-Test-T088-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T088-Enter' } }
		stage('Team-Gate-Test-T088-Functional') { steps { sh './ci.sh Team-Gate-Test-T088-Functional' } }
		stage('Team-Gate-Test-T088-Performance'){ steps { sh './ci.sh Team-Gate-Test-T088-Performance' } }
		stage('Team-Gate-Test-T088-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T088-Security' } }
		stage('Team-Gate-Test-T088-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T088-Exit' } }

		stage('Team-Gate-T088-Exit') { steps { sh './ci.sh Team-Gate-T088-Exit' } }

		stage('Team-Gate-T088-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T088-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
