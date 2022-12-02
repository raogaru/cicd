// ######################################################################
pipelineJob('DEMO-CI-team-gate-T085') {
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
		vTEAM = 'T085'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T085-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T085-START' } } 

		stage('Team-Gate-T085-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T085',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T085-Enter') 		{ steps { sh './ci.sh Team-Gate-T085-Enter' } }

		stage('Team-Gate-Build-T085-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T085-Enter' } }
		stage('Team-Gate-Build-T085-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T085-DB1' } }
		stage('Team-Gate-Build-T085-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T085-DB2' } }
		stage('Team-Gate-Build-T085-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T085-WWW' } }
		stage('Team-Gate-Build-T085-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T085-APP1' } }
		stage('Team-Gate-Build-T085-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T085-APP2' } }
		stage('Team-Gate-Build-T085-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T085-APP3' } }
		stage('Team-Gate-Build-T085-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T085-' } }

		stage('Team-Gate-Deploy-T085-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T085-Enter' } }
		stage('Team-Gate-Deploy-T085-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T085-DB1' } }
		stage('Team-Gate-Deploy-T085-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T085-DB2' } }
		stage('Team-Gate-Deploy-T085-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T085-WWW' } }
		stage('Team-Gate-Deploy-T085-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T085-APP1' } }
		stage('Team-Gate-Deploy-T085-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T085-APP2' } }
		stage('Team-Gate-Deploy-T085-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T085-APP3' } }
		stage('Team-Gate-Deploy-T085-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T085-Exit' } }

		stage('Team-Gate-Test-T085-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T085-Enter' } }
		stage('Team-Gate-Test-T085-Functional') { steps { sh './ci.sh Team-Gate-Test-T085-Functional' } }
		stage('Team-Gate-Test-T085-Performance'){ steps { sh './ci.sh Team-Gate-Test-T085-Performance' } }
		stage('Team-Gate-Test-T085-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T085-Security' } }
		stage('Team-Gate-Test-T085-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T085-Exit' } }

		stage('Team-Gate-T085-Exit') { steps { sh './ci.sh Team-Gate-T085-Exit' } }

		stage('Team-Gate-T085-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T085-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
