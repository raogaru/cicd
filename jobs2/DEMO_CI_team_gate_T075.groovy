// ######################################################################
pipelineJob('DEMO-CI-team-gate-T075') {
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
		vTEAM = 'T075'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T075-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T075-START' } } 

		stage('Team-Gate-T075-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T075',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T075-Enter') 		{ steps { sh './ci.sh Team-Gate-T075-Enter' } }

		stage('Team-Gate-Build-T075-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T075-Enter' } }
		stage('Team-Gate-Build-T075-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T075-DB1' } }
		stage('Team-Gate-Build-T075-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T075-DB2' } }
		stage('Team-Gate-Build-T075-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T075-WWW' } }
		stage('Team-Gate-Build-T075-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T075-APP1' } }
		stage('Team-Gate-Build-T075-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T075-APP2' } }
		stage('Team-Gate-Build-T075-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T075-APP3' } }
		stage('Team-Gate-Build-T075-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T075-' } }

		stage('Team-Gate-Deploy-T075-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T075-Enter' } }
		stage('Team-Gate-Deploy-T075-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T075-DB1' } }
		stage('Team-Gate-Deploy-T075-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T075-DB2' } }
		stage('Team-Gate-Deploy-T075-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T075-WWW' } }
		stage('Team-Gate-Deploy-T075-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T075-APP1' } }
		stage('Team-Gate-Deploy-T075-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T075-APP2' } }
		stage('Team-Gate-Deploy-T075-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T075-APP3' } }
		stage('Team-Gate-Deploy-T075-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T075-Exit' } }

		stage('Team-Gate-Test-T075-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T075-Enter' } }
		stage('Team-Gate-Test-T075-Functional') { steps { sh './ci.sh Team-Gate-Test-T075-Functional' } }
		stage('Team-Gate-Test-T075-Performance'){ steps { sh './ci.sh Team-Gate-Test-T075-Performance' } }
		stage('Team-Gate-Test-T075-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T075-Security' } }
		stage('Team-Gate-Test-T075-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T075-Exit' } }

		stage('Team-Gate-T075-Exit') { steps { sh './ci.sh Team-Gate-T075-Exit' } }

		stage('Team-Gate-T075-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T075-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
