// ######################################################################
pipelineJob('DEMO-CI-team-gate-T057') {
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
		vTEAM = 'T057'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T057-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T057-START' } } 

		stage('Team-Gate-T057-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T057',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T057-Enter') 		{ steps { sh './ci.sh Team-Gate-T057-Enter' } }

		stage('Team-Gate-Build-T057-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T057-Enter' } }
		stage('Team-Gate-Build-T057-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T057-DB1' } }
		stage('Team-Gate-Build-T057-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T057-DB2' } }
		stage('Team-Gate-Build-T057-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T057-WWW' } }
		stage('Team-Gate-Build-T057-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T057-APP1' } }
		stage('Team-Gate-Build-T057-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T057-APP2' } }
		stage('Team-Gate-Build-T057-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T057-APP3' } }
		stage('Team-Gate-Build-T057-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T057-' } }

		stage('Team-Gate-Deploy-T057-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T057-Enter' } }
		stage('Team-Gate-Deploy-T057-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T057-DB1' } }
		stage('Team-Gate-Deploy-T057-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T057-DB2' } }
		stage('Team-Gate-Deploy-T057-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T057-WWW' } }
		stage('Team-Gate-Deploy-T057-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T057-APP1' } }
		stage('Team-Gate-Deploy-T057-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T057-APP2' } }
		stage('Team-Gate-Deploy-T057-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T057-APP3' } }
		stage('Team-Gate-Deploy-T057-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T057-Exit' } }

		stage('Team-Gate-Test-T057-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T057-Enter' } }
		stage('Team-Gate-Test-T057-Functional') { steps { sh './ci.sh Team-Gate-Test-T057-Functional' } }
		stage('Team-Gate-Test-T057-Performance'){ steps { sh './ci.sh Team-Gate-Test-T057-Performance' } }
		stage('Team-Gate-Test-T057-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T057-Security' } }
		stage('Team-Gate-Test-T057-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T057-Exit' } }

		stage('Team-Gate-T057-Exit') { steps { sh './ci.sh Team-Gate-T057-Exit' } }

		stage('Team-Gate-T057-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T057-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
