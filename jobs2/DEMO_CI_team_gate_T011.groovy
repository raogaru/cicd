// ######################################################################
pipelineJob('DEMO-CI-team-gate-T011') {
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
		vTEAM = 'T011'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T011-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T011-START' } } 

		stage('Team-Gate-T011-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T011',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T011-Enter') 		{ steps { sh './ci.sh Team-Gate-T011-Enter' } }

		stage('Team-Gate-Build-T011-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T011-Enter' } }
		stage('Team-Gate-Build-T011-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T011-DB1' } }
		stage('Team-Gate-Build-T011-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T011-DB2' } }
		stage('Team-Gate-Build-T011-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T011-WWW' } }
		stage('Team-Gate-Build-T011-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T011-APP1' } }
		stage('Team-Gate-Build-T011-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T011-APP2' } }
		stage('Team-Gate-Build-T011-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T011-APP3' } }
		stage('Team-Gate-Build-T011-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T011-' } }

		stage('Team-Gate-Deploy-T011-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T011-Enter' } }
		stage('Team-Gate-Deploy-T011-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T011-DB1' } }
		stage('Team-Gate-Deploy-T011-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T011-DB2' } }
		stage('Team-Gate-Deploy-T011-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T011-WWW' } }
		stage('Team-Gate-Deploy-T011-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T011-APP1' } }
		stage('Team-Gate-Deploy-T011-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T011-APP2' } }
		stage('Team-Gate-Deploy-T011-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T011-APP3' } }
		stage('Team-Gate-Deploy-T011-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T011-Exit' } }

		stage('Team-Gate-Test-T011-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T011-Enter' } }
		stage('Team-Gate-Test-T011-Functional') { steps { sh './ci.sh Team-Gate-Test-T011-Functional' } }
		stage('Team-Gate-Test-T011-Performance'){ steps { sh './ci.sh Team-Gate-Test-T011-Performance' } }
		stage('Team-Gate-Test-T011-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T011-Security' } }
		stage('Team-Gate-Test-T011-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T011-Exit' } }

		stage('Team-Gate-T011-Exit') { steps { sh './ci.sh Team-Gate-T011-Exit' } }

		stage('Team-Gate-T011-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T011-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
