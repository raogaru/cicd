// ######################################################################
pipelineJob('DEMO-CI-team-gate-T005') {
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
		vTEAM = 'T005'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T005-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T005-START' } } 

		stage('Team-Gate-T005-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T005',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T005-Enter') 		{ steps { sh './ci.sh Team-Gate-T005-Enter' } }

		stage('Team-Gate-Build-T005-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T005-Enter' } }
		stage('Team-Gate-Build-T005-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T005-DB1' } }
		stage('Team-Gate-Build-T005-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T005-DB2' } }
		stage('Team-Gate-Build-T005-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T005-WWW' } }
		stage('Team-Gate-Build-T005-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T005-APP1' } }
		stage('Team-Gate-Build-T005-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T005-APP2' } }
		stage('Team-Gate-Build-T005-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T005-APP3' } }
		stage('Team-Gate-Build-T005-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T005-' } }

		stage('Team-Gate-Deploy-T005-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T005-Enter' } }
		stage('Team-Gate-Deploy-T005-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T005-DB1' } }
		stage('Team-Gate-Deploy-T005-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T005-DB2' } }
		stage('Team-Gate-Deploy-T005-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T005-WWW' } }
		stage('Team-Gate-Deploy-T005-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T005-APP1' } }
		stage('Team-Gate-Deploy-T005-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T005-APP2' } }
		stage('Team-Gate-Deploy-T005-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T005-APP3' } }
		stage('Team-Gate-Deploy-T005-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T005-Exit' } }

		stage('Team-Gate-Test-T005-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T005-Enter' } }
		stage('Team-Gate-Test-T005-Functional') { steps { sh './ci.sh Team-Gate-Test-T005-Functional' } }
		stage('Team-Gate-Test-T005-Performance'){ steps { sh './ci.sh Team-Gate-Test-T005-Performance' } }
		stage('Team-Gate-Test-T005-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T005-Security' } }
		stage('Team-Gate-Test-T005-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T005-Exit' } }

		stage('Team-Gate-T005-Exit') { steps { sh './ci.sh Team-Gate-T005-Exit' } }

		stage('Team-Gate-T005-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T005-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
