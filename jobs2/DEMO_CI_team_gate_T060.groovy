// ######################################################################
pipelineJob('DEMO-CI-team-gate-T060') {
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
		vTEAM = 'T060'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T060-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T060-START' } } 

		stage('Team-Gate-T060-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T060',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T060-Enter') 		{ steps { sh './ci.sh Team-Gate-T060-Enter' } }

		stage('Team-Gate-Build-T060-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T060-Enter' } }
		stage('Team-Gate-Build-T060-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T060-DB1' } }
		stage('Team-Gate-Build-T060-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T060-DB2' } }
		stage('Team-Gate-Build-T060-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T060-WWW' } }
		stage('Team-Gate-Build-T060-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T060-APP1' } }
		stage('Team-Gate-Build-T060-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T060-APP2' } }
		stage('Team-Gate-Build-T060-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T060-APP3' } }
		stage('Team-Gate-Build-T060-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T060-' } }

		stage('Team-Gate-Deploy-T060-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T060-Enter' } }
		stage('Team-Gate-Deploy-T060-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T060-DB1' } }
		stage('Team-Gate-Deploy-T060-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T060-DB2' } }
		stage('Team-Gate-Deploy-T060-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T060-WWW' } }
		stage('Team-Gate-Deploy-T060-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T060-APP1' } }
		stage('Team-Gate-Deploy-T060-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T060-APP2' } }
		stage('Team-Gate-Deploy-T060-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T060-APP3' } }
		stage('Team-Gate-Deploy-T060-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T060-Exit' } }

		stage('Team-Gate-Test-T060-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T060-Enter' } }
		stage('Team-Gate-Test-T060-Functional') { steps { sh './ci.sh Team-Gate-Test-T060-Functional' } }
		stage('Team-Gate-Test-T060-Performance'){ steps { sh './ci.sh Team-Gate-Test-T060-Performance' } }
		stage('Team-Gate-Test-T060-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T060-Security' } }
		stage('Team-Gate-Test-T060-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T060-Exit' } }

		stage('Team-Gate-T060-Exit') { steps { sh './ci.sh Team-Gate-T060-Exit' } }

		stage('Team-Gate-T060-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T060-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
