// ######################################################################
pipelineJob('DEMO-CI-team-gate-T078') {
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
		vTEAM = 'T078'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T078-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T078-START' } } 

		stage('Team-Gate-T078-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T078',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T078-Enter') 		{ steps { sh './ci.sh Team-Gate-T078-Enter' } }

		stage('Team-Gate-Build-T078-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T078-Enter' } }
		stage('Team-Gate-Build-T078-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T078-DB1' } }
		stage('Team-Gate-Build-T078-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T078-DB2' } }
		stage('Team-Gate-Build-T078-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T078-WWW' } }
		stage('Team-Gate-Build-T078-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T078-APP1' } }
		stage('Team-Gate-Build-T078-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T078-APP2' } }
		stage('Team-Gate-Build-T078-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T078-APP3' } }
		stage('Team-Gate-Build-T078-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T078-' } }

		stage('Team-Gate-Deploy-T078-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T078-Enter' } }
		stage('Team-Gate-Deploy-T078-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T078-DB1' } }
		stage('Team-Gate-Deploy-T078-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T078-DB2' } }
		stage('Team-Gate-Deploy-T078-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T078-WWW' } }
		stage('Team-Gate-Deploy-T078-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T078-APP1' } }
		stage('Team-Gate-Deploy-T078-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T078-APP2' } }
		stage('Team-Gate-Deploy-T078-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T078-APP3' } }
		stage('Team-Gate-Deploy-T078-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T078-Exit' } }

		stage('Team-Gate-Test-T078-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T078-Enter' } }
		stage('Team-Gate-Test-T078-Functional') { steps { sh './ci.sh Team-Gate-Test-T078-Functional' } }
		stage('Team-Gate-Test-T078-Performance'){ steps { sh './ci.sh Team-Gate-Test-T078-Performance' } }
		stage('Team-Gate-Test-T078-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T078-Security' } }
		stage('Team-Gate-Test-T078-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T078-Exit' } }

		stage('Team-Gate-T078-Exit') { steps { sh './ci.sh Team-Gate-T078-Exit' } }

		stage('Team-Gate-T078-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T078-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
