// ######################################################################
pipelineJob('DEMO-CI-team-gate-T093') {
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
		vTEAM = 'T093'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T093-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T093-START' } } 

		stage('Team-Gate-T093-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T093',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T093-Enter') 		{ steps { sh './ci.sh Team-Gate-T093-Enter' } }

		stage('Team-Gate-Build-T093-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T093-Enter' } }
		stage('Team-Gate-Build-T093-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T093-DB1' } }
		stage('Team-Gate-Build-T093-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T093-DB2' } }
		stage('Team-Gate-Build-T093-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T093-WWW' } }
		stage('Team-Gate-Build-T093-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T093-APP1' } }
		stage('Team-Gate-Build-T093-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T093-APP2' } }
		stage('Team-Gate-Build-T093-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T093-APP3' } }
		stage('Team-Gate-Build-T093-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T093-' } }

		stage('Team-Gate-Deploy-T093-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T093-Enter' } }
		stage('Team-Gate-Deploy-T093-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T093-DB1' } }
		stage('Team-Gate-Deploy-T093-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T093-DB2' } }
		stage('Team-Gate-Deploy-T093-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T093-WWW' } }
		stage('Team-Gate-Deploy-T093-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T093-APP1' } }
		stage('Team-Gate-Deploy-T093-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T093-APP2' } }
		stage('Team-Gate-Deploy-T093-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T093-APP3' } }
		stage('Team-Gate-Deploy-T093-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T093-Exit' } }

		stage('Team-Gate-Test-T093-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T093-Enter' } }
		stage('Team-Gate-Test-T093-Functional') { steps { sh './ci.sh Team-Gate-Test-T093-Functional' } }
		stage('Team-Gate-Test-T093-Performance'){ steps { sh './ci.sh Team-Gate-Test-T093-Performance' } }
		stage('Team-Gate-Test-T093-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T093-Security' } }
		stage('Team-Gate-Test-T093-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T093-Exit' } }

		stage('Team-Gate-T093-Exit') { steps { sh './ci.sh Team-Gate-T093-Exit' } }

		stage('Team-Gate-T093-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T093-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
