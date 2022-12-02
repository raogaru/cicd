// ######################################################################
pipelineJob('DEMO-CI-team-gate-T084') {
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
		vTEAM = 'T084'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T084-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T084-START' } } 

		stage('Team-Gate-T084-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T084',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T084-Enter') 		{ steps { sh './ci.sh Team-Gate-T084-Enter' } }

		stage('Team-Gate-Build-T084-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T084-Enter' } }
		stage('Team-Gate-Build-T084-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T084-DB1' } }
		stage('Team-Gate-Build-T084-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T084-DB2' } }
		stage('Team-Gate-Build-T084-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T084-WWW' } }
		stage('Team-Gate-Build-T084-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T084-APP1' } }
		stage('Team-Gate-Build-T084-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T084-APP2' } }
		stage('Team-Gate-Build-T084-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T084-APP3' } }
		stage('Team-Gate-Build-T084-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T084-' } }

		stage('Team-Gate-Deploy-T084-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T084-Enter' } }
		stage('Team-Gate-Deploy-T084-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T084-DB1' } }
		stage('Team-Gate-Deploy-T084-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T084-DB2' } }
		stage('Team-Gate-Deploy-T084-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T084-WWW' } }
		stage('Team-Gate-Deploy-T084-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T084-APP1' } }
		stage('Team-Gate-Deploy-T084-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T084-APP2' } }
		stage('Team-Gate-Deploy-T084-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T084-APP3' } }
		stage('Team-Gate-Deploy-T084-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T084-Exit' } }

		stage('Team-Gate-Test-T084-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T084-Enter' } }
		stage('Team-Gate-Test-T084-Functional') { steps { sh './ci.sh Team-Gate-Test-T084-Functional' } }
		stage('Team-Gate-Test-T084-Performance'){ steps { sh './ci.sh Team-Gate-Test-T084-Performance' } }
		stage('Team-Gate-Test-T084-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T084-Security' } }
		stage('Team-Gate-Test-T084-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T084-Exit' } }

		stage('Team-Gate-T084-Exit') { steps { sh './ci.sh Team-Gate-T084-Exit' } }

		stage('Team-Gate-T084-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T084-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
