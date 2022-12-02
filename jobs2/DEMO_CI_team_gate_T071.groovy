// ######################################################################
pipelineJob('DEMO-CI-team-gate-T071') {
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
		vTEAM = 'T071'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T071-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T071-START' } } 

		stage('Team-Gate-T071-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T071',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T071-Enter') 		{ steps { sh './ci.sh Team-Gate-T071-Enter' } }

		stage('Team-Gate-Build-T071-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T071-Enter' } }
		stage('Team-Gate-Build-T071-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T071-DB1' } }
		stage('Team-Gate-Build-T071-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T071-DB2' } }
		stage('Team-Gate-Build-T071-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T071-WWW' } }
		stage('Team-Gate-Build-T071-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T071-APP1' } }
		stage('Team-Gate-Build-T071-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T071-APP2' } }
		stage('Team-Gate-Build-T071-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T071-APP3' } }
		stage('Team-Gate-Build-T071-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T071-' } }

		stage('Team-Gate-Deploy-T071-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T071-Enter' } }
		stage('Team-Gate-Deploy-T071-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T071-DB1' } }
		stage('Team-Gate-Deploy-T071-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T071-DB2' } }
		stage('Team-Gate-Deploy-T071-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T071-WWW' } }
		stage('Team-Gate-Deploy-T071-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T071-APP1' } }
		stage('Team-Gate-Deploy-T071-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T071-APP2' } }
		stage('Team-Gate-Deploy-T071-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T071-APP3' } }
		stage('Team-Gate-Deploy-T071-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T071-Exit' } }

		stage('Team-Gate-Test-T071-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T071-Enter' } }
		stage('Team-Gate-Test-T071-Functional') { steps { sh './ci.sh Team-Gate-Test-T071-Functional' } }
		stage('Team-Gate-Test-T071-Performance'){ steps { sh './ci.sh Team-Gate-Test-T071-Performance' } }
		stage('Team-Gate-Test-T071-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T071-Security' } }
		stage('Team-Gate-Test-T071-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T071-Exit' } }

		stage('Team-Gate-T071-Exit') { steps { sh './ci.sh Team-Gate-T071-Exit' } }

		stage('Team-Gate-T071-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T071-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
