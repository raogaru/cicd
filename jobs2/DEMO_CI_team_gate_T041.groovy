// ######################################################################
pipelineJob('DEMO-CI-team-gate-T041') {
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
		vTEAM = 'T041'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T041-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T041-START' } } 

		stage('Team-Gate-T041-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T041',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T041-Enter') 		{ steps { sh './ci.sh Team-Gate-T041-Enter' } }

		stage('Team-Gate-Build-T041-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T041-Enter' } }
		stage('Team-Gate-Build-T041-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T041-DB1' } }
		stage('Team-Gate-Build-T041-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T041-DB2' } }
		stage('Team-Gate-Build-T041-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T041-WWW' } }
		stage('Team-Gate-Build-T041-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T041-APP1' } }
		stage('Team-Gate-Build-T041-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T041-APP2' } }
		stage('Team-Gate-Build-T041-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T041-APP3' } }
		stage('Team-Gate-Build-T041-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T041-' } }

		stage('Team-Gate-Deploy-T041-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T041-Enter' } }
		stage('Team-Gate-Deploy-T041-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T041-DB1' } }
		stage('Team-Gate-Deploy-T041-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T041-DB2' } }
		stage('Team-Gate-Deploy-T041-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T041-WWW' } }
		stage('Team-Gate-Deploy-T041-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T041-APP1' } }
		stage('Team-Gate-Deploy-T041-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T041-APP2' } }
		stage('Team-Gate-Deploy-T041-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T041-APP3' } }
		stage('Team-Gate-Deploy-T041-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T041-Exit' } }

		stage('Team-Gate-Test-T041-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T041-Enter' } }
		stage('Team-Gate-Test-T041-Functional') { steps { sh './ci.sh Team-Gate-Test-T041-Functional' } }
		stage('Team-Gate-Test-T041-Performance'){ steps { sh './ci.sh Team-Gate-Test-T041-Performance' } }
		stage('Team-Gate-Test-T041-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T041-Security' } }
		stage('Team-Gate-Test-T041-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T041-Exit' } }

		stage('Team-Gate-T041-Exit') { steps { sh './ci.sh Team-Gate-T041-Exit' } }

		stage('Team-Gate-T041-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T041-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
