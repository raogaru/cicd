// ######################################################################
pipelineJob('DEMO-CI-team-gate-T010') {
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
		vTEAM = 'T010'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T010-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T010-START' } } 

		stage('Team-Gate-T010-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T010',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T010-Enter') 		{ steps { sh './ci.sh Team-Gate-T010-Enter' } }

		stage('Team-Gate-Build-T010-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T010-Enter' } }
		stage('Team-Gate-Build-T010-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T010-DB1' } }
		stage('Team-Gate-Build-T010-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T010-DB2' } }
		stage('Team-Gate-Build-T010-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T010-WWW' } }
		stage('Team-Gate-Build-T010-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T010-APP1' } }
		stage('Team-Gate-Build-T010-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T010-APP2' } }
		stage('Team-Gate-Build-T010-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T010-APP3' } }
		stage('Team-Gate-Build-T010-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T010-' } }

		stage('Team-Gate-Deploy-T010-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T010-Enter' } }
		stage('Team-Gate-Deploy-T010-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T010-DB1' } }
		stage('Team-Gate-Deploy-T010-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T010-DB2' } }
		stage('Team-Gate-Deploy-T010-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T010-WWW' } }
		stage('Team-Gate-Deploy-T010-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T010-APP1' } }
		stage('Team-Gate-Deploy-T010-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T010-APP2' } }
		stage('Team-Gate-Deploy-T010-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T010-APP3' } }
		stage('Team-Gate-Deploy-T010-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T010-Exit' } }

		stage('Team-Gate-Test-T010-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T010-Enter' } }
		stage('Team-Gate-Test-T010-Functional') { steps { sh './ci.sh Team-Gate-Test-T010-Functional' } }
		stage('Team-Gate-Test-T010-Performance'){ steps { sh './ci.sh Team-Gate-Test-T010-Performance' } }
		stage('Team-Gate-Test-T010-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T010-Security' } }
		stage('Team-Gate-Test-T010-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T010-Exit' } }

		stage('Team-Gate-T010-Exit') { steps { sh './ci.sh Team-Gate-T010-Exit' } }

		stage('Team-Gate-T010-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T010-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
