// ######################################################################
pipelineJob('DEMO-CI-team-gate-T098') {
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
		vTEAM = 'T098'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T098-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T098-START' } } 

		stage('Team-Gate-T098-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T098',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T098-Enter') 		{ steps { sh './ci.sh Team-Gate-T098-Enter' } }

		stage('Team-Gate-Build-T098-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T098-Enter' } }
		stage('Team-Gate-Build-T098-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T098-DB1' } }
		stage('Team-Gate-Build-T098-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T098-DB2' } }
		stage('Team-Gate-Build-T098-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T098-WWW' } }
		stage('Team-Gate-Build-T098-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T098-APP1' } }
		stage('Team-Gate-Build-T098-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T098-APP2' } }
		stage('Team-Gate-Build-T098-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T098-APP3' } }
		stage('Team-Gate-Build-T098-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T098-' } }

		stage('Team-Gate-Deploy-T098-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T098-Enter' } }
		stage('Team-Gate-Deploy-T098-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T098-DB1' } }
		stage('Team-Gate-Deploy-T098-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T098-DB2' } }
		stage('Team-Gate-Deploy-T098-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T098-WWW' } }
		stage('Team-Gate-Deploy-T098-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T098-APP1' } }
		stage('Team-Gate-Deploy-T098-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T098-APP2' } }
		stage('Team-Gate-Deploy-T098-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T098-APP3' } }
		stage('Team-Gate-Deploy-T098-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T098-Exit' } }

		stage('Team-Gate-Test-T098-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T098-Enter' } }
		stage('Team-Gate-Test-T098-Functional') { steps { sh './ci.sh Team-Gate-Test-T098-Functional' } }
		stage('Team-Gate-Test-T098-Performance'){ steps { sh './ci.sh Team-Gate-Test-T098-Performance' } }
		stage('Team-Gate-Test-T098-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T098-Security' } }
		stage('Team-Gate-Test-T098-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T098-Exit' } }

		stage('Team-Gate-T098-Exit') { steps { sh './ci.sh Team-Gate-T098-Exit' } }

		stage('Team-Gate-T098-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T098-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
