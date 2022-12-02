// ######################################################################
pipelineJob('DEMO-CI-team-gate-T025') {
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
		vTEAM = 'T025'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T025-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T025-START' } } 

		stage('Team-Gate-T025-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T025',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T025-Enter') 		{ steps { sh './ci.sh Team-Gate-T025-Enter' } }

		stage('Team-Gate-Build-T025-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T025-Enter' } }
		stage('Team-Gate-Build-T025-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T025-DB1' } }
		stage('Team-Gate-Build-T025-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T025-DB2' } }
		stage('Team-Gate-Build-T025-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T025-WWW' } }
		stage('Team-Gate-Build-T025-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T025-APP1' } }
		stage('Team-Gate-Build-T025-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T025-APP2' } }
		stage('Team-Gate-Build-T025-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T025-APP3' } }
		stage('Team-Gate-Build-T025-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T025-' } }

		stage('Team-Gate-Deploy-T025-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T025-Enter' } }
		stage('Team-Gate-Deploy-T025-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T025-DB1' } }
		stage('Team-Gate-Deploy-T025-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T025-DB2' } }
		stage('Team-Gate-Deploy-T025-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T025-WWW' } }
		stage('Team-Gate-Deploy-T025-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T025-APP1' } }
		stage('Team-Gate-Deploy-T025-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T025-APP2' } }
		stage('Team-Gate-Deploy-T025-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T025-APP3' } }
		stage('Team-Gate-Deploy-T025-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T025-Exit' } }

		stage('Team-Gate-Test-T025-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T025-Enter' } }
		stage('Team-Gate-Test-T025-Functional') { steps { sh './ci.sh Team-Gate-Test-T025-Functional' } }
		stage('Team-Gate-Test-T025-Performance'){ steps { sh './ci.sh Team-Gate-Test-T025-Performance' } }
		stage('Team-Gate-Test-T025-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T025-Security' } }
		stage('Team-Gate-Test-T025-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T025-Exit' } }

		stage('Team-Gate-T025-Exit') { steps { sh './ci.sh Team-Gate-T025-Exit' } }

		stage('Team-Gate-T025-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T025-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
