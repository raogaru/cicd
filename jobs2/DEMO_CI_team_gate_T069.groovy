// ######################################################################
pipelineJob('DEMO-CI-team-gate-T069') {
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
		vTEAM = 'T069'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T069-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T069-START' } } 

		stage('Team-Gate-T069-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T069',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T069-Enter') 		{ steps { sh './ci.sh Team-Gate-T069-Enter' } }

		stage('Team-Gate-Build-T069-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T069-Enter' } }
		stage('Team-Gate-Build-T069-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T069-DB1' } }
		stage('Team-Gate-Build-T069-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T069-DB2' } }
		stage('Team-Gate-Build-T069-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T069-WWW' } }
		stage('Team-Gate-Build-T069-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T069-APP1' } }
		stage('Team-Gate-Build-T069-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T069-APP2' } }
		stage('Team-Gate-Build-T069-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T069-APP3' } }
		stage('Team-Gate-Build-T069-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T069-' } }

		stage('Team-Gate-Deploy-T069-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T069-Enter' } }
		stage('Team-Gate-Deploy-T069-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T069-DB1' } }
		stage('Team-Gate-Deploy-T069-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T069-DB2' } }
		stage('Team-Gate-Deploy-T069-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T069-WWW' } }
		stage('Team-Gate-Deploy-T069-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T069-APP1' } }
		stage('Team-Gate-Deploy-T069-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T069-APP2' } }
		stage('Team-Gate-Deploy-T069-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T069-APP3' } }
		stage('Team-Gate-Deploy-T069-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T069-Exit' } }

		stage('Team-Gate-Test-T069-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T069-Enter' } }
		stage('Team-Gate-Test-T069-Functional') { steps { sh './ci.sh Team-Gate-Test-T069-Functional' } }
		stage('Team-Gate-Test-T069-Performance'){ steps { sh './ci.sh Team-Gate-Test-T069-Performance' } }
		stage('Team-Gate-Test-T069-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T069-Security' } }
		stage('Team-Gate-Test-T069-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T069-Exit' } }

		stage('Team-Gate-T069-Exit') { steps { sh './ci.sh Team-Gate-T069-Exit' } }

		stage('Team-Gate-T069-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T069-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
