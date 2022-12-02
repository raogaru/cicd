// ######################################################################
pipelineJob('DEMO-CI-team-gate-T040') {
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
		vTEAM = 'T040'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T040-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T040-START' } } 

		stage('Team-Gate-T040-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T040',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T040-Enter') 		{ steps { sh './ci.sh Team-Gate-T040-Enter' } }

		stage('Team-Gate-Build-T040-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T040-Enter' } }
		stage('Team-Gate-Build-T040-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T040-DB1' } }
		stage('Team-Gate-Build-T040-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T040-DB2' } }
		stage('Team-Gate-Build-T040-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T040-WWW' } }
		stage('Team-Gate-Build-T040-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T040-APP1' } }
		stage('Team-Gate-Build-T040-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T040-APP2' } }
		stage('Team-Gate-Build-T040-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T040-APP3' } }
		stage('Team-Gate-Build-T040-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T040-' } }

		stage('Team-Gate-Deploy-T040-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T040-Enter' } }
		stage('Team-Gate-Deploy-T040-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T040-DB1' } }
		stage('Team-Gate-Deploy-T040-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T040-DB2' } }
		stage('Team-Gate-Deploy-T040-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T040-WWW' } }
		stage('Team-Gate-Deploy-T040-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T040-APP1' } }
		stage('Team-Gate-Deploy-T040-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T040-APP2' } }
		stage('Team-Gate-Deploy-T040-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T040-APP3' } }
		stage('Team-Gate-Deploy-T040-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T040-Exit' } }

		stage('Team-Gate-Test-T040-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T040-Enter' } }
		stage('Team-Gate-Test-T040-Functional') { steps { sh './ci.sh Team-Gate-Test-T040-Functional' } }
		stage('Team-Gate-Test-T040-Performance'){ steps { sh './ci.sh Team-Gate-Test-T040-Performance' } }
		stage('Team-Gate-Test-T040-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T040-Security' } }
		stage('Team-Gate-Test-T040-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T040-Exit' } }

		stage('Team-Gate-T040-Exit') { steps { sh './ci.sh Team-Gate-T040-Exit' } }

		stage('Team-Gate-T040-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T040-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
