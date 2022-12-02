// ######################################################################
pipelineJob('DEMO-CI-team-gate-T002') {
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
		vTEAM = 'T002'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T002-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T002-START' } } 

		stage('Team-Gate-T002-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T002',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T002-Enter') 		{ steps { sh './ci.sh Team-Gate-T002-Enter' } }

		stage('Team-Gate-Build-T002-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T002-Enter' } }
		stage('Team-Gate-Build-T002-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T002-DB1' } }
		stage('Team-Gate-Build-T002-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T002-DB2' } }
		stage('Team-Gate-Build-T002-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T002-WWW' } }
		stage('Team-Gate-Build-T002-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T002-APP1' } }
		stage('Team-Gate-Build-T002-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T002-APP2' } }
		stage('Team-Gate-Build-T002-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T002-APP3' } }
		stage('Team-Gate-Build-T002-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T002-' } }

		stage('Team-Gate-Deploy-T002-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T002-Enter' } }
		stage('Team-Gate-Deploy-T002-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T002-DB1' } }
		stage('Team-Gate-Deploy-T002-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T002-DB2' } }
		stage('Team-Gate-Deploy-T002-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T002-WWW' } }
		stage('Team-Gate-Deploy-T002-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T002-APP1' } }
		stage('Team-Gate-Deploy-T002-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T002-APP2' } }
		stage('Team-Gate-Deploy-T002-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T002-APP3' } }
		stage('Team-Gate-Deploy-T002-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T002-Exit' } }

		stage('Team-Gate-Test-T002-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T002-Enter' } }
		stage('Team-Gate-Test-T002-Functional') { steps { sh './ci.sh Team-Gate-Test-T002-Functional' } }
		stage('Team-Gate-Test-T002-Performance'){ steps { sh './ci.sh Team-Gate-Test-T002-Performance' } }
		stage('Team-Gate-Test-T002-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T002-Security' } }
		stage('Team-Gate-Test-T002-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T002-Exit' } }

		stage('Team-Gate-T002-Exit') { steps { sh './ci.sh Team-Gate-T002-Exit' } }

		stage('Team-Gate-T002-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T002-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
