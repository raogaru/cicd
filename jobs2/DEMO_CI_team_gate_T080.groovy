// ######################################################################
pipelineJob('DEMO-CI-team-gate-T080') {
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
		vTEAM = 'T080'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T080-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T080-START' } } 

		stage('Team-Gate-T080-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T080',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T080-Enter') 		{ steps { sh './ci.sh Team-Gate-T080-Enter' } }

		stage('Team-Gate-Build-T080-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T080-Enter' } }
		stage('Team-Gate-Build-T080-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T080-DB1' } }
		stage('Team-Gate-Build-T080-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T080-DB2' } }
		stage('Team-Gate-Build-T080-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T080-WWW' } }
		stage('Team-Gate-Build-T080-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T080-APP1' } }
		stage('Team-Gate-Build-T080-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T080-APP2' } }
		stage('Team-Gate-Build-T080-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T080-APP3' } }
		stage('Team-Gate-Build-T080-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T080-' } }

		stage('Team-Gate-Deploy-T080-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T080-Enter' } }
		stage('Team-Gate-Deploy-T080-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T080-DB1' } }
		stage('Team-Gate-Deploy-T080-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T080-DB2' } }
		stage('Team-Gate-Deploy-T080-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T080-WWW' } }
		stage('Team-Gate-Deploy-T080-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T080-APP1' } }
		stage('Team-Gate-Deploy-T080-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T080-APP2' } }
		stage('Team-Gate-Deploy-T080-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T080-APP3' } }
		stage('Team-Gate-Deploy-T080-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T080-Exit' } }

		stage('Team-Gate-Test-T080-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T080-Enter' } }
		stage('Team-Gate-Test-T080-Functional') { steps { sh './ci.sh Team-Gate-Test-T080-Functional' } }
		stage('Team-Gate-Test-T080-Performance'){ steps { sh './ci.sh Team-Gate-Test-T080-Performance' } }
		stage('Team-Gate-Test-T080-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T080-Security' } }
		stage('Team-Gate-Test-T080-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T080-Exit' } }

		stage('Team-Gate-T080-Exit') { steps { sh './ci.sh Team-Gate-T080-Exit' } }

		stage('Team-Gate-T080-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T080-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
