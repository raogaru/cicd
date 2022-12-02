// ######################################################################
pipelineJob('DEMO-CI-team-gate-T042') {
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
		vTEAM = 'T042'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T042-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T042-START' } } 

		stage('Team-Gate-T042-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T042',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T042-Enter') 		{ steps { sh './ci.sh Team-Gate-T042-Enter' } }

		stage('Team-Gate-Build-T042-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T042-Enter' } }
		stage('Team-Gate-Build-T042-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T042-DB1' } }
		stage('Team-Gate-Build-T042-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T042-DB2' } }
		stage('Team-Gate-Build-T042-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T042-WWW' } }
		stage('Team-Gate-Build-T042-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T042-APP1' } }
		stage('Team-Gate-Build-T042-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T042-APP2' } }
		stage('Team-Gate-Build-T042-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T042-APP3' } }
		stage('Team-Gate-Build-T042-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T042-' } }

		stage('Team-Gate-Deploy-T042-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T042-Enter' } }
		stage('Team-Gate-Deploy-T042-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T042-DB1' } }
		stage('Team-Gate-Deploy-T042-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T042-DB2' } }
		stage('Team-Gate-Deploy-T042-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T042-WWW' } }
		stage('Team-Gate-Deploy-T042-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T042-APP1' } }
		stage('Team-Gate-Deploy-T042-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T042-APP2' } }
		stage('Team-Gate-Deploy-T042-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T042-APP3' } }
		stage('Team-Gate-Deploy-T042-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T042-Exit' } }

		stage('Team-Gate-Test-T042-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T042-Enter' } }
		stage('Team-Gate-Test-T042-Functional') { steps { sh './ci.sh Team-Gate-Test-T042-Functional' } }
		stage('Team-Gate-Test-T042-Performance'){ steps { sh './ci.sh Team-Gate-Test-T042-Performance' } }
		stage('Team-Gate-Test-T042-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T042-Security' } }
		stage('Team-Gate-Test-T042-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T042-Exit' } }

		stage('Team-Gate-T042-Exit') { steps { sh './ci.sh Team-Gate-T042-Exit' } }

		stage('Team-Gate-T042-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T042-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
