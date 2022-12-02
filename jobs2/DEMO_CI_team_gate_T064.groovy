// ######################################################################
pipelineJob('DEMO-CI-team-gate-T064') {
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
		vTEAM = 'T064'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T064-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T064-START' } } 

		stage('Team-Gate-T064-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T064',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T064-Enter') 		{ steps { sh './ci.sh Team-Gate-T064-Enter' } }

		stage('Team-Gate-Build-T064-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T064-Enter' } }
		stage('Team-Gate-Build-T064-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T064-DB1' } }
		stage('Team-Gate-Build-T064-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T064-DB2' } }
		stage('Team-Gate-Build-T064-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T064-WWW' } }
		stage('Team-Gate-Build-T064-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T064-APP1' } }
		stage('Team-Gate-Build-T064-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T064-APP2' } }
		stage('Team-Gate-Build-T064-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T064-APP3' } }
		stage('Team-Gate-Build-T064-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T064-' } }

		stage('Team-Gate-Deploy-T064-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T064-Enter' } }
		stage('Team-Gate-Deploy-T064-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T064-DB1' } }
		stage('Team-Gate-Deploy-T064-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T064-DB2' } }
		stage('Team-Gate-Deploy-T064-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T064-WWW' } }
		stage('Team-Gate-Deploy-T064-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T064-APP1' } }
		stage('Team-Gate-Deploy-T064-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T064-APP2' } }
		stage('Team-Gate-Deploy-T064-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T064-APP3' } }
		stage('Team-Gate-Deploy-T064-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T064-Exit' } }

		stage('Team-Gate-Test-T064-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T064-Enter' } }
		stage('Team-Gate-Test-T064-Functional') { steps { sh './ci.sh Team-Gate-Test-T064-Functional' } }
		stage('Team-Gate-Test-T064-Performance'){ steps { sh './ci.sh Team-Gate-Test-T064-Performance' } }
		stage('Team-Gate-Test-T064-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T064-Security' } }
		stage('Team-Gate-Test-T064-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T064-Exit' } }

		stage('Team-Gate-T064-Exit') { steps { sh './ci.sh Team-Gate-T064-Exit' } }

		stage('Team-Gate-T064-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T064-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
