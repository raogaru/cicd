// ######################################################################
pipelineJob('DEMO-CI-team-gate-T082') {
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
		vTEAM = 'T082'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T082-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T082-START' } } 

		stage('Team-Gate-T082-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T082',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T082-Enter') 		{ steps { sh './ci.sh Team-Gate-T082-Enter' } }

		stage('Team-Gate-Build-T082-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T082-Enter' } }
		stage('Team-Gate-Build-T082-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T082-DB1' } }
		stage('Team-Gate-Build-T082-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T082-DB2' } }
		stage('Team-Gate-Build-T082-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T082-WWW' } }
		stage('Team-Gate-Build-T082-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T082-APP1' } }
		stage('Team-Gate-Build-T082-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T082-APP2' } }
		stage('Team-Gate-Build-T082-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T082-APP3' } }
		stage('Team-Gate-Build-T082-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T082-' } }

		stage('Team-Gate-Deploy-T082-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T082-Enter' } }
		stage('Team-Gate-Deploy-T082-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T082-DB1' } }
		stage('Team-Gate-Deploy-T082-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T082-DB2' } }
		stage('Team-Gate-Deploy-T082-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T082-WWW' } }
		stage('Team-Gate-Deploy-T082-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T082-APP1' } }
		stage('Team-Gate-Deploy-T082-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T082-APP2' } }
		stage('Team-Gate-Deploy-T082-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T082-APP3' } }
		stage('Team-Gate-Deploy-T082-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T082-Exit' } }

		stage('Team-Gate-Test-T082-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T082-Enter' } }
		stage('Team-Gate-Test-T082-Functional') { steps { sh './ci.sh Team-Gate-Test-T082-Functional' } }
		stage('Team-Gate-Test-T082-Performance'){ steps { sh './ci.sh Team-Gate-Test-T082-Performance' } }
		stage('Team-Gate-Test-T082-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T082-Security' } }
		stage('Team-Gate-Test-T082-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T082-Exit' } }

		stage('Team-Gate-T082-Exit') { steps { sh './ci.sh Team-Gate-T082-Exit' } }

		stage('Team-Gate-T082-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T082-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
