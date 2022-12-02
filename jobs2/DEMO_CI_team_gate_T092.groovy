// ######################################################################
pipelineJob('DEMO-CI-team-gate-T092') {
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
		vTEAM = 'T092'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T092-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T092-START' } } 

		stage('Team-Gate-T092-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T092',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T092-Enter') 		{ steps { sh './ci.sh Team-Gate-T092-Enter' } }

		stage('Team-Gate-Build-T092-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T092-Enter' } }
		stage('Team-Gate-Build-T092-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T092-DB1' } }
		stage('Team-Gate-Build-T092-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T092-DB2' } }
		stage('Team-Gate-Build-T092-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T092-WWW' } }
		stage('Team-Gate-Build-T092-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T092-APP1' } }
		stage('Team-Gate-Build-T092-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T092-APP2' } }
		stage('Team-Gate-Build-T092-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T092-APP3' } }
		stage('Team-Gate-Build-T092-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T092-' } }

		stage('Team-Gate-Deploy-T092-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T092-Enter' } }
		stage('Team-Gate-Deploy-T092-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T092-DB1' } }
		stage('Team-Gate-Deploy-T092-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T092-DB2' } }
		stage('Team-Gate-Deploy-T092-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T092-WWW' } }
		stage('Team-Gate-Deploy-T092-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T092-APP1' } }
		stage('Team-Gate-Deploy-T092-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T092-APP2' } }
		stage('Team-Gate-Deploy-T092-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T092-APP3' } }
		stage('Team-Gate-Deploy-T092-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T092-Exit' } }

		stage('Team-Gate-Test-T092-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T092-Enter' } }
		stage('Team-Gate-Test-T092-Functional') { steps { sh './ci.sh Team-Gate-Test-T092-Functional' } }
		stage('Team-Gate-Test-T092-Performance'){ steps { sh './ci.sh Team-Gate-Test-T092-Performance' } }
		stage('Team-Gate-Test-T092-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T092-Security' } }
		stage('Team-Gate-Test-T092-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T092-Exit' } }

		stage('Team-Gate-T092-Exit') { steps { sh './ci.sh Team-Gate-T092-Exit' } }

		stage('Team-Gate-T092-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T092-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
