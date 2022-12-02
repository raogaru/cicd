// ######################################################################
pipelineJob('DEMO-CI-team-gate-T068') {
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
		vTEAM = 'T068'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T068-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T068-START' } } 

		stage('Team-Gate-T068-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T068',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T068-Enter') 		{ steps { sh './ci.sh Team-Gate-T068-Enter' } }

		stage('Team-Gate-Build-T068-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T068-Enter' } }
		stage('Team-Gate-Build-T068-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T068-DB1' } }
		stage('Team-Gate-Build-T068-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T068-DB2' } }
		stage('Team-Gate-Build-T068-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T068-WWW' } }
		stage('Team-Gate-Build-T068-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T068-APP1' } }
		stage('Team-Gate-Build-T068-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T068-APP2' } }
		stage('Team-Gate-Build-T068-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T068-APP3' } }
		stage('Team-Gate-Build-T068-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T068-' } }

		stage('Team-Gate-Deploy-T068-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T068-Enter' } }
		stage('Team-Gate-Deploy-T068-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T068-DB1' } }
		stage('Team-Gate-Deploy-T068-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T068-DB2' } }
		stage('Team-Gate-Deploy-T068-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T068-WWW' } }
		stage('Team-Gate-Deploy-T068-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T068-APP1' } }
		stage('Team-Gate-Deploy-T068-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T068-APP2' } }
		stage('Team-Gate-Deploy-T068-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T068-APP3' } }
		stage('Team-Gate-Deploy-T068-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T068-Exit' } }

		stage('Team-Gate-Test-T068-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T068-Enter' } }
		stage('Team-Gate-Test-T068-Functional') { steps { sh './ci.sh Team-Gate-Test-T068-Functional' } }
		stage('Team-Gate-Test-T068-Performance'){ steps { sh './ci.sh Team-Gate-Test-T068-Performance' } }
		stage('Team-Gate-Test-T068-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T068-Security' } }
		stage('Team-Gate-Test-T068-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T068-Exit' } }

		stage('Team-Gate-T068-Exit') { steps { sh './ci.sh Team-Gate-T068-Exit' } }

		stage('Team-Gate-T068-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T068-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
