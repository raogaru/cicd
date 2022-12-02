// ######################################################################
pipelineJob('DEMO-CI-team-gate-T081') {
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
		vTEAM = 'T081'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T081-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T081-START' } } 

		stage('Team-Gate-T081-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T081',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T081-Enter') 		{ steps { sh './ci.sh Team-Gate-T081-Enter' } }

		stage('Team-Gate-Build-T081-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T081-Enter' } }
		stage('Team-Gate-Build-T081-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T081-DB1' } }
		stage('Team-Gate-Build-T081-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T081-DB2' } }
		stage('Team-Gate-Build-T081-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T081-WWW' } }
		stage('Team-Gate-Build-T081-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T081-APP1' } }
		stage('Team-Gate-Build-T081-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T081-APP2' } }
		stage('Team-Gate-Build-T081-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T081-APP3' } }
		stage('Team-Gate-Build-T081-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T081-' } }

		stage('Team-Gate-Deploy-T081-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T081-Enter' } }
		stage('Team-Gate-Deploy-T081-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T081-DB1' } }
		stage('Team-Gate-Deploy-T081-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T081-DB2' } }
		stage('Team-Gate-Deploy-T081-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T081-WWW' } }
		stage('Team-Gate-Deploy-T081-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T081-APP1' } }
		stage('Team-Gate-Deploy-T081-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T081-APP2' } }
		stage('Team-Gate-Deploy-T081-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T081-APP3' } }
		stage('Team-Gate-Deploy-T081-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T081-Exit' } }

		stage('Team-Gate-Test-T081-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T081-Enter' } }
		stage('Team-Gate-Test-T081-Functional') { steps { sh './ci.sh Team-Gate-Test-T081-Functional' } }
		stage('Team-Gate-Test-T081-Performance'){ steps { sh './ci.sh Team-Gate-Test-T081-Performance' } }
		stage('Team-Gate-Test-T081-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T081-Security' } }
		stage('Team-Gate-Test-T081-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T081-Exit' } }

		stage('Team-Gate-T081-Exit') { steps { sh './ci.sh Team-Gate-T081-Exit' } }

		stage('Team-Gate-T081-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T081-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
