// ######################################################################
pipelineJob('DEMO-CI-team-gate-T099') {
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
		vTEAM = 'T099'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T099-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T099-START' } } 

		stage('Team-Gate-T099-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T099',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T099-Enter') 		{ steps { sh './ci.sh Team-Gate-T099-Enter' } }

		stage('Team-Gate-Build-T099-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T099-Enter' } }
		stage('Team-Gate-Build-T099-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T099-DB1' } }
		stage('Team-Gate-Build-T099-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T099-DB2' } }
		stage('Team-Gate-Build-T099-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T099-WWW' } }
		stage('Team-Gate-Build-T099-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T099-APP1' } }
		stage('Team-Gate-Build-T099-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T099-APP2' } }
		stage('Team-Gate-Build-T099-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T099-APP3' } }
		stage('Team-Gate-Build-T099-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T099-' } }

		stage('Team-Gate-Deploy-T099-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T099-Enter' } }
		stage('Team-Gate-Deploy-T099-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T099-DB1' } }
		stage('Team-Gate-Deploy-T099-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T099-DB2' } }
		stage('Team-Gate-Deploy-T099-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T099-WWW' } }
		stage('Team-Gate-Deploy-T099-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T099-APP1' } }
		stage('Team-Gate-Deploy-T099-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T099-APP2' } }
		stage('Team-Gate-Deploy-T099-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T099-APP3' } }
		stage('Team-Gate-Deploy-T099-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T099-Exit' } }

		stage('Team-Gate-Test-T099-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T099-Enter' } }
		stage('Team-Gate-Test-T099-Functional') { steps { sh './ci.sh Team-Gate-Test-T099-Functional' } }
		stage('Team-Gate-Test-T099-Performance'){ steps { sh './ci.sh Team-Gate-Test-T099-Performance' } }
		stage('Team-Gate-Test-T099-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T099-Security' } }
		stage('Team-Gate-Test-T099-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T099-Exit' } }

		stage('Team-Gate-T099-Exit') { steps { sh './ci.sh Team-Gate-T099-Exit' } }

		stage('Team-Gate-T099-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T099-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
