// ######################################################################
pipelineJob('DEMO-CI-team-gate-T033') {
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
		vTEAM = 'T033'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T033-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T033-START' } } 

		stage('Team-Gate-T033-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T033',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T033-Enter') 		{ steps { sh './ci.sh Team-Gate-T033-Enter' } }

		stage('Team-Gate-Build-T033-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T033-Enter' } }
		stage('Team-Gate-Build-T033-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T033-DB1' } }
		stage('Team-Gate-Build-T033-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T033-DB2' } }
		stage('Team-Gate-Build-T033-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T033-WWW' } }
		stage('Team-Gate-Build-T033-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T033-APP1' } }
		stage('Team-Gate-Build-T033-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T033-APP2' } }
		stage('Team-Gate-Build-T033-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T033-APP3' } }
		stage('Team-Gate-Build-T033-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T033-' } }

		stage('Team-Gate-Deploy-T033-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T033-Enter' } }
		stage('Team-Gate-Deploy-T033-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T033-DB1' } }
		stage('Team-Gate-Deploy-T033-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T033-DB2' } }
		stage('Team-Gate-Deploy-T033-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T033-WWW' } }
		stage('Team-Gate-Deploy-T033-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T033-APP1' } }
		stage('Team-Gate-Deploy-T033-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T033-APP2' } }
		stage('Team-Gate-Deploy-T033-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T033-APP3' } }
		stage('Team-Gate-Deploy-T033-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T033-Exit' } }

		stage('Team-Gate-Test-T033-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T033-Enter' } }
		stage('Team-Gate-Test-T033-Functional') { steps { sh './ci.sh Team-Gate-Test-T033-Functional' } }
		stage('Team-Gate-Test-T033-Performance'){ steps { sh './ci.sh Team-Gate-Test-T033-Performance' } }
		stage('Team-Gate-Test-T033-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T033-Security' } }
		stage('Team-Gate-Test-T033-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T033-Exit' } }

		stage('Team-Gate-T033-Exit') { steps { sh './ci.sh Team-Gate-T033-Exit' } }

		stage('Team-Gate-T033-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T033-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
