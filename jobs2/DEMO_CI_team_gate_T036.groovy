// ######################################################################
pipelineJob('DEMO-CI-team-gate-T036') {
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
		vTEAM = 'T036'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T036-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T036-START' } } 

		stage('Team-Gate-T036-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T036',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T036-Enter') 		{ steps { sh './ci.sh Team-Gate-T036-Enter' } }

		stage('Team-Gate-Build-T036-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T036-Enter' } }
		stage('Team-Gate-Build-T036-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T036-DB1' } }
		stage('Team-Gate-Build-T036-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T036-DB2' } }
		stage('Team-Gate-Build-T036-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T036-WWW' } }
		stage('Team-Gate-Build-T036-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T036-APP1' } }
		stage('Team-Gate-Build-T036-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T036-APP2' } }
		stage('Team-Gate-Build-T036-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T036-APP3' } }
		stage('Team-Gate-Build-T036-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T036-' } }

		stage('Team-Gate-Deploy-T036-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T036-Enter' } }
		stage('Team-Gate-Deploy-T036-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T036-DB1' } }
		stage('Team-Gate-Deploy-T036-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T036-DB2' } }
		stage('Team-Gate-Deploy-T036-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T036-WWW' } }
		stage('Team-Gate-Deploy-T036-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T036-APP1' } }
		stage('Team-Gate-Deploy-T036-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T036-APP2' } }
		stage('Team-Gate-Deploy-T036-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T036-APP3' } }
		stage('Team-Gate-Deploy-T036-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T036-Exit' } }

		stage('Team-Gate-Test-T036-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T036-Enter' } }
		stage('Team-Gate-Test-T036-Functional') { steps { sh './ci.sh Team-Gate-Test-T036-Functional' } }
		stage('Team-Gate-Test-T036-Performance'){ steps { sh './ci.sh Team-Gate-Test-T036-Performance' } }
		stage('Team-Gate-Test-T036-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T036-Security' } }
		stage('Team-Gate-Test-T036-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T036-Exit' } }

		stage('Team-Gate-T036-Exit') { steps { sh './ci.sh Team-Gate-T036-Exit' } }

		stage('Team-Gate-T036-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T036-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
