// ######################################################################
pipelineJob('DEMO-CI-team-gate-T034') {
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
		vTEAM = 'T034'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T034-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T034-START' } } 

		stage('Team-Gate-T034-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T034',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T034-Enter') 		{ steps { sh './ci.sh Team-Gate-T034-Enter' } }

		stage('Team-Gate-Build-T034-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T034-Enter' } }
		stage('Team-Gate-Build-T034-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T034-DB1' } }
		stage('Team-Gate-Build-T034-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T034-DB2' } }
		stage('Team-Gate-Build-T034-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T034-WWW' } }
		stage('Team-Gate-Build-T034-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T034-APP1' } }
		stage('Team-Gate-Build-T034-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T034-APP2' } }
		stage('Team-Gate-Build-T034-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T034-APP3' } }
		stage('Team-Gate-Build-T034-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T034-' } }

		stage('Team-Gate-Deploy-T034-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T034-Enter' } }
		stage('Team-Gate-Deploy-T034-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T034-DB1' } }
		stage('Team-Gate-Deploy-T034-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T034-DB2' } }
		stage('Team-Gate-Deploy-T034-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T034-WWW' } }
		stage('Team-Gate-Deploy-T034-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T034-APP1' } }
		stage('Team-Gate-Deploy-T034-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T034-APP2' } }
		stage('Team-Gate-Deploy-T034-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T034-APP3' } }
		stage('Team-Gate-Deploy-T034-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T034-Exit' } }

		stage('Team-Gate-Test-T034-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T034-Enter' } }
		stage('Team-Gate-Test-T034-Functional') { steps { sh './ci.sh Team-Gate-Test-T034-Functional' } }
		stage('Team-Gate-Test-T034-Performance'){ steps { sh './ci.sh Team-Gate-Test-T034-Performance' } }
		stage('Team-Gate-Test-T034-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T034-Security' } }
		stage('Team-Gate-Test-T034-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T034-Exit' } }

		stage('Team-Gate-T034-Exit') { steps { sh './ci.sh Team-Gate-T034-Exit' } }

		stage('Team-Gate-T034-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T034-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
