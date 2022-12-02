// ######################################################################
pipelineJob('DEMO-CI-team-gate-T053') {
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
		vTEAM = 'T053'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T053-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T053-START' } } 

		stage('Team-Gate-T053-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T053',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T053-Enter') 		{ steps { sh './ci.sh Team-Gate-T053-Enter' } }

		stage('Team-Gate-Build-T053-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T053-Enter' } }
		stage('Team-Gate-Build-T053-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T053-DB1' } }
		stage('Team-Gate-Build-T053-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T053-DB2' } }
		stage('Team-Gate-Build-T053-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T053-WWW' } }
		stage('Team-Gate-Build-T053-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T053-APP1' } }
		stage('Team-Gate-Build-T053-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T053-APP2' } }
		stage('Team-Gate-Build-T053-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T053-APP3' } }
		stage('Team-Gate-Build-T053-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T053-' } }

		stage('Team-Gate-Deploy-T053-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T053-Enter' } }
		stage('Team-Gate-Deploy-T053-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T053-DB1' } }
		stage('Team-Gate-Deploy-T053-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T053-DB2' } }
		stage('Team-Gate-Deploy-T053-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T053-WWW' } }
		stage('Team-Gate-Deploy-T053-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T053-APP1' } }
		stage('Team-Gate-Deploy-T053-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T053-APP2' } }
		stage('Team-Gate-Deploy-T053-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T053-APP3' } }
		stage('Team-Gate-Deploy-T053-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T053-Exit' } }

		stage('Team-Gate-Test-T053-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T053-Enter' } }
		stage('Team-Gate-Test-T053-Functional') { steps { sh './ci.sh Team-Gate-Test-T053-Functional' } }
		stage('Team-Gate-Test-T053-Performance'){ steps { sh './ci.sh Team-Gate-Test-T053-Performance' } }
		stage('Team-Gate-Test-T053-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T053-Security' } }
		stage('Team-Gate-Test-T053-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T053-Exit' } }

		stage('Team-Gate-T053-Exit') { steps { sh './ci.sh Team-Gate-T053-Exit' } }

		stage('Team-Gate-T053-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T053-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
