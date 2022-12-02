// ######################################################################
pipelineJob('DEMO-CI-team-gate-T067') {
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
		vTEAM = 'T067'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T067-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T067-START' } } 

		stage('Team-Gate-T067-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T067',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T067-Enter') 		{ steps { sh './ci.sh Team-Gate-T067-Enter' } }

		stage('Team-Gate-Build-T067-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T067-Enter' } }
		stage('Team-Gate-Build-T067-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T067-DB1' } }
		stage('Team-Gate-Build-T067-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T067-DB2' } }
		stage('Team-Gate-Build-T067-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T067-WWW' } }
		stage('Team-Gate-Build-T067-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T067-APP1' } }
		stage('Team-Gate-Build-T067-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T067-APP2' } }
		stage('Team-Gate-Build-T067-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T067-APP3' } }
		stage('Team-Gate-Build-T067-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T067-' } }

		stage('Team-Gate-Deploy-T067-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T067-Enter' } }
		stage('Team-Gate-Deploy-T067-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T067-DB1' } }
		stage('Team-Gate-Deploy-T067-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T067-DB2' } }
		stage('Team-Gate-Deploy-T067-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T067-WWW' } }
		stage('Team-Gate-Deploy-T067-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T067-APP1' } }
		stage('Team-Gate-Deploy-T067-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T067-APP2' } }
		stage('Team-Gate-Deploy-T067-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T067-APP3' } }
		stage('Team-Gate-Deploy-T067-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T067-Exit' } }

		stage('Team-Gate-Test-T067-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T067-Enter' } }
		stage('Team-Gate-Test-T067-Functional') { steps { sh './ci.sh Team-Gate-Test-T067-Functional' } }
		stage('Team-Gate-Test-T067-Performance'){ steps { sh './ci.sh Team-Gate-Test-T067-Performance' } }
		stage('Team-Gate-Test-T067-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T067-Security' } }
		stage('Team-Gate-Test-T067-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T067-Exit' } }

		stage('Team-Gate-T067-Exit') { steps { sh './ci.sh Team-Gate-T067-Exit' } }

		stage('Team-Gate-T067-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T067-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
