// ######################################################################
pipelineJob('DEMO-CI-21-team-gate-MARS') {
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
		vTEAM = 'MARS'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-MARS-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-MARS-START' } } 

		stage('Team-Gate-MARS-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'master',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-MARS-Enter') 		{ steps { sh './ci.sh Team-Gate-MARS-Enter' } }

		stage('Team-Gate-Build-MARS-Enter')	{ steps { sh './ci.sh Team-Gate-Build-MARS-Enter' } }
		stage('Team-Gate-Build-MARS-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-MARS-DB1' } }
		stage('Team-Gate-Build-MARS-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-MARS-DB2' } }
		stage('Team-Gate-Build-MARS-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-MARS-WWW' } }
		stage('Team-Gate-Build-MARS-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-MARS-APP1' } }
		stage('Team-Gate-Build-MARS-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-MARS-APP2' } }
		stage('Team-Gate-Build-MARS-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-MARS-APP3' } }
		stage('Team-Gate-Build-MARS-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-MARS-' } }

		stage('Team-Gate-Deploy-MARS-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-MARS-Enter' } }
		stage('Team-Gate-Deploy-MARS-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-MARS-DB1' } }
		stage('Team-Gate-Deploy-MARS-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-MARS-DB2' } }
		stage('Team-Gate-Deploy-MARS-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-MARS-WWW' } }
		stage('Team-Gate-Deploy-MARS-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-MARS-APP1' } }
		stage('Team-Gate-Deploy-MARS-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-MARS-APP2' } }
		stage('Team-Gate-Deploy-MARS-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-MARS-APP3' } }
		stage('Team-Gate-Deploy-MARS-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-MARS-Exit' } }

		stage('Team-Gate-Test-MARS-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-MARS-Enter' } }
		stage('Team-Gate-Test-MARS-Functional') { steps { sh './ci.sh Team-Gate-Test-MARS-Functional' } }
		stage('Team-Gate-Test-MARS-Performance'){ steps { sh './ci.sh Team-Gate-Test-MARS-Performance' } }
		stage('Team-Gate-Test-MARS-Security') 	{ steps { sh './ci.sh Team-Gate-Test-MARS-Security' } }
		stage('Team-Gate-Test-MARS-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-MARS-Exit' } }

		stage('Team-Gate-MARS-Exit') { steps { sh './ci.sh Team-Gate-MARS-Exit' } }

		stage('Team-Gate-MARS-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-MARS-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
