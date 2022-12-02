// ######################################################################
pipelineJob('DEMO-CI-team-gate-T083') {
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
		vTEAM = 'T083'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T083-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T083-START' } } 

		stage('Team-Gate-T083-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T083',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T083-Enter') 		{ steps { sh './ci.sh Team-Gate-T083-Enter' } }

		stage('Team-Gate-Build-T083-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T083-Enter' } }
		stage('Team-Gate-Build-T083-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T083-DB1' } }
		stage('Team-Gate-Build-T083-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T083-DB2' } }
		stage('Team-Gate-Build-T083-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T083-WWW' } }
		stage('Team-Gate-Build-T083-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T083-APP1' } }
		stage('Team-Gate-Build-T083-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T083-APP2' } }
		stage('Team-Gate-Build-T083-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T083-APP3' } }
		stage('Team-Gate-Build-T083-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T083-' } }

		stage('Team-Gate-Deploy-T083-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T083-Enter' } }
		stage('Team-Gate-Deploy-T083-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T083-DB1' } }
		stage('Team-Gate-Deploy-T083-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T083-DB2' } }
		stage('Team-Gate-Deploy-T083-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T083-WWW' } }
		stage('Team-Gate-Deploy-T083-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T083-APP1' } }
		stage('Team-Gate-Deploy-T083-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T083-APP2' } }
		stage('Team-Gate-Deploy-T083-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T083-APP3' } }
		stage('Team-Gate-Deploy-T083-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T083-Exit' } }

		stage('Team-Gate-Test-T083-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T083-Enter' } }
		stage('Team-Gate-Test-T083-Functional') { steps { sh './ci.sh Team-Gate-Test-T083-Functional' } }
		stage('Team-Gate-Test-T083-Performance'){ steps { sh './ci.sh Team-Gate-Test-T083-Performance' } }
		stage('Team-Gate-Test-T083-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T083-Security' } }
		stage('Team-Gate-Test-T083-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T083-Exit' } }

		stage('Team-Gate-T083-Exit') { steps { sh './ci.sh Team-Gate-T083-Exit' } }

		stage('Team-Gate-T083-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T083-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
