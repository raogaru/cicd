// ######################################################################
pipelineJob('DEMO-CI-team-gate-T066') {
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
		vTEAM = 'T066'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T066-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T066-START' } } 

		stage('Team-Gate-T066-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T066',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T066-Enter') 		{ steps { sh './ci.sh Team-Gate-T066-Enter' } }

		stage('Team-Gate-Build-T066-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T066-Enter' } }
		stage('Team-Gate-Build-T066-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T066-DB1' } }
		stage('Team-Gate-Build-T066-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T066-DB2' } }
		stage('Team-Gate-Build-T066-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T066-WWW' } }
		stage('Team-Gate-Build-T066-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T066-APP1' } }
		stage('Team-Gate-Build-T066-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T066-APP2' } }
		stage('Team-Gate-Build-T066-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T066-APP3' } }
		stage('Team-Gate-Build-T066-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T066-' } }

		stage('Team-Gate-Deploy-T066-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T066-Enter' } }
		stage('Team-Gate-Deploy-T066-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T066-DB1' } }
		stage('Team-Gate-Deploy-T066-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T066-DB2' } }
		stage('Team-Gate-Deploy-T066-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T066-WWW' } }
		stage('Team-Gate-Deploy-T066-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T066-APP1' } }
		stage('Team-Gate-Deploy-T066-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T066-APP2' } }
		stage('Team-Gate-Deploy-T066-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T066-APP3' } }
		stage('Team-Gate-Deploy-T066-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T066-Exit' } }

		stage('Team-Gate-Test-T066-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T066-Enter' } }
		stage('Team-Gate-Test-T066-Functional') { steps { sh './ci.sh Team-Gate-Test-T066-Functional' } }
		stage('Team-Gate-Test-T066-Performance'){ steps { sh './ci.sh Team-Gate-Test-T066-Performance' } }
		stage('Team-Gate-Test-T066-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T066-Security' } }
		stage('Team-Gate-Test-T066-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T066-Exit' } }

		stage('Team-Gate-T066-Exit') { steps { sh './ci.sh Team-Gate-T066-Exit' } }

		stage('Team-Gate-T066-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T066-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
