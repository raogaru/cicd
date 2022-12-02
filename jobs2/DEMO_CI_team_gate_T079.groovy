// ######################################################################
pipelineJob('DEMO-CI-team-gate-T079') {
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
		vTEAM = 'T079'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T079-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T079-START' } } 

		stage('Team-Gate-T079-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T079',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T079-Enter') 		{ steps { sh './ci.sh Team-Gate-T079-Enter' } }

		stage('Team-Gate-Build-T079-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T079-Enter' } }
		stage('Team-Gate-Build-T079-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T079-DB1' } }
		stage('Team-Gate-Build-T079-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T079-DB2' } }
		stage('Team-Gate-Build-T079-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T079-WWW' } }
		stage('Team-Gate-Build-T079-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T079-APP1' } }
		stage('Team-Gate-Build-T079-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T079-APP2' } }
		stage('Team-Gate-Build-T079-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T079-APP3' } }
		stage('Team-Gate-Build-T079-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T079-' } }

		stage('Team-Gate-Deploy-T079-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T079-Enter' } }
		stage('Team-Gate-Deploy-T079-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T079-DB1' } }
		stage('Team-Gate-Deploy-T079-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T079-DB2' } }
		stage('Team-Gate-Deploy-T079-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T079-WWW' } }
		stage('Team-Gate-Deploy-T079-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T079-APP1' } }
		stage('Team-Gate-Deploy-T079-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T079-APP2' } }
		stage('Team-Gate-Deploy-T079-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T079-APP3' } }
		stage('Team-Gate-Deploy-T079-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T079-Exit' } }

		stage('Team-Gate-Test-T079-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T079-Enter' } }
		stage('Team-Gate-Test-T079-Functional') { steps { sh './ci.sh Team-Gate-Test-T079-Functional' } }
		stage('Team-Gate-Test-T079-Performance'){ steps { sh './ci.sh Team-Gate-Test-T079-Performance' } }
		stage('Team-Gate-Test-T079-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T079-Security' } }
		stage('Team-Gate-Test-T079-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T079-Exit' } }

		stage('Team-Gate-T079-Exit') { steps { sh './ci.sh Team-Gate-T079-Exit' } }

		stage('Team-Gate-T079-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T079-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
