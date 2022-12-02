// ######################################################################
pipelineJob('DEMO-CI-team-gate-T001') {
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
		vTEAM = 'T001'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T001-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T001-START' } } 

		stage('Team-Gate-T001-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T001',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T001-Enter') 		{ steps { sh './ci.sh Team-Gate-T001-Enter' } }

		stage('Team-Gate-Build-T001-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T001-Enter' } }
		stage('Team-Gate-Build-T001-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T001-DB1' } }
		stage('Team-Gate-Build-T001-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T001-DB2' } }
		stage('Team-Gate-Build-T001-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T001-WWW' } }
		stage('Team-Gate-Build-T001-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T001-APP1' } }
		stage('Team-Gate-Build-T001-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T001-APP2' } }
		stage('Team-Gate-Build-T001-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T001-APP3' } }
		stage('Team-Gate-Build-T001-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T001-' } }

		stage('Team-Gate-Deploy-T001-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T001-Enter' } }
		stage('Team-Gate-Deploy-T001-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T001-DB1' } }
		stage('Team-Gate-Deploy-T001-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T001-DB2' } }
		stage('Team-Gate-Deploy-T001-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T001-WWW' } }
		stage('Team-Gate-Deploy-T001-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T001-APP1' } }
		stage('Team-Gate-Deploy-T001-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T001-APP2' } }
		stage('Team-Gate-Deploy-T001-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T001-APP3' } }
		stage('Team-Gate-Deploy-T001-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T001-Exit' } }

		stage('Team-Gate-Test-T001-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T001-Enter' } }
		stage('Team-Gate-Test-T001-Functional') { steps { sh './ci.sh Team-Gate-Test-T001-Functional' } }
		stage('Team-Gate-Test-T001-Performance'){ steps { sh './ci.sh Team-Gate-Test-T001-Performance' } }
		stage('Team-Gate-Test-T001-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T001-Security' } }
		stage('Team-Gate-Test-T001-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T001-Exit' } }

		stage('Team-Gate-T001-Exit') { steps { sh './ci.sh Team-Gate-T001-Exit' } }

		stage('Team-Gate-T001-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T001-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
