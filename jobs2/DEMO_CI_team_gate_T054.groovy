// ######################################################################
pipelineJob('DEMO-CI-team-gate-T054') {
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
		vTEAM = 'T054'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T054-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T054-START' } } 

		stage('Team-Gate-T054-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T054',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T054-Enter') 		{ steps { sh './ci.sh Team-Gate-T054-Enter' } }

		stage('Team-Gate-Build-T054-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T054-Enter' } }
		stage('Team-Gate-Build-T054-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T054-DB1' } }
		stage('Team-Gate-Build-T054-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T054-DB2' } }
		stage('Team-Gate-Build-T054-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T054-WWW' } }
		stage('Team-Gate-Build-T054-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T054-APP1' } }
		stage('Team-Gate-Build-T054-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T054-APP2' } }
		stage('Team-Gate-Build-T054-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T054-APP3' } }
		stage('Team-Gate-Build-T054-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T054-' } }

		stage('Team-Gate-Deploy-T054-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T054-Enter' } }
		stage('Team-Gate-Deploy-T054-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T054-DB1' } }
		stage('Team-Gate-Deploy-T054-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T054-DB2' } }
		stage('Team-Gate-Deploy-T054-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T054-WWW' } }
		stage('Team-Gate-Deploy-T054-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T054-APP1' } }
		stage('Team-Gate-Deploy-T054-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T054-APP2' } }
		stage('Team-Gate-Deploy-T054-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T054-APP3' } }
		stage('Team-Gate-Deploy-T054-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T054-Exit' } }

		stage('Team-Gate-Test-T054-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T054-Enter' } }
		stage('Team-Gate-Test-T054-Functional') { steps { sh './ci.sh Team-Gate-Test-T054-Functional' } }
		stage('Team-Gate-Test-T054-Performance'){ steps { sh './ci.sh Team-Gate-Test-T054-Performance' } }
		stage('Team-Gate-Test-T054-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T054-Security' } }
		stage('Team-Gate-Test-T054-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T054-Exit' } }

		stage('Team-Gate-T054-Exit') { steps { sh './ci.sh Team-Gate-T054-Exit' } }

		stage('Team-Gate-T054-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T054-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
