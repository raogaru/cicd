// ######################################################################
pipelineJob('DEMO-CI-team-gate-T061') {
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
		vTEAM = 'T061'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T061-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T061-START' } } 

		stage('Team-Gate-T061-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T061',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T061-Enter') 		{ steps { sh './ci.sh Team-Gate-T061-Enter' } }

		stage('Team-Gate-Build-T061-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T061-Enter' } }
		stage('Team-Gate-Build-T061-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T061-DB1' } }
		stage('Team-Gate-Build-T061-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T061-DB2' } }
		stage('Team-Gate-Build-T061-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T061-WWW' } }
		stage('Team-Gate-Build-T061-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T061-APP1' } }
		stage('Team-Gate-Build-T061-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T061-APP2' } }
		stage('Team-Gate-Build-T061-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T061-APP3' } }
		stage('Team-Gate-Build-T061-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T061-' } }

		stage('Team-Gate-Deploy-T061-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T061-Enter' } }
		stage('Team-Gate-Deploy-T061-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T061-DB1' } }
		stage('Team-Gate-Deploy-T061-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T061-DB2' } }
		stage('Team-Gate-Deploy-T061-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T061-WWW' } }
		stage('Team-Gate-Deploy-T061-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T061-APP1' } }
		stage('Team-Gate-Deploy-T061-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T061-APP2' } }
		stage('Team-Gate-Deploy-T061-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T061-APP3' } }
		stage('Team-Gate-Deploy-T061-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T061-Exit' } }

		stage('Team-Gate-Test-T061-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T061-Enter' } }
		stage('Team-Gate-Test-T061-Functional') { steps { sh './ci.sh Team-Gate-Test-T061-Functional' } }
		stage('Team-Gate-Test-T061-Performance'){ steps { sh './ci.sh Team-Gate-Test-T061-Performance' } }
		stage('Team-Gate-Test-T061-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T061-Security' } }
		stage('Team-Gate-Test-T061-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T061-Exit' } }

		stage('Team-Gate-T061-Exit') { steps { sh './ci.sh Team-Gate-T061-Exit' } }

		stage('Team-Gate-T061-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T061-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
