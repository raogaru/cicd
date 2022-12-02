// ######################################################################
pipelineJob('DEMO-CI-team-gate-T024') {
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
		vTEAM = 'T024'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T024-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T024-START' } } 

		stage('Team-Gate-T024-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T024',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T024-Enter') 		{ steps { sh './ci.sh Team-Gate-T024-Enter' } }

		stage('Team-Gate-Build-T024-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T024-Enter' } }
		stage('Team-Gate-Build-T024-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T024-DB1' } }
		stage('Team-Gate-Build-T024-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T024-DB2' } }
		stage('Team-Gate-Build-T024-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T024-WWW' } }
		stage('Team-Gate-Build-T024-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T024-APP1' } }
		stage('Team-Gate-Build-T024-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T024-APP2' } }
		stage('Team-Gate-Build-T024-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T024-APP3' } }
		stage('Team-Gate-Build-T024-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T024-' } }

		stage('Team-Gate-Deploy-T024-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T024-Enter' } }
		stage('Team-Gate-Deploy-T024-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T024-DB1' } }
		stage('Team-Gate-Deploy-T024-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T024-DB2' } }
		stage('Team-Gate-Deploy-T024-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T024-WWW' } }
		stage('Team-Gate-Deploy-T024-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T024-APP1' } }
		stage('Team-Gate-Deploy-T024-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T024-APP2' } }
		stage('Team-Gate-Deploy-T024-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T024-APP3' } }
		stage('Team-Gate-Deploy-T024-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T024-Exit' } }

		stage('Team-Gate-Test-T024-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T024-Enter' } }
		stage('Team-Gate-Test-T024-Functional') { steps { sh './ci.sh Team-Gate-Test-T024-Functional' } }
		stage('Team-Gate-Test-T024-Performance'){ steps { sh './ci.sh Team-Gate-Test-T024-Performance' } }
		stage('Team-Gate-Test-T024-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T024-Security' } }
		stage('Team-Gate-Test-T024-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T024-Exit' } }

		stage('Team-Gate-T024-Exit') { steps { sh './ci.sh Team-Gate-T024-Exit' } }

		stage('Team-Gate-T024-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T024-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
