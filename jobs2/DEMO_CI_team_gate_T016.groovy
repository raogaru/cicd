// ######################################################################
pipelineJob('DEMO-CI-team-gate-T016') {
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
		vTEAM = 'T016'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T016-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T016-START' } } 

		stage('Team-Gate-T016-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T016',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T016-Enter') 		{ steps { sh './ci.sh Team-Gate-T016-Enter' } }

		stage('Team-Gate-Build-T016-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T016-Enter' } }
		stage('Team-Gate-Build-T016-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T016-DB1' } }
		stage('Team-Gate-Build-T016-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T016-DB2' } }
		stage('Team-Gate-Build-T016-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T016-WWW' } }
		stage('Team-Gate-Build-T016-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T016-APP1' } }
		stage('Team-Gate-Build-T016-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T016-APP2' } }
		stage('Team-Gate-Build-T016-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T016-APP3' } }
		stage('Team-Gate-Build-T016-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T016-' } }

		stage('Team-Gate-Deploy-T016-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T016-Enter' } }
		stage('Team-Gate-Deploy-T016-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T016-DB1' } }
		stage('Team-Gate-Deploy-T016-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T016-DB2' } }
		stage('Team-Gate-Deploy-T016-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T016-WWW' } }
		stage('Team-Gate-Deploy-T016-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T016-APP1' } }
		stage('Team-Gate-Deploy-T016-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T016-APP2' } }
		stage('Team-Gate-Deploy-T016-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T016-APP3' } }
		stage('Team-Gate-Deploy-T016-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T016-Exit' } }

		stage('Team-Gate-Test-T016-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T016-Enter' } }
		stage('Team-Gate-Test-T016-Functional') { steps { sh './ci.sh Team-Gate-Test-T016-Functional' } }
		stage('Team-Gate-Test-T016-Performance'){ steps { sh './ci.sh Team-Gate-Test-T016-Performance' } }
		stage('Team-Gate-Test-T016-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T016-Security' } }
		stage('Team-Gate-Test-T016-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T016-Exit' } }

		stage('Team-Gate-T016-Exit') { steps { sh './ci.sh Team-Gate-T016-Exit' } }

		stage('Team-Gate-T016-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T016-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
