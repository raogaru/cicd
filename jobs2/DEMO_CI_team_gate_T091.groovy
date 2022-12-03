// ######################################################################
pipelineJob('DEMO-CI-team-gate-T091') {
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
		vTEAM = 'T091'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T091-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T091-START' } } 

		stage('Team-Gate-T091-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T091',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T091-Enter') 		{ steps { sh './ci.sh Team-Gate-T091-Enter' } }

		stage('Team-Gate-Build-T091-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T091-Enter' } }
		stage('Team-Gate-Build-T091-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T091-DB1' } }
		stage('Team-Gate-Build-T091-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T091-DB2' } }
		stage('Team-Gate-Build-T091-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T091-WWW' } }
		stage('Team-Gate-Build-T091-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T091-APP1' } }
		stage('Team-Gate-Build-T091-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T091-APP2' } }
		stage('Team-Gate-Build-T091-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T091-APP3' } }
		stage('Team-Gate-Build-T091-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T091-' } }

		stage('Team-Gate-Deploy-T091-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T091-Enter' } }
		stage('Team-Gate-Deploy-T091-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T091-DB1' } }
		stage('Team-Gate-Deploy-T091-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T091-DB2' } }
		stage('Team-Gate-Deploy-T091-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T091-WWW' } }
		stage('Team-Gate-Deploy-T091-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T091-APP1' } }
		stage('Team-Gate-Deploy-T091-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T091-APP2' } }
		stage('Team-Gate-Deploy-T091-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T091-APP3' } }
		stage('Team-Gate-Deploy-T091-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T091-Exit' } }

		stage('Team-Gate-Test-T091-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T091-Enter' } }
		stage('Team-Gate-Test-T091-Functional') { steps { sh './ci.sh Team-Gate-Test-T091-Functional' } }
		stage('Team-Gate-Test-T091-Performance'){ steps { sh './ci.sh Team-Gate-Test-T091-Performance' } }
		stage('Team-Gate-Test-T091-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T091-Security' } }
		stage('Team-Gate-Test-T091-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T091-Exit' } }

		stage('Team-Gate-T091-Exit') { steps { sh './ci.sh Team-Gate-T091-Exit' } }

		stage('Team-Gate-T091-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T091-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################