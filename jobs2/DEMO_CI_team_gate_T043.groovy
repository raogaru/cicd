// ######################################################################
pipelineJob('DEMO-CI-team-gate-T043') {
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
		vTEAM = 'T043'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T043-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T043-START' } } 

		stage('Team-Gate-T043-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T043',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T043-Enter') 		{ steps { sh './ci.sh Team-Gate-T043-Enter' } }

		stage('Team-Gate-Build-T043-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T043-Enter' } }
		stage('Team-Gate-Build-T043-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T043-DB1' } }
		stage('Team-Gate-Build-T043-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T043-DB2' } }
		stage('Team-Gate-Build-T043-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T043-WWW' } }
		stage('Team-Gate-Build-T043-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T043-APP1' } }
		stage('Team-Gate-Build-T043-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T043-APP2' } }
		stage('Team-Gate-Build-T043-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T043-APP3' } }
		stage('Team-Gate-Build-T043-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T043-' } }

		stage('Team-Gate-Deploy-T043-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T043-Enter' } }
		stage('Team-Gate-Deploy-T043-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T043-DB1' } }
		stage('Team-Gate-Deploy-T043-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T043-DB2' } }
		stage('Team-Gate-Deploy-T043-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T043-WWW' } }
		stage('Team-Gate-Deploy-T043-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T043-APP1' } }
		stage('Team-Gate-Deploy-T043-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T043-APP2' } }
		stage('Team-Gate-Deploy-T043-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T043-APP3' } }
		stage('Team-Gate-Deploy-T043-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T043-Exit' } }

		stage('Team-Gate-Test-T043-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T043-Enter' } }
		stage('Team-Gate-Test-T043-Functional') { steps { sh './ci.sh Team-Gate-Test-T043-Functional' } }
		stage('Team-Gate-Test-T043-Performance'){ steps { sh './ci.sh Team-Gate-Test-T043-Performance' } }
		stage('Team-Gate-Test-T043-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T043-Security' } }
		stage('Team-Gate-Test-T043-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T043-Exit' } }

		stage('Team-Gate-T043-Exit') { steps { sh './ci.sh Team-Gate-T043-Exit' } }

		stage('Team-Gate-T043-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T043-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
