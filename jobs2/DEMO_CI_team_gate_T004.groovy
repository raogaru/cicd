// ######################################################################
pipelineJob('DEMO-CI-team-gate-T004') {
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
		vTEAM = 'T004'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T004-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T004-START' } } 

		stage('Team-Gate-T004-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T004',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T004-Enter') 		{ steps { sh './ci.sh Team-Gate-T004-Enter' } }

		stage('Team-Gate-Build-T004-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T004-Enter' } }
		stage('Team-Gate-Build-T004-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T004-DB1' } }
		stage('Team-Gate-Build-T004-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T004-DB2' } }
		stage('Team-Gate-Build-T004-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T004-WWW' } }
		stage('Team-Gate-Build-T004-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T004-APP1' } }
		stage('Team-Gate-Build-T004-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T004-APP2' } }
		stage('Team-Gate-Build-T004-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T004-APP3' } }
		stage('Team-Gate-Build-T004-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T004-' } }

		stage('Team-Gate-Deploy-T004-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T004-Enter' } }
		stage('Team-Gate-Deploy-T004-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T004-DB1' } }
		stage('Team-Gate-Deploy-T004-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T004-DB2' } }
		stage('Team-Gate-Deploy-T004-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T004-WWW' } }
		stage('Team-Gate-Deploy-T004-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T004-APP1' } }
		stage('Team-Gate-Deploy-T004-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T004-APP2' } }
		stage('Team-Gate-Deploy-T004-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T004-APP3' } }
		stage('Team-Gate-Deploy-T004-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T004-Exit' } }

		stage('Team-Gate-Test-T004-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T004-Enter' } }
		stage('Team-Gate-Test-T004-Functional') { steps { sh './ci.sh Team-Gate-Test-T004-Functional' } }
		stage('Team-Gate-Test-T004-Performance'){ steps { sh './ci.sh Team-Gate-Test-T004-Performance' } }
		stage('Team-Gate-Test-T004-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T004-Security' } }
		stage('Team-Gate-Test-T004-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T004-Exit' } }

		stage('Team-Gate-T004-Exit') { steps { sh './ci.sh Team-Gate-T004-Exit' } }

		stage('Team-Gate-T004-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T004-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
