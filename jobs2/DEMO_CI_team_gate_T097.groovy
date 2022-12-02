// ######################################################################
pipelineJob('DEMO-CI-team-gate-T097') {
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
		vTEAM = 'T097'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T097-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T097-START' } } 

		stage('Team-Gate-T097-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T097',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T097-Enter') 		{ steps { sh './ci.sh Team-Gate-T097-Enter' } }

		stage('Team-Gate-Build-T097-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T097-Enter' } }
		stage('Team-Gate-Build-T097-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T097-DB1' } }
		stage('Team-Gate-Build-T097-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T097-DB2' } }
		stage('Team-Gate-Build-T097-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T097-WWW' } }
		stage('Team-Gate-Build-T097-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T097-APP1' } }
		stage('Team-Gate-Build-T097-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T097-APP2' } }
		stage('Team-Gate-Build-T097-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T097-APP3' } }
		stage('Team-Gate-Build-T097-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T097-' } }

		stage('Team-Gate-Deploy-T097-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T097-Enter' } }
		stage('Team-Gate-Deploy-T097-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T097-DB1' } }
		stage('Team-Gate-Deploy-T097-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T097-DB2' } }
		stage('Team-Gate-Deploy-T097-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T097-WWW' } }
		stage('Team-Gate-Deploy-T097-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T097-APP1' } }
		stage('Team-Gate-Deploy-T097-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T097-APP2' } }
		stage('Team-Gate-Deploy-T097-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T097-APP3' } }
		stage('Team-Gate-Deploy-T097-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T097-Exit' } }

		stage('Team-Gate-Test-T097-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T097-Enter' } }
		stage('Team-Gate-Test-T097-Functional') { steps { sh './ci.sh Team-Gate-Test-T097-Functional' } }
		stage('Team-Gate-Test-T097-Performance'){ steps { sh './ci.sh Team-Gate-Test-T097-Performance' } }
		stage('Team-Gate-Test-T097-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T097-Security' } }
		stage('Team-Gate-Test-T097-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T097-Exit' } }

		stage('Team-Gate-T097-Exit') { steps { sh './ci.sh Team-Gate-T097-Exit' } }

		stage('Team-Gate-T097-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T097-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
