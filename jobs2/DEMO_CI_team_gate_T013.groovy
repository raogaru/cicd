// ######################################################################
pipelineJob('DEMO-CI-team-gate-T013') {
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
		vTEAM = 'T013'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T013-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T013-START' } } 

		stage('Team-Gate-T013-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T013',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T013-Enter') 		{ steps { sh './ci.sh Team-Gate-T013-Enter' } }

		stage('Team-Gate-Build-T013-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T013-Enter' } }
		stage('Team-Gate-Build-T013-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T013-DB1' } }
		stage('Team-Gate-Build-T013-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T013-DB2' } }
		stage('Team-Gate-Build-T013-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T013-WWW' } }
		stage('Team-Gate-Build-T013-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T013-APP1' } }
		stage('Team-Gate-Build-T013-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T013-APP2' } }
		stage('Team-Gate-Build-T013-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T013-APP3' } }
		stage('Team-Gate-Build-T013-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T013-' } }

		stage('Team-Gate-Deploy-T013-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T013-Enter' } }
		stage('Team-Gate-Deploy-T013-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T013-DB1' } }
		stage('Team-Gate-Deploy-T013-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T013-DB2' } }
		stage('Team-Gate-Deploy-T013-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T013-WWW' } }
		stage('Team-Gate-Deploy-T013-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T013-APP1' } }
		stage('Team-Gate-Deploy-T013-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T013-APP2' } }
		stage('Team-Gate-Deploy-T013-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T013-APP3' } }
		stage('Team-Gate-Deploy-T013-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T013-Exit' } }

		stage('Team-Gate-Test-T013-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T013-Enter' } }
		stage('Team-Gate-Test-T013-Functional') { steps { sh './ci.sh Team-Gate-Test-T013-Functional' } }
		stage('Team-Gate-Test-T013-Performance'){ steps { sh './ci.sh Team-Gate-Test-T013-Performance' } }
		stage('Team-Gate-Test-T013-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T013-Security' } }
		stage('Team-Gate-Test-T013-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T013-Exit' } }

		stage('Team-Gate-T013-Exit') { steps { sh './ci.sh Team-Gate-T013-Exit' } }

		stage('Team-Gate-T013-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T013-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
