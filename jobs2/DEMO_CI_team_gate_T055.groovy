// ######################################################################
pipelineJob('DEMO-CI-team-gate-T055') {
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
		vTEAM = 'T055'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T055-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T055-START' } } 

		stage('Team-Gate-T055-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T055',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T055-Enter') 		{ steps { sh './ci.sh Team-Gate-T055-Enter' } }

		stage('Team-Gate-Build-T055-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T055-Enter' } }
		stage('Team-Gate-Build-T055-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T055-DB1' } }
		stage('Team-Gate-Build-T055-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T055-DB2' } }
		stage('Team-Gate-Build-T055-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T055-WWW' } }
		stage('Team-Gate-Build-T055-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T055-APP1' } }
		stage('Team-Gate-Build-T055-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T055-APP2' } }
		stage('Team-Gate-Build-T055-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T055-APP3' } }
		stage('Team-Gate-Build-T055-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T055-' } }

		stage('Team-Gate-Deploy-T055-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T055-Enter' } }
		stage('Team-Gate-Deploy-T055-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T055-DB1' } }
		stage('Team-Gate-Deploy-T055-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T055-DB2' } }
		stage('Team-Gate-Deploy-T055-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T055-WWW' } }
		stage('Team-Gate-Deploy-T055-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T055-APP1' } }
		stage('Team-Gate-Deploy-T055-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T055-APP2' } }
		stage('Team-Gate-Deploy-T055-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T055-APP3' } }
		stage('Team-Gate-Deploy-T055-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T055-Exit' } }

		stage('Team-Gate-Test-T055-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T055-Enter' } }
		stage('Team-Gate-Test-T055-Functional') { steps { sh './ci.sh Team-Gate-Test-T055-Functional' } }
		stage('Team-Gate-Test-T055-Performance'){ steps { sh './ci.sh Team-Gate-Test-T055-Performance' } }
		stage('Team-Gate-Test-T055-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T055-Security' } }
		stage('Team-Gate-Test-T055-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T055-Exit' } }

		stage('Team-Gate-T055-Exit') { steps { sh './ci.sh Team-Gate-T055-Exit' } }

		stage('Team-Gate-T055-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T055-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
