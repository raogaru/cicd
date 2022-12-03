// ######################################################################
pipelineJob('DEMO-CI-team-gate-T095') {
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
		vTEAM = 'T095'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T095-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T095-START' } } 

		stage('Team-Gate-T095-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T095',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T095-Enter') 		{ steps { sh './ci.sh Team-Gate-T095-Enter' } }

		stage('Team-Gate-Build-T095-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T095-Enter' } }
		stage('Team-Gate-Build-T095-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T095-DB1' } }
		stage('Team-Gate-Build-T095-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T095-DB2' } }
		stage('Team-Gate-Build-T095-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T095-WWW' } }
		stage('Team-Gate-Build-T095-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T095-APP1' } }
		stage('Team-Gate-Build-T095-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T095-APP2' } }
		stage('Team-Gate-Build-T095-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T095-APP3' } }
		stage('Team-Gate-Build-T095-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T095-' } }

		stage('Team-Gate-Deploy-T095-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T095-Enter' } }
		stage('Team-Gate-Deploy-T095-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T095-DB1' } }
		stage('Team-Gate-Deploy-T095-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T095-DB2' } }
		stage('Team-Gate-Deploy-T095-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T095-WWW' } }
		stage('Team-Gate-Deploy-T095-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T095-APP1' } }
		stage('Team-Gate-Deploy-T095-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T095-APP2' } }
		stage('Team-Gate-Deploy-T095-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T095-APP3' } }
		stage('Team-Gate-Deploy-T095-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T095-Exit' } }

		stage('Team-Gate-Test-T095-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T095-Enter' } }
		stage('Team-Gate-Test-T095-Functional') { steps { sh './ci.sh Team-Gate-Test-T095-Functional' } }
		stage('Team-Gate-Test-T095-Performance'){ steps { sh './ci.sh Team-Gate-Test-T095-Performance' } }
		stage('Team-Gate-Test-T095-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T095-Security' } }
		stage('Team-Gate-Test-T095-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T095-Exit' } }

		stage('Team-Gate-T095-Exit') { steps { sh './ci.sh Team-Gate-T095-Exit' } }

		stage('Team-Gate-T095-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T095-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################