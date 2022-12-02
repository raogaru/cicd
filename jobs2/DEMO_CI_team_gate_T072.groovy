// ######################################################################
pipelineJob('DEMO-CI-team-gate-T072') {
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
		vTEAM = 'T072'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T072-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T072-START' } } 

		stage('Team-Gate-T072-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T072',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T072-Enter') 		{ steps { sh './ci.sh Team-Gate-T072-Enter' } }

		stage('Team-Gate-Build-T072-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T072-Enter' } }
		stage('Team-Gate-Build-T072-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T072-DB1' } }
		stage('Team-Gate-Build-T072-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T072-DB2' } }
		stage('Team-Gate-Build-T072-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T072-WWW' } }
		stage('Team-Gate-Build-T072-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T072-APP1' } }
		stage('Team-Gate-Build-T072-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T072-APP2' } }
		stage('Team-Gate-Build-T072-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T072-APP3' } }
		stage('Team-Gate-Build-T072-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T072-' } }

		stage('Team-Gate-Deploy-T072-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T072-Enter' } }
		stage('Team-Gate-Deploy-T072-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T072-DB1' } }
		stage('Team-Gate-Deploy-T072-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T072-DB2' } }
		stage('Team-Gate-Deploy-T072-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T072-WWW' } }
		stage('Team-Gate-Deploy-T072-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T072-APP1' } }
		stage('Team-Gate-Deploy-T072-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T072-APP2' } }
		stage('Team-Gate-Deploy-T072-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T072-APP3' } }
		stage('Team-Gate-Deploy-T072-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T072-Exit' } }

		stage('Team-Gate-Test-T072-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T072-Enter' } }
		stage('Team-Gate-Test-T072-Functional') { steps { sh './ci.sh Team-Gate-Test-T072-Functional' } }
		stage('Team-Gate-Test-T072-Performance'){ steps { sh './ci.sh Team-Gate-Test-T072-Performance' } }
		stage('Team-Gate-Test-T072-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T072-Security' } }
		stage('Team-Gate-Test-T072-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T072-Exit' } }

		stage('Team-Gate-T072-Exit') { steps { sh './ci.sh Team-Gate-T072-Exit' } }

		stage('Team-Gate-T072-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T072-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
