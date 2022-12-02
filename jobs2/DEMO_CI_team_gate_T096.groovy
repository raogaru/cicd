// ######################################################################
pipelineJob('DEMO-CI-team-gate-T096') {
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
		vTEAM = 'T096'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T096-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T096-START' } } 

		stage('Team-Gate-T096-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T096',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T096-Enter') 		{ steps { sh './ci.sh Team-Gate-T096-Enter' } }

		stage('Team-Gate-Build-T096-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T096-Enter' } }
		stage('Team-Gate-Build-T096-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T096-DB1' } }
		stage('Team-Gate-Build-T096-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T096-DB2' } }
		stage('Team-Gate-Build-T096-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T096-WWW' } }
		stage('Team-Gate-Build-T096-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T096-APP1' } }
		stage('Team-Gate-Build-T096-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T096-APP2' } }
		stage('Team-Gate-Build-T096-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T096-APP3' } }
		stage('Team-Gate-Build-T096-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T096-' } }

		stage('Team-Gate-Deploy-T096-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T096-Enter' } }
		stage('Team-Gate-Deploy-T096-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T096-DB1' } }
		stage('Team-Gate-Deploy-T096-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T096-DB2' } }
		stage('Team-Gate-Deploy-T096-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T096-WWW' } }
		stage('Team-Gate-Deploy-T096-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T096-APP1' } }
		stage('Team-Gate-Deploy-T096-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T096-APP2' } }
		stage('Team-Gate-Deploy-T096-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T096-APP3' } }
		stage('Team-Gate-Deploy-T096-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T096-Exit' } }

		stage('Team-Gate-Test-T096-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T096-Enter' } }
		stage('Team-Gate-Test-T096-Functional') { steps { sh './ci.sh Team-Gate-Test-T096-Functional' } }
		stage('Team-Gate-Test-T096-Performance'){ steps { sh './ci.sh Team-Gate-Test-T096-Performance' } }
		stage('Team-Gate-Test-T096-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T096-Security' } }
		stage('Team-Gate-Test-T096-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T096-Exit' } }

		stage('Team-Gate-T096-Exit') { steps { sh './ci.sh Team-Gate-T096-Exit' } }

		stage('Team-Gate-T096-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T096-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
