// ######################################################################
pipelineJob('DEMO-CI-team-gate-T037') {
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
		vTEAM = 'T037'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T037-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T037-START' } } 

		stage('Team-Gate-T037-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T037',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T037-Enter') 		{ steps { sh './ci.sh Team-Gate-T037-Enter' } }

		stage('Team-Gate-Build-T037-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T037-Enter' } }
		stage('Team-Gate-Build-T037-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T037-DB1' } }
		stage('Team-Gate-Build-T037-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T037-DB2' } }
		stage('Team-Gate-Build-T037-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T037-WWW' } }
		stage('Team-Gate-Build-T037-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T037-APP1' } }
		stage('Team-Gate-Build-T037-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T037-APP2' } }
		stage('Team-Gate-Build-T037-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T037-APP3' } }
		stage('Team-Gate-Build-T037-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T037-' } }

		stage('Team-Gate-Deploy-T037-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T037-Enter' } }
		stage('Team-Gate-Deploy-T037-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T037-DB1' } }
		stage('Team-Gate-Deploy-T037-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T037-DB2' } }
		stage('Team-Gate-Deploy-T037-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T037-WWW' } }
		stage('Team-Gate-Deploy-T037-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T037-APP1' } }
		stage('Team-Gate-Deploy-T037-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T037-APP2' } }
		stage('Team-Gate-Deploy-T037-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T037-APP3' } }
		stage('Team-Gate-Deploy-T037-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T037-Exit' } }

		stage('Team-Gate-Test-T037-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T037-Enter' } }
		stage('Team-Gate-Test-T037-Functional') { steps { sh './ci.sh Team-Gate-Test-T037-Functional' } }
		stage('Team-Gate-Test-T037-Performance'){ steps { sh './ci.sh Team-Gate-Test-T037-Performance' } }
		stage('Team-Gate-Test-T037-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T037-Security' } }
		stage('Team-Gate-Test-T037-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T037-Exit' } }

		stage('Team-Gate-T037-Exit') { steps { sh './ci.sh Team-Gate-T037-Exit' } }

		stage('Team-Gate-T037-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T037-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
