// ######################################################################
pipelineJob('DEMO-CI-team-gate-T035') {
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
		vTEAM = 'T035'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T035-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T035-START' } } 

		stage('Team-Gate-T035-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T035',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T035-Enter') 		{ steps { sh './ci.sh Team-Gate-T035-Enter' } }

		stage('Team-Gate-Build-T035-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T035-Enter' } }
		stage('Team-Gate-Build-T035-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T035-DB1' } }
		stage('Team-Gate-Build-T035-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T035-DB2' } }
		stage('Team-Gate-Build-T035-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T035-WWW' } }
		stage('Team-Gate-Build-T035-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T035-APP1' } }
		stage('Team-Gate-Build-T035-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T035-APP2' } }
		stage('Team-Gate-Build-T035-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T035-APP3' } }
		stage('Team-Gate-Build-T035-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T035-' } }

		stage('Team-Gate-Deploy-T035-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T035-Enter' } }
		stage('Team-Gate-Deploy-T035-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T035-DB1' } }
		stage('Team-Gate-Deploy-T035-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T035-DB2' } }
		stage('Team-Gate-Deploy-T035-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T035-WWW' } }
		stage('Team-Gate-Deploy-T035-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T035-APP1' } }
		stage('Team-Gate-Deploy-T035-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T035-APP2' } }
		stage('Team-Gate-Deploy-T035-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T035-APP3' } }
		stage('Team-Gate-Deploy-T035-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T035-Exit' } }

		stage('Team-Gate-Test-T035-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T035-Enter' } }
		stage('Team-Gate-Test-T035-Functional') { steps { sh './ci.sh Team-Gate-Test-T035-Functional' } }
		stage('Team-Gate-Test-T035-Performance'){ steps { sh './ci.sh Team-Gate-Test-T035-Performance' } }
		stage('Team-Gate-Test-T035-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T035-Security' } }
		stage('Team-Gate-Test-T035-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T035-Exit' } }

		stage('Team-Gate-T035-Exit') { steps { sh './ci.sh Team-Gate-T035-Exit' } }

		stage('Team-Gate-T035-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T035-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
