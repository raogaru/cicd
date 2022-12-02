// ######################################################################
pipelineJob('DEMO-CI-team-gate-T045') {
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
		vTEAM = 'T045'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T045-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T045-START' } } 

		stage('Team-Gate-T045-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T045',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T045-Enter') 		{ steps { sh './ci.sh Team-Gate-T045-Enter' } }

		stage('Team-Gate-Build-T045-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T045-Enter' } }
		stage('Team-Gate-Build-T045-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T045-DB1' } }
		stage('Team-Gate-Build-T045-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T045-DB2' } }
		stage('Team-Gate-Build-T045-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T045-WWW' } }
		stage('Team-Gate-Build-T045-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T045-APP1' } }
		stage('Team-Gate-Build-T045-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T045-APP2' } }
		stage('Team-Gate-Build-T045-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T045-APP3' } }
		stage('Team-Gate-Build-T045-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T045-' } }

		stage('Team-Gate-Deploy-T045-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T045-Enter' } }
		stage('Team-Gate-Deploy-T045-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T045-DB1' } }
		stage('Team-Gate-Deploy-T045-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T045-DB2' } }
		stage('Team-Gate-Deploy-T045-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T045-WWW' } }
		stage('Team-Gate-Deploy-T045-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T045-APP1' } }
		stage('Team-Gate-Deploy-T045-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T045-APP2' } }
		stage('Team-Gate-Deploy-T045-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T045-APP3' } }
		stage('Team-Gate-Deploy-T045-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T045-Exit' } }

		stage('Team-Gate-Test-T045-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T045-Enter' } }
		stage('Team-Gate-Test-T045-Functional') { steps { sh './ci.sh Team-Gate-Test-T045-Functional' } }
		stage('Team-Gate-Test-T045-Performance'){ steps { sh './ci.sh Team-Gate-Test-T045-Performance' } }
		stage('Team-Gate-Test-T045-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T045-Security' } }
		stage('Team-Gate-Test-T045-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T045-Exit' } }

		stage('Team-Gate-T045-Exit') { steps { sh './ci.sh Team-Gate-T045-Exit' } }

		stage('Team-Gate-T045-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T045-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
