// ######################################################################
pipelineJob('DEMO-CI-team-gate-T018') {
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
		vTEAM = 'T018'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T018-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T018-START' } } 

		stage('Team-Gate-T018-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T018',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T018-Enter') 		{ steps { sh './ci.sh Team-Gate-T018-Enter' } }

		stage('Team-Gate-Build-T018-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T018-Enter' } }
		stage('Team-Gate-Build-T018-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T018-DB1' } }
		stage('Team-Gate-Build-T018-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T018-DB2' } }
		stage('Team-Gate-Build-T018-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T018-WWW' } }
		stage('Team-Gate-Build-T018-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T018-APP1' } }
		stage('Team-Gate-Build-T018-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T018-APP2' } }
		stage('Team-Gate-Build-T018-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T018-APP3' } }
		stage('Team-Gate-Build-T018-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T018-' } }

		stage('Team-Gate-Deploy-T018-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T018-Enter' } }
		stage('Team-Gate-Deploy-T018-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T018-DB1' } }
		stage('Team-Gate-Deploy-T018-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T018-DB2' } }
		stage('Team-Gate-Deploy-T018-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T018-WWW' } }
		stage('Team-Gate-Deploy-T018-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T018-APP1' } }
		stage('Team-Gate-Deploy-T018-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T018-APP2' } }
		stage('Team-Gate-Deploy-T018-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T018-APP3' } }
		stage('Team-Gate-Deploy-T018-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T018-Exit' } }

		stage('Team-Gate-Test-T018-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T018-Enter' } }
		stage('Team-Gate-Test-T018-Functional') { steps { sh './ci.sh Team-Gate-Test-T018-Functional' } }
		stage('Team-Gate-Test-T018-Performance'){ steps { sh './ci.sh Team-Gate-Test-T018-Performance' } }
		stage('Team-Gate-Test-T018-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T018-Security' } }
		stage('Team-Gate-Test-T018-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T018-Exit' } }

		stage('Team-Gate-T018-Exit') { steps { sh './ci.sh Team-Gate-T018-Exit' } }

		stage('Team-Gate-T018-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T018-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
