// ######################################################################
pipelineJob('DEMO-CI-team-gate-T015') {
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
		vTEAM = 'T015'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T015-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T015-START' } } 

		stage('Team-Gate-T015-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T015',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T015-Enter') 		{ steps { sh './ci.sh Team-Gate-T015-Enter' } }

		stage('Team-Gate-Build-T015-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T015-Enter' } }
		stage('Team-Gate-Build-T015-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T015-DB1' } }
		stage('Team-Gate-Build-T015-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T015-DB2' } }
		stage('Team-Gate-Build-T015-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T015-WWW' } }
		stage('Team-Gate-Build-T015-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T015-APP1' } }
		stage('Team-Gate-Build-T015-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T015-APP2' } }
		stage('Team-Gate-Build-T015-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T015-APP3' } }
		stage('Team-Gate-Build-T015-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T015-' } }

		stage('Team-Gate-Deploy-T015-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T015-Enter' } }
		stage('Team-Gate-Deploy-T015-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T015-DB1' } }
		stage('Team-Gate-Deploy-T015-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T015-DB2' } }
		stage('Team-Gate-Deploy-T015-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T015-WWW' } }
		stage('Team-Gate-Deploy-T015-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T015-APP1' } }
		stage('Team-Gate-Deploy-T015-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T015-APP2' } }
		stage('Team-Gate-Deploy-T015-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T015-APP3' } }
		stage('Team-Gate-Deploy-T015-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T015-Exit' } }

		stage('Team-Gate-Test-T015-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T015-Enter' } }
		stage('Team-Gate-Test-T015-Functional') { steps { sh './ci.sh Team-Gate-Test-T015-Functional' } }
		stage('Team-Gate-Test-T015-Performance'){ steps { sh './ci.sh Team-Gate-Test-T015-Performance' } }
		stage('Team-Gate-Test-T015-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T015-Security' } }
		stage('Team-Gate-Test-T015-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T015-Exit' } }

		stage('Team-Gate-T015-Exit') { steps { sh './ci.sh Team-Gate-T015-Exit' } }

		stage('Team-Gate-T015-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T015-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
