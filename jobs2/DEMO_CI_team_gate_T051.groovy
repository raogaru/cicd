// ######################################################################
pipelineJob('DEMO-CI-team-gate-T051') {
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
		vTEAM = 'T051'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T051-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T051-START' } } 

		stage('Team-Gate-T051-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T051',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T051-Enter') 		{ steps { sh './ci.sh Team-Gate-T051-Enter' } }

		stage('Team-Gate-Build-T051-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T051-Enter' } }
		stage('Team-Gate-Build-T051-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T051-DB1' } }
		stage('Team-Gate-Build-T051-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T051-DB2' } }
		stage('Team-Gate-Build-T051-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T051-WWW' } }
		stage('Team-Gate-Build-T051-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T051-APP1' } }
		stage('Team-Gate-Build-T051-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T051-APP2' } }
		stage('Team-Gate-Build-T051-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T051-APP3' } }
		stage('Team-Gate-Build-T051-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T051-' } }

		stage('Team-Gate-Deploy-T051-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T051-Enter' } }
		stage('Team-Gate-Deploy-T051-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T051-DB1' } }
		stage('Team-Gate-Deploy-T051-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T051-DB2' } }
		stage('Team-Gate-Deploy-T051-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T051-WWW' } }
		stage('Team-Gate-Deploy-T051-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T051-APP1' } }
		stage('Team-Gate-Deploy-T051-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T051-APP2' } }
		stage('Team-Gate-Deploy-T051-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T051-APP3' } }
		stage('Team-Gate-Deploy-T051-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T051-Exit' } }

		stage('Team-Gate-Test-T051-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T051-Enter' } }
		stage('Team-Gate-Test-T051-Functional') { steps { sh './ci.sh Team-Gate-Test-T051-Functional' } }
		stage('Team-Gate-Test-T051-Performance'){ steps { sh './ci.sh Team-Gate-Test-T051-Performance' } }
		stage('Team-Gate-Test-T051-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T051-Security' } }
		stage('Team-Gate-Test-T051-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T051-Exit' } }

		stage('Team-Gate-T051-Exit') { steps { sh './ci.sh Team-Gate-T051-Exit' } }

		stage('Team-Gate-T051-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T051-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
