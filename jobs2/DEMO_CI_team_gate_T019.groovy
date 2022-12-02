// ######################################################################
pipelineJob('DEMO-CI-team-gate-T019') {
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
		vTEAM = 'T019'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T019-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T019-START' } } 

		stage('Team-Gate-T019-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T019',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T019-Enter') 		{ steps { sh './ci.sh Team-Gate-T019-Enter' } }

		stage('Team-Gate-Build-T019-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T019-Enter' } }
		stage('Team-Gate-Build-T019-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T019-DB1' } }
		stage('Team-Gate-Build-T019-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T019-DB2' } }
		stage('Team-Gate-Build-T019-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T019-WWW' } }
		stage('Team-Gate-Build-T019-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T019-APP1' } }
		stage('Team-Gate-Build-T019-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T019-APP2' } }
		stage('Team-Gate-Build-T019-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T019-APP3' } }
		stage('Team-Gate-Build-T019-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T019-' } }

		stage('Team-Gate-Deploy-T019-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T019-Enter' } }
		stage('Team-Gate-Deploy-T019-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T019-DB1' } }
		stage('Team-Gate-Deploy-T019-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T019-DB2' } }
		stage('Team-Gate-Deploy-T019-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T019-WWW' } }
		stage('Team-Gate-Deploy-T019-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T019-APP1' } }
		stage('Team-Gate-Deploy-T019-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T019-APP2' } }
		stage('Team-Gate-Deploy-T019-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T019-APP3' } }
		stage('Team-Gate-Deploy-T019-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T019-Exit' } }

		stage('Team-Gate-Test-T019-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T019-Enter' } }
		stage('Team-Gate-Test-T019-Functional') { steps { sh './ci.sh Team-Gate-Test-T019-Functional' } }
		stage('Team-Gate-Test-T019-Performance'){ steps { sh './ci.sh Team-Gate-Test-T019-Performance' } }
		stage('Team-Gate-Test-T019-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T019-Security' } }
		stage('Team-Gate-Test-T019-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T019-Exit' } }

		stage('Team-Gate-T019-Exit') { steps { sh './ci.sh Team-Gate-T019-Exit' } }

		stage('Team-Gate-T019-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T019-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
