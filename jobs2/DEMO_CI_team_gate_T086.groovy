// ######################################################################
pipelineJob('DEMO-CI-team-gate-T086') {
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
		vTEAM = 'T086'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T086-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T086-START' } } 

		stage('Team-Gate-T086-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T086',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T086-Enter') 		{ steps { sh './ci.sh Team-Gate-T086-Enter' } }

		stage('Team-Gate-Build-T086-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T086-Enter' } }
		stage('Team-Gate-Build-T086-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T086-DB1' } }
		stage('Team-Gate-Build-T086-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T086-DB2' } }
		stage('Team-Gate-Build-T086-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T086-WWW' } }
		stage('Team-Gate-Build-T086-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T086-APP1' } }
		stage('Team-Gate-Build-T086-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T086-APP2' } }
		stage('Team-Gate-Build-T086-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T086-APP3' } }
		stage('Team-Gate-Build-T086-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T086-' } }

		stage('Team-Gate-Deploy-T086-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T086-Enter' } }
		stage('Team-Gate-Deploy-T086-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T086-DB1' } }
		stage('Team-Gate-Deploy-T086-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T086-DB2' } }
		stage('Team-Gate-Deploy-T086-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T086-WWW' } }
		stage('Team-Gate-Deploy-T086-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T086-APP1' } }
		stage('Team-Gate-Deploy-T086-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T086-APP2' } }
		stage('Team-Gate-Deploy-T086-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T086-APP3' } }
		stage('Team-Gate-Deploy-T086-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T086-Exit' } }

		stage('Team-Gate-Test-T086-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T086-Enter' } }
		stage('Team-Gate-Test-T086-Functional') { steps { sh './ci.sh Team-Gate-Test-T086-Functional' } }
		stage('Team-Gate-Test-T086-Performance'){ steps { sh './ci.sh Team-Gate-Test-T086-Performance' } }
		stage('Team-Gate-Test-T086-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T086-Security' } }
		stage('Team-Gate-Test-T086-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T086-Exit' } }

		stage('Team-Gate-T086-Exit') { steps { sh './ci.sh Team-Gate-T086-Exit' } }

		stage('Team-Gate-T086-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T086-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
