// ######################################################################
pipelineJob('DEMO-CI-team-gate-T017') {
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
		vTEAM = 'T017'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T017-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T017-START' } } 

		stage('Team-Gate-T017-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T017',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T017-Enter') 		{ steps { sh './ci.sh Team-Gate-T017-Enter' } }

		stage('Team-Gate-Build-T017-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T017-Enter' } }
		stage('Team-Gate-Build-T017-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T017-DB1' } }
		stage('Team-Gate-Build-T017-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T017-DB2' } }
		stage('Team-Gate-Build-T017-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T017-WWW' } }
		stage('Team-Gate-Build-T017-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T017-APP1' } }
		stage('Team-Gate-Build-T017-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T017-APP2' } }
		stage('Team-Gate-Build-T017-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T017-APP3' } }
		stage('Team-Gate-Build-T017-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T017-' } }

		stage('Team-Gate-Deploy-T017-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T017-Enter' } }
		stage('Team-Gate-Deploy-T017-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T017-DB1' } }
		stage('Team-Gate-Deploy-T017-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T017-DB2' } }
		stage('Team-Gate-Deploy-T017-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T017-WWW' } }
		stage('Team-Gate-Deploy-T017-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T017-APP1' } }
		stage('Team-Gate-Deploy-T017-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T017-APP2' } }
		stage('Team-Gate-Deploy-T017-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T017-APP3' } }
		stage('Team-Gate-Deploy-T017-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T017-Exit' } }

		stage('Team-Gate-Test-T017-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T017-Enter' } }
		stage('Team-Gate-Test-T017-Functional') { steps { sh './ci.sh Team-Gate-Test-T017-Functional' } }
		stage('Team-Gate-Test-T017-Performance'){ steps { sh './ci.sh Team-Gate-Test-T017-Performance' } }
		stage('Team-Gate-Test-T017-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T017-Security' } }
		stage('Team-Gate-Test-T017-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T017-Exit' } }

		stage('Team-Gate-T017-Exit') { steps { sh './ci.sh Team-Gate-T017-Exit' } }

		stage('Team-Gate-T017-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T017-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
