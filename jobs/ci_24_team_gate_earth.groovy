// ######################################################################
pipelineJob('DEMO-CI-24-team-gate-EARTH') {
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
		ws('/tmp/cicd')
	}
	environment {
		vGATE = 'TEAM'
		vTEAM = 'EARTH'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-EARTH-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-EARTH-START' } } 

		stage('Team-Gate-EARTH-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-EARTH',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-EARTH-Enter') 		{ steps { sh './ci.sh Team-Gate-EARTH-Enter' } }

		stage('Team-Gate-Build-EARTH-Enter')	{ steps { sh './ci.sh Team-Gate-Build-EARTH-Enter' } }
		stage('Team-Gate-Build-EARTH-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-EARTH-DB1' } }
		stage('Team-Gate-Build-EARTH-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-EARTH-DB2' } }
		stage('Team-Gate-Build-EARTH-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-EARTH-WWW' } }
		stage('Team-Gate-Build-EARTH-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-EARTH-APP1' } }
		stage('Team-Gate-Build-EARTH-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-EARTH-APP2' } }
		stage('Team-Gate-Build-EARTH-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-EARTH-APP3' } }
		stage('Team-Gate-Build-EARTH-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-EARTH-' } }

		stage('Team-Gate-Deploy-EARTH-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-EARTH-Enter' } }
		stage('Team-Gate-Deploy-EARTH-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-EARTH-DB1' } }
		stage('Team-Gate-Deploy-EARTH-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-EARTH-DB2' } }
		stage('Team-Gate-Deploy-EARTH-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-EARTH-WWW' } }
		stage('Team-Gate-Deploy-EARTH-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-EARTH-APP1' } }
		stage('Team-Gate-Deploy-EARTH-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-EARTH-APP2' } }
		stage('Team-Gate-Deploy-EARTH-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-EARTH-APP3' } }
		stage('Team-Gate-Deploy-EARTH-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-EARTH-Exit' } }

		stage('Team-Gate-Test-EARTH-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-EARTH-Enter' } }
		stage('Team-Gate-Test-EARTH-Functional') { steps { sh './ci.sh Team-Gate-Test-EARTH-Functional' } }
		stage('Team-Gate-Test-EARTH-Performance'){ steps { sh './ci.sh Team-Gate-Test-EARTH-Performance' } }
		stage('Team-Gate-Test-EARTH-Security') 	{ steps { sh './ci.sh Team-Gate-Test-EARTH-Security' } }
		stage('Team-Gate-Test-EARTH-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-EARTH-Exit' } }

		stage('Team-Gate-EARTH-Exit') { steps { sh './ci.sh Team-Gate-EARTH-Exit' } }

		stage('Team-Gate-EARTH-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-EARTH' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
