// ######################################################################
pipelineJob('DEMO-CI-team-gate-T063') {
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
		vTEAM = 'T063'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T063-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T063-START' } } 

		stage('Team-Gate-T063-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T063',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T063-Enter') 		{ steps { sh './ci.sh Team-Gate-T063-Enter' } }

		stage('Team-Gate-Build-T063-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T063-Enter' } }
		stage('Team-Gate-Build-T063-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T063-DB1' } }
		stage('Team-Gate-Build-T063-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T063-DB2' } }
		stage('Team-Gate-Build-T063-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T063-WWW' } }
		stage('Team-Gate-Build-T063-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T063-APP1' } }
		stage('Team-Gate-Build-T063-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T063-APP2' } }
		stage('Team-Gate-Build-T063-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T063-APP3' } }
		stage('Team-Gate-Build-T063-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T063-' } }

		stage('Team-Gate-Deploy-T063-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T063-Enter' } }
		stage('Team-Gate-Deploy-T063-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T063-DB1' } }
		stage('Team-Gate-Deploy-T063-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T063-DB2' } }
		stage('Team-Gate-Deploy-T063-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T063-WWW' } }
		stage('Team-Gate-Deploy-T063-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T063-APP1' } }
		stage('Team-Gate-Deploy-T063-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T063-APP2' } }
		stage('Team-Gate-Deploy-T063-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T063-APP3' } }
		stage('Team-Gate-Deploy-T063-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T063-Exit' } }

		stage('Team-Gate-Test-T063-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T063-Enter' } }
		stage('Team-Gate-Test-T063-Functional') { steps { sh './ci.sh Team-Gate-Test-T063-Functional' } }
		stage('Team-Gate-Test-T063-Performance'){ steps { sh './ci.sh Team-Gate-Test-T063-Performance' } }
		stage('Team-Gate-Test-T063-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T063-Security' } }
		stage('Team-Gate-Test-T063-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T063-Exit' } }

		stage('Team-Gate-T063-Exit') { steps { sh './ci.sh Team-Gate-T063-Exit' } }

		stage('Team-Gate-T063-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T063-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
