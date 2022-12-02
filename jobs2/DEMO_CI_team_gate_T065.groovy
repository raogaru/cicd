// ######################################################################
pipelineJob('DEMO-CI-team-gate-T065') {
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
		vTEAM = 'T065'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T065-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T065-START' } } 

		stage('Team-Gate-T065-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T065',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T065-Enter') 		{ steps { sh './ci.sh Team-Gate-T065-Enter' } }

		stage('Team-Gate-Build-T065-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T065-Enter' } }
		stage('Team-Gate-Build-T065-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T065-DB1' } }
		stage('Team-Gate-Build-T065-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T065-DB2' } }
		stage('Team-Gate-Build-T065-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T065-WWW' } }
		stage('Team-Gate-Build-T065-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T065-APP1' } }
		stage('Team-Gate-Build-T065-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T065-APP2' } }
		stage('Team-Gate-Build-T065-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T065-APP3' } }
		stage('Team-Gate-Build-T065-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T065-' } }

		stage('Team-Gate-Deploy-T065-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T065-Enter' } }
		stage('Team-Gate-Deploy-T065-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T065-DB1' } }
		stage('Team-Gate-Deploy-T065-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T065-DB2' } }
		stage('Team-Gate-Deploy-T065-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T065-WWW' } }
		stage('Team-Gate-Deploy-T065-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T065-APP1' } }
		stage('Team-Gate-Deploy-T065-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T065-APP2' } }
		stage('Team-Gate-Deploy-T065-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T065-APP3' } }
		stage('Team-Gate-Deploy-T065-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T065-Exit' } }

		stage('Team-Gate-Test-T065-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T065-Enter' } }
		stage('Team-Gate-Test-T065-Functional') { steps { sh './ci.sh Team-Gate-Test-T065-Functional' } }
		stage('Team-Gate-Test-T065-Performance'){ steps { sh './ci.sh Team-Gate-Test-T065-Performance' } }
		stage('Team-Gate-Test-T065-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T065-Security' } }
		stage('Team-Gate-Test-T065-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T065-Exit' } }

		stage('Team-Gate-T065-Exit') { steps { sh './ci.sh Team-Gate-T065-Exit' } }

		stage('Team-Gate-T065-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T065-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
