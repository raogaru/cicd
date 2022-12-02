// ######################################################################
pipelineJob('DEMO-CI-team-gate-T014') {
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
		vTEAM = 'T014'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T014-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T014-START' } } 

		stage('Team-Gate-T014-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T014',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T014-Enter') 		{ steps { sh './ci.sh Team-Gate-T014-Enter' } }

		stage('Team-Gate-Build-T014-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T014-Enter' } }
		stage('Team-Gate-Build-T014-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T014-DB1' } }
		stage('Team-Gate-Build-T014-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T014-DB2' } }
		stage('Team-Gate-Build-T014-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T014-WWW' } }
		stage('Team-Gate-Build-T014-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T014-APP1' } }
		stage('Team-Gate-Build-T014-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T014-APP2' } }
		stage('Team-Gate-Build-T014-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T014-APP3' } }
		stage('Team-Gate-Build-T014-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T014-' } }

		stage('Team-Gate-Deploy-T014-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T014-Enter' } }
		stage('Team-Gate-Deploy-T014-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T014-DB1' } }
		stage('Team-Gate-Deploy-T014-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T014-DB2' } }
		stage('Team-Gate-Deploy-T014-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T014-WWW' } }
		stage('Team-Gate-Deploy-T014-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T014-APP1' } }
		stage('Team-Gate-Deploy-T014-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T014-APP2' } }
		stage('Team-Gate-Deploy-T014-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T014-APP3' } }
		stage('Team-Gate-Deploy-T014-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T014-Exit' } }

		stage('Team-Gate-Test-T014-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T014-Enter' } }
		stage('Team-Gate-Test-T014-Functional') { steps { sh './ci.sh Team-Gate-Test-T014-Functional' } }
		stage('Team-Gate-Test-T014-Performance'){ steps { sh './ci.sh Team-Gate-Test-T014-Performance' } }
		stage('Team-Gate-Test-T014-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T014-Security' } }
		stage('Team-Gate-Test-T014-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T014-Exit' } }

		stage('Team-Gate-T014-Exit') { steps { sh './ci.sh Team-Gate-T014-Exit' } }

		stage('Team-Gate-T014-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T014-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
