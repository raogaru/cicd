// ######################################################################
pipelineJob('DEMO-CI-team-gate-T020') {
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
		vTEAM = 'T020'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T020-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T020-START' } } 

		stage('Team-Gate-T020-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T020',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T020-Enter') 		{ steps { sh './ci.sh Team-Gate-T020-Enter' } }

		stage('Team-Gate-Build-T020-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T020-Enter' } }
		stage('Team-Gate-Build-T020-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T020-DB1' } }
		stage('Team-Gate-Build-T020-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T020-DB2' } }
		stage('Team-Gate-Build-T020-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T020-WWW' } }
		stage('Team-Gate-Build-T020-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T020-APP1' } }
		stage('Team-Gate-Build-T020-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T020-APP2' } }
		stage('Team-Gate-Build-T020-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T020-APP3' } }
		stage('Team-Gate-Build-T020-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T020-' } }

		stage('Team-Gate-Deploy-T020-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T020-Enter' } }
		stage('Team-Gate-Deploy-T020-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T020-DB1' } }
		stage('Team-Gate-Deploy-T020-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T020-DB2' } }
		stage('Team-Gate-Deploy-T020-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T020-WWW' } }
		stage('Team-Gate-Deploy-T020-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T020-APP1' } }
		stage('Team-Gate-Deploy-T020-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T020-APP2' } }
		stage('Team-Gate-Deploy-T020-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T020-APP3' } }
		stage('Team-Gate-Deploy-T020-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T020-Exit' } }

		stage('Team-Gate-Test-T020-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T020-Enter' } }
		stage('Team-Gate-Test-T020-Functional') { steps { sh './ci.sh Team-Gate-Test-T020-Functional' } }
		stage('Team-Gate-Test-T020-Performance'){ steps { sh './ci.sh Team-Gate-Test-T020-Performance' } }
		stage('Team-Gate-Test-T020-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T020-Security' } }
		stage('Team-Gate-Test-T020-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T020-Exit' } }

		stage('Team-Gate-T020-Exit') { steps { sh './ci.sh Team-Gate-T020-Exit' } }

		stage('Team-Gate-T020-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T020-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
