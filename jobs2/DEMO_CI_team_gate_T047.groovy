// ######################################################################
pipelineJob('DEMO-CI-team-gate-T047') {
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
		vTEAM = 'T047'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T047-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T047-START' } } 

		stage('Team-Gate-T047-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T047',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T047-Enter') 		{ steps { sh './ci.sh Team-Gate-T047-Enter' } }

		stage('Team-Gate-Build-T047-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T047-Enter' } }
		stage('Team-Gate-Build-T047-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T047-DB1' } }
		stage('Team-Gate-Build-T047-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T047-DB2' } }
		stage('Team-Gate-Build-T047-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T047-WWW' } }
		stage('Team-Gate-Build-T047-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T047-APP1' } }
		stage('Team-Gate-Build-T047-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T047-APP2' } }
		stage('Team-Gate-Build-T047-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T047-APP3' } }
		stage('Team-Gate-Build-T047-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T047-' } }

		stage('Team-Gate-Deploy-T047-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T047-Enter' } }
		stage('Team-Gate-Deploy-T047-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T047-DB1' } }
		stage('Team-Gate-Deploy-T047-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T047-DB2' } }
		stage('Team-Gate-Deploy-T047-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T047-WWW' } }
		stage('Team-Gate-Deploy-T047-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T047-APP1' } }
		stage('Team-Gate-Deploy-T047-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T047-APP2' } }
		stage('Team-Gate-Deploy-T047-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T047-APP3' } }
		stage('Team-Gate-Deploy-T047-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T047-Exit' } }

		stage('Team-Gate-Test-T047-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T047-Enter' } }
		stage('Team-Gate-Test-T047-Functional') { steps { sh './ci.sh Team-Gate-Test-T047-Functional' } }
		stage('Team-Gate-Test-T047-Performance'){ steps { sh './ci.sh Team-Gate-Test-T047-Performance' } }
		stage('Team-Gate-Test-T047-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T047-Security' } }
		stage('Team-Gate-Test-T047-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T047-Exit' } }

		stage('Team-Gate-T047-Exit') { steps { sh './ci.sh Team-Gate-T047-Exit' } }

		stage('Team-Gate-T047-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T047-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
