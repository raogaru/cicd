// ######################################################################
pipelineJob('DEMO-CI-team-gate-T008') {
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
		vTEAM = 'T008'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T008-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T008-START' } } 

		stage('Team-Gate-T008-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T008',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T008-Enter') 		{ steps { sh './ci.sh Team-Gate-T008-Enter' } }

		stage('Team-Gate-Build-T008-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T008-Enter' } }
		stage('Team-Gate-Build-T008-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T008-DB1' } }
		stage('Team-Gate-Build-T008-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T008-DB2' } }
		stage('Team-Gate-Build-T008-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T008-WWW' } }
		stage('Team-Gate-Build-T008-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T008-APP1' } }
		stage('Team-Gate-Build-T008-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T008-APP2' } }
		stage('Team-Gate-Build-T008-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T008-APP3' } }
		stage('Team-Gate-Build-T008-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T008-' } }

		stage('Team-Gate-Deploy-T008-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T008-Enter' } }
		stage('Team-Gate-Deploy-T008-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T008-DB1' } }
		stage('Team-Gate-Deploy-T008-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T008-DB2' } }
		stage('Team-Gate-Deploy-T008-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T008-WWW' } }
		stage('Team-Gate-Deploy-T008-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T008-APP1' } }
		stage('Team-Gate-Deploy-T008-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T008-APP2' } }
		stage('Team-Gate-Deploy-T008-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T008-APP3' } }
		stage('Team-Gate-Deploy-T008-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T008-Exit' } }

		stage('Team-Gate-Test-T008-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T008-Enter' } }
		stage('Team-Gate-Test-T008-Functional') { steps { sh './ci.sh Team-Gate-Test-T008-Functional' } }
		stage('Team-Gate-Test-T008-Performance'){ steps { sh './ci.sh Team-Gate-Test-T008-Performance' } }
		stage('Team-Gate-Test-T008-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T008-Security' } }
		stage('Team-Gate-Test-T008-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T008-Exit' } }

		stage('Team-Gate-T008-Exit') { steps { sh './ci.sh Team-Gate-T008-Exit' } }

		stage('Team-Gate-T008-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T008-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
