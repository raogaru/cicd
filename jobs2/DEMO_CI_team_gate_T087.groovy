// ######################################################################
pipelineJob('DEMO-CI-team-gate-T087') {
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
		vTEAM = 'T087'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T087-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T087-START' } } 

		stage('Team-Gate-T087-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T087',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T087-Enter') 		{ steps { sh './ci.sh Team-Gate-T087-Enter' } }

		stage('Team-Gate-Build-T087-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T087-Enter' } }
		stage('Team-Gate-Build-T087-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T087-DB1' } }
		stage('Team-Gate-Build-T087-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T087-DB2' } }
		stage('Team-Gate-Build-T087-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T087-WWW' } }
		stage('Team-Gate-Build-T087-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T087-APP1' } }
		stage('Team-Gate-Build-T087-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T087-APP2' } }
		stage('Team-Gate-Build-T087-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T087-APP3' } }
		stage('Team-Gate-Build-T087-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T087-' } }

		stage('Team-Gate-Deploy-T087-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T087-Enter' } }
		stage('Team-Gate-Deploy-T087-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T087-DB1' } }
		stage('Team-Gate-Deploy-T087-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T087-DB2' } }
		stage('Team-Gate-Deploy-T087-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T087-WWW' } }
		stage('Team-Gate-Deploy-T087-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T087-APP1' } }
		stage('Team-Gate-Deploy-T087-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T087-APP2' } }
		stage('Team-Gate-Deploy-T087-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T087-APP3' } }
		stage('Team-Gate-Deploy-T087-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T087-Exit' } }

		stage('Team-Gate-Test-T087-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T087-Enter' } }
		stage('Team-Gate-Test-T087-Functional') { steps { sh './ci.sh Team-Gate-Test-T087-Functional' } }
		stage('Team-Gate-Test-T087-Performance'){ steps { sh './ci.sh Team-Gate-Test-T087-Performance' } }
		stage('Team-Gate-Test-T087-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T087-Security' } }
		stage('Team-Gate-Test-T087-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T087-Exit' } }

		stage('Team-Gate-T087-Exit') { steps { sh './ci.sh Team-Gate-T087-Exit' } }

		stage('Team-Gate-T087-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T087-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
