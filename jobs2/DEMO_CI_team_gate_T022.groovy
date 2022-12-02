// ######################################################################
pipelineJob('DEMO-CI-team-gate-T022') {
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
		vTEAM = 'T022'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T022-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T022-START' } } 

		stage('Team-Gate-T022-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T022',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T022-Enter') 		{ steps { sh './ci.sh Team-Gate-T022-Enter' } }

		stage('Team-Gate-Build-T022-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T022-Enter' } }
		stage('Team-Gate-Build-T022-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T022-DB1' } }
		stage('Team-Gate-Build-T022-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T022-DB2' } }
		stage('Team-Gate-Build-T022-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T022-WWW' } }
		stage('Team-Gate-Build-T022-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T022-APP1' } }
		stage('Team-Gate-Build-T022-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T022-APP2' } }
		stage('Team-Gate-Build-T022-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T022-APP3' } }
		stage('Team-Gate-Build-T022-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T022-' } }

		stage('Team-Gate-Deploy-T022-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T022-Enter' } }
		stage('Team-Gate-Deploy-T022-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T022-DB1' } }
		stage('Team-Gate-Deploy-T022-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T022-DB2' } }
		stage('Team-Gate-Deploy-T022-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T022-WWW' } }
		stage('Team-Gate-Deploy-T022-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T022-APP1' } }
		stage('Team-Gate-Deploy-T022-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T022-APP2' } }
		stage('Team-Gate-Deploy-T022-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T022-APP3' } }
		stage('Team-Gate-Deploy-T022-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T022-Exit' } }

		stage('Team-Gate-Test-T022-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T022-Enter' } }
		stage('Team-Gate-Test-T022-Functional') { steps { sh './ci.sh Team-Gate-Test-T022-Functional' } }
		stage('Team-Gate-Test-T022-Performance'){ steps { sh './ci.sh Team-Gate-Test-T022-Performance' } }
		stage('Team-Gate-Test-T022-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T022-Security' } }
		stage('Team-Gate-Test-T022-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T022-Exit' } }

		stage('Team-Gate-T022-Exit') { steps { sh './ci.sh Team-Gate-T022-Exit' } }

		stage('Team-Gate-T022-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T022-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
