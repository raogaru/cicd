// ######################################################################
pipelineJob('DEMO-CI-team-gate-T027') {
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
		vTEAM = 'T027'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T027-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T027-START' } } 

		stage('Team-Gate-T027-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T027',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T027-Enter') 		{ steps { sh './ci.sh Team-Gate-T027-Enter' } }

		stage('Team-Gate-Build-T027-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T027-Enter' } }
		stage('Team-Gate-Build-T027-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T027-DB1' } }
		stage('Team-Gate-Build-T027-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T027-DB2' } }
		stage('Team-Gate-Build-T027-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T027-WWW' } }
		stage('Team-Gate-Build-T027-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T027-APP1' } }
		stage('Team-Gate-Build-T027-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T027-APP2' } }
		stage('Team-Gate-Build-T027-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T027-APP3' } }
		stage('Team-Gate-Build-T027-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T027-' } }

		stage('Team-Gate-Deploy-T027-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T027-Enter' } }
		stage('Team-Gate-Deploy-T027-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T027-DB1' } }
		stage('Team-Gate-Deploy-T027-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T027-DB2' } }
		stage('Team-Gate-Deploy-T027-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T027-WWW' } }
		stage('Team-Gate-Deploy-T027-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T027-APP1' } }
		stage('Team-Gate-Deploy-T027-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T027-APP2' } }
		stage('Team-Gate-Deploy-T027-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T027-APP3' } }
		stage('Team-Gate-Deploy-T027-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T027-Exit' } }

		stage('Team-Gate-Test-T027-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T027-Enter' } }
		stage('Team-Gate-Test-T027-Functional') { steps { sh './ci.sh Team-Gate-Test-T027-Functional' } }
		stage('Team-Gate-Test-T027-Performance'){ steps { sh './ci.sh Team-Gate-Test-T027-Performance' } }
		stage('Team-Gate-Test-T027-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T027-Security' } }
		stage('Team-Gate-Test-T027-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T027-Exit' } }

		stage('Team-Gate-T027-Exit') { steps { sh './ci.sh Team-Gate-T027-Exit' } }

		stage('Team-Gate-T027-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T027-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
