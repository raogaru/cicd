// ######################################################################
pipelineJob('DEMO-CI-team-gate-T094') {
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
		vTEAM = 'T094'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T094-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T094-START' } } 

		stage('Team-Gate-T094-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T094',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T094-Enter') 		{ steps { sh './ci.sh Team-Gate-T094-Enter' } }

		stage('Team-Gate-Build-T094-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T094-Enter' } }
		stage('Team-Gate-Build-T094-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T094-DB1' } }
		stage('Team-Gate-Build-T094-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T094-DB2' } }
		stage('Team-Gate-Build-T094-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T094-WWW' } }
		stage('Team-Gate-Build-T094-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T094-APP1' } }
		stage('Team-Gate-Build-T094-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T094-APP2' } }
		stage('Team-Gate-Build-T094-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T094-APP3' } }
		stage('Team-Gate-Build-T094-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T094-' } }

		stage('Team-Gate-Deploy-T094-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T094-Enter' } }
		stage('Team-Gate-Deploy-T094-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T094-DB1' } }
		stage('Team-Gate-Deploy-T094-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T094-DB2' } }
		stage('Team-Gate-Deploy-T094-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T094-WWW' } }
		stage('Team-Gate-Deploy-T094-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T094-APP1' } }
		stage('Team-Gate-Deploy-T094-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T094-APP2' } }
		stage('Team-Gate-Deploy-T094-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T094-APP3' } }
		stage('Team-Gate-Deploy-T094-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T094-Exit' } }

		stage('Team-Gate-Test-T094-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T094-Enter' } }
		stage('Team-Gate-Test-T094-Functional') { steps { sh './ci.sh Team-Gate-Test-T094-Functional' } }
		stage('Team-Gate-Test-T094-Performance'){ steps { sh './ci.sh Team-Gate-Test-T094-Performance' } }
		stage('Team-Gate-Test-T094-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T094-Security' } }
		stage('Team-Gate-Test-T094-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T094-Exit' } }

		stage('Team-Gate-T094-Exit') { steps { sh './ci.sh Team-Gate-T094-Exit' } }

		stage('Team-Gate-T094-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T094-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
