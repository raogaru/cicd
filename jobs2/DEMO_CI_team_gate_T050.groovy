// ######################################################################
pipelineJob('DEMO-CI-team-gate-T050') {
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
		vTEAM = 'T050'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T050-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T050-START' } } 

		stage('Team-Gate-T050-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T050',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T050-Enter') 		{ steps { sh './ci.sh Team-Gate-T050-Enter' } }

		stage('Team-Gate-Build-T050-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T050-Enter' } }
		stage('Team-Gate-Build-T050-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T050-DB1' } }
		stage('Team-Gate-Build-T050-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T050-DB2' } }
		stage('Team-Gate-Build-T050-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T050-WWW' } }
		stage('Team-Gate-Build-T050-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T050-APP1' } }
		stage('Team-Gate-Build-T050-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T050-APP2' } }
		stage('Team-Gate-Build-T050-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T050-APP3' } }
		stage('Team-Gate-Build-T050-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T050-' } }

		stage('Team-Gate-Deploy-T050-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T050-Enter' } }
		stage('Team-Gate-Deploy-T050-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T050-DB1' } }
		stage('Team-Gate-Deploy-T050-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T050-DB2' } }
		stage('Team-Gate-Deploy-T050-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T050-WWW' } }
		stage('Team-Gate-Deploy-T050-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T050-APP1' } }
		stage('Team-Gate-Deploy-T050-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T050-APP2' } }
		stage('Team-Gate-Deploy-T050-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T050-APP3' } }
		stage('Team-Gate-Deploy-T050-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T050-Exit' } }

		stage('Team-Gate-Test-T050-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T050-Enter' } }
		stage('Team-Gate-Test-T050-Functional') { steps { sh './ci.sh Team-Gate-Test-T050-Functional' } }
		stage('Team-Gate-Test-T050-Performance'){ steps { sh './ci.sh Team-Gate-Test-T050-Performance' } }
		stage('Team-Gate-Test-T050-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T050-Security' } }
		stage('Team-Gate-Test-T050-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T050-Exit' } }

		stage('Team-Gate-T050-Exit') { steps { sh './ci.sh Team-Gate-T050-Exit' } }

		stage('Team-Gate-T050-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T050-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
