// ######################################################################
pipelineJob('DEMO-CI-team-gate-T046') {
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
		vTEAM = 'T046'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T046-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T046-START' } } 

		stage('Team-Gate-T046-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T046',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T046-Enter') 		{ steps { sh './ci.sh Team-Gate-T046-Enter' } }

		stage('Team-Gate-Build-T046-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T046-Enter' } }
		stage('Team-Gate-Build-T046-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T046-DB1' } }
		stage('Team-Gate-Build-T046-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T046-DB2' } }
		stage('Team-Gate-Build-T046-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T046-WWW' } }
		stage('Team-Gate-Build-T046-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T046-APP1' } }
		stage('Team-Gate-Build-T046-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T046-APP2' } }
		stage('Team-Gate-Build-T046-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T046-APP3' } }
		stage('Team-Gate-Build-T046-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T046-' } }

		stage('Team-Gate-Deploy-T046-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T046-Enter' } }
		stage('Team-Gate-Deploy-T046-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T046-DB1' } }
		stage('Team-Gate-Deploy-T046-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T046-DB2' } }
		stage('Team-Gate-Deploy-T046-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T046-WWW' } }
		stage('Team-Gate-Deploy-T046-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T046-APP1' } }
		stage('Team-Gate-Deploy-T046-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T046-APP2' } }
		stage('Team-Gate-Deploy-T046-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T046-APP3' } }
		stage('Team-Gate-Deploy-T046-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T046-Exit' } }

		stage('Team-Gate-Test-T046-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T046-Enter' } }
		stage('Team-Gate-Test-T046-Functional') { steps { sh './ci.sh Team-Gate-Test-T046-Functional' } }
		stage('Team-Gate-Test-T046-Performance'){ steps { sh './ci.sh Team-Gate-Test-T046-Performance' } }
		stage('Team-Gate-Test-T046-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T046-Security' } }
		stage('Team-Gate-Test-T046-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T046-Exit' } }

		stage('Team-Gate-T046-Exit') { steps { sh './ci.sh Team-Gate-T046-Exit' } }

		stage('Team-Gate-T046-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T046-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
