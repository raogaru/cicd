// ######################################################################
pipelineJob('DEMO-CI-team-gate-T007') {
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
		vTEAM = 'T007'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T007-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T007-START' } } 

		stage('Team-Gate-T007-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T007',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T007-Enter') 		{ steps { sh './ci.sh Team-Gate-T007-Enter' } }

		stage('Team-Gate-Build-T007-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T007-Enter' } }
		stage('Team-Gate-Build-T007-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T007-DB1' } }
		stage('Team-Gate-Build-T007-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T007-DB2' } }
		stage('Team-Gate-Build-T007-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T007-WWW' } }
		stage('Team-Gate-Build-T007-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T007-APP1' } }
		stage('Team-Gate-Build-T007-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T007-APP2' } }
		stage('Team-Gate-Build-T007-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T007-APP3' } }
		stage('Team-Gate-Build-T007-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T007-' } }

		stage('Team-Gate-Deploy-T007-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T007-Enter' } }
		stage('Team-Gate-Deploy-T007-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T007-DB1' } }
		stage('Team-Gate-Deploy-T007-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T007-DB2' } }
		stage('Team-Gate-Deploy-T007-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T007-WWW' } }
		stage('Team-Gate-Deploy-T007-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T007-APP1' } }
		stage('Team-Gate-Deploy-T007-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T007-APP2' } }
		stage('Team-Gate-Deploy-T007-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T007-APP3' } }
		stage('Team-Gate-Deploy-T007-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T007-Exit' } }

		stage('Team-Gate-Test-T007-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T007-Enter' } }
		stage('Team-Gate-Test-T007-Functional') { steps { sh './ci.sh Team-Gate-Test-T007-Functional' } }
		stage('Team-Gate-Test-T007-Performance'){ steps { sh './ci.sh Team-Gate-Test-T007-Performance' } }
		stage('Team-Gate-Test-T007-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T007-Security' } }
		stage('Team-Gate-Test-T007-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T007-Exit' } }

		stage('Team-Gate-T007-Exit') { steps { sh './ci.sh Team-Gate-T007-Exit' } }

		stage('Team-Gate-T007-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T007-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
