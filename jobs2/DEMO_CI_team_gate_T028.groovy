// ######################################################################
pipelineJob('DEMO-CI-team-gate-T028') {
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
		vTEAM = 'T028'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T028-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T028-START' } } 

		stage('Team-Gate-T028-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T028',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T028-Enter') 		{ steps { sh './ci.sh Team-Gate-T028-Enter' } }

		stage('Team-Gate-Build-T028-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T028-Enter' } }
		stage('Team-Gate-Build-T028-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T028-DB1' } }
		stage('Team-Gate-Build-T028-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T028-DB2' } }
		stage('Team-Gate-Build-T028-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T028-WWW' } }
		stage('Team-Gate-Build-T028-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T028-APP1' } }
		stage('Team-Gate-Build-T028-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T028-APP2' } }
		stage('Team-Gate-Build-T028-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T028-APP3' } }
		stage('Team-Gate-Build-T028-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T028-' } }

		stage('Team-Gate-Deploy-T028-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T028-Enter' } }
		stage('Team-Gate-Deploy-T028-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T028-DB1' } }
		stage('Team-Gate-Deploy-T028-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T028-DB2' } }
		stage('Team-Gate-Deploy-T028-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T028-WWW' } }
		stage('Team-Gate-Deploy-T028-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T028-APP1' } }
		stage('Team-Gate-Deploy-T028-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T028-APP2' } }
		stage('Team-Gate-Deploy-T028-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T028-APP3' } }
		stage('Team-Gate-Deploy-T028-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T028-Exit' } }

		stage('Team-Gate-Test-T028-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T028-Enter' } }
		stage('Team-Gate-Test-T028-Functional') { steps { sh './ci.sh Team-Gate-Test-T028-Functional' } }
		stage('Team-Gate-Test-T028-Performance'){ steps { sh './ci.sh Team-Gate-Test-T028-Performance' } }
		stage('Team-Gate-Test-T028-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T028-Security' } }
		stage('Team-Gate-Test-T028-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T028-Exit' } }

		stage('Team-Gate-T028-Exit') { steps { sh './ci.sh Team-Gate-T028-Exit' } }

		stage('Team-Gate-T028-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T028-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
