// ######################################################################
pipelineJob('DEMO-CI-team-gate-T012') {
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
		vTEAM = 'T012'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T012-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T012-START' } } 

		stage('Team-Gate-T012-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T012',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T012-Enter') 		{ steps { sh './ci.sh Team-Gate-T012-Enter' } }

		stage('Team-Gate-Build-T012-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T012-Enter' } }
		stage('Team-Gate-Build-T012-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T012-DB1' } }
		stage('Team-Gate-Build-T012-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T012-DB2' } }
		stage('Team-Gate-Build-T012-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T012-WWW' } }
		stage('Team-Gate-Build-T012-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T012-APP1' } }
		stage('Team-Gate-Build-T012-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T012-APP2' } }
		stage('Team-Gate-Build-T012-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T012-APP3' } }
		stage('Team-Gate-Build-T012-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T012-' } }

		stage('Team-Gate-Deploy-T012-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T012-Enter' } }
		stage('Team-Gate-Deploy-T012-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T012-DB1' } }
		stage('Team-Gate-Deploy-T012-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T012-DB2' } }
		stage('Team-Gate-Deploy-T012-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T012-WWW' } }
		stage('Team-Gate-Deploy-T012-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T012-APP1' } }
		stage('Team-Gate-Deploy-T012-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T012-APP2' } }
		stage('Team-Gate-Deploy-T012-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T012-APP3' } }
		stage('Team-Gate-Deploy-T012-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T012-Exit' } }

		stage('Team-Gate-Test-T012-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T012-Enter' } }
		stage('Team-Gate-Test-T012-Functional') { steps { sh './ci.sh Team-Gate-Test-T012-Functional' } }
		stage('Team-Gate-Test-T012-Performance'){ steps { sh './ci.sh Team-Gate-Test-T012-Performance' } }
		stage('Team-Gate-Test-T012-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T012-Security' } }
		stage('Team-Gate-Test-T012-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T012-Exit' } }

		stage('Team-Gate-T012-Exit') { steps { sh './ci.sh Team-Gate-T012-Exit' } }

		stage('Team-Gate-T012-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T012-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
