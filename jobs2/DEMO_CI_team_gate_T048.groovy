// ######################################################################
pipelineJob('DEMO-CI-team-gate-T048') {
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
		vTEAM = 'T048'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T048-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T048-START' } } 

		stage('Team-Gate-T048-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T048',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T048-Enter') 		{ steps { sh './ci.sh Team-Gate-T048-Enter' } }

		stage('Team-Gate-Build-T048-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T048-Enter' } }
		stage('Team-Gate-Build-T048-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T048-DB1' } }
		stage('Team-Gate-Build-T048-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T048-DB2' } }
		stage('Team-Gate-Build-T048-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T048-WWW' } }
		stage('Team-Gate-Build-T048-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T048-APP1' } }
		stage('Team-Gate-Build-T048-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T048-APP2' } }
		stage('Team-Gate-Build-T048-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T048-APP3' } }
		stage('Team-Gate-Build-T048-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T048-' } }

		stage('Team-Gate-Deploy-T048-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T048-Enter' } }
		stage('Team-Gate-Deploy-T048-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T048-DB1' } }
		stage('Team-Gate-Deploy-T048-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T048-DB2' } }
		stage('Team-Gate-Deploy-T048-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T048-WWW' } }
		stage('Team-Gate-Deploy-T048-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T048-APP1' } }
		stage('Team-Gate-Deploy-T048-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T048-APP2' } }
		stage('Team-Gate-Deploy-T048-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T048-APP3' } }
		stage('Team-Gate-Deploy-T048-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T048-Exit' } }

		stage('Team-Gate-Test-T048-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T048-Enter' } }
		stage('Team-Gate-Test-T048-Functional') { steps { sh './ci.sh Team-Gate-Test-T048-Functional' } }
		stage('Team-Gate-Test-T048-Performance'){ steps { sh './ci.sh Team-Gate-Test-T048-Performance' } }
		stage('Team-Gate-Test-T048-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T048-Security' } }
		stage('Team-Gate-Test-T048-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T048-Exit' } }

		stage('Team-Gate-T048-Exit') { steps { sh './ci.sh Team-Gate-T048-Exit' } }

		stage('Team-Gate-T048-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T048-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
