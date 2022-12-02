// ######################################################################
pipelineJob('DEMO-CI-team-gate-T039') {
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
		vTEAM = 'T039'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T039-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T039-START' } } 

		stage('Team-Gate-T039-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T039',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T039-Enter') 		{ steps { sh './ci.sh Team-Gate-T039-Enter' } }

		stage('Team-Gate-Build-T039-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T039-Enter' } }
		stage('Team-Gate-Build-T039-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T039-DB1' } }
		stage('Team-Gate-Build-T039-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T039-DB2' } }
		stage('Team-Gate-Build-T039-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T039-WWW' } }
		stage('Team-Gate-Build-T039-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T039-APP1' } }
		stage('Team-Gate-Build-T039-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T039-APP2' } }
		stage('Team-Gate-Build-T039-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T039-APP3' } }
		stage('Team-Gate-Build-T039-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T039-' } }

		stage('Team-Gate-Deploy-T039-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T039-Enter' } }
		stage('Team-Gate-Deploy-T039-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T039-DB1' } }
		stage('Team-Gate-Deploy-T039-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T039-DB2' } }
		stage('Team-Gate-Deploy-T039-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T039-WWW' } }
		stage('Team-Gate-Deploy-T039-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T039-APP1' } }
		stage('Team-Gate-Deploy-T039-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T039-APP2' } }
		stage('Team-Gate-Deploy-T039-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T039-APP3' } }
		stage('Team-Gate-Deploy-T039-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T039-Exit' } }

		stage('Team-Gate-Test-T039-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T039-Enter' } }
		stage('Team-Gate-Test-T039-Functional') { steps { sh './ci.sh Team-Gate-Test-T039-Functional' } }
		stage('Team-Gate-Test-T039-Performance'){ steps { sh './ci.sh Team-Gate-Test-T039-Performance' } }
		stage('Team-Gate-Test-T039-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T039-Security' } }
		stage('Team-Gate-Test-T039-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T039-Exit' } }

		stage('Team-Gate-T039-Exit') { steps { sh './ci.sh Team-Gate-T039-Exit' } }

		stage('Team-Gate-T039-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T039-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
