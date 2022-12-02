// ######################################################################
pipelineJob('DEMO-CI-team-gate-T049') {
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
		vTEAM = 'T049'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T049-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T049-START' } } 

		stage('Team-Gate-T049-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T049',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T049-Enter') 		{ steps { sh './ci.sh Team-Gate-T049-Enter' } }

		stage('Team-Gate-Build-T049-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T049-Enter' } }
		stage('Team-Gate-Build-T049-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T049-DB1' } }
		stage('Team-Gate-Build-T049-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T049-DB2' } }
		stage('Team-Gate-Build-T049-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T049-WWW' } }
		stage('Team-Gate-Build-T049-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T049-APP1' } }
		stage('Team-Gate-Build-T049-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T049-APP2' } }
		stage('Team-Gate-Build-T049-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T049-APP3' } }
		stage('Team-Gate-Build-T049-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T049-' } }

		stage('Team-Gate-Deploy-T049-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T049-Enter' } }
		stage('Team-Gate-Deploy-T049-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T049-DB1' } }
		stage('Team-Gate-Deploy-T049-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T049-DB2' } }
		stage('Team-Gate-Deploy-T049-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T049-WWW' } }
		stage('Team-Gate-Deploy-T049-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T049-APP1' } }
		stage('Team-Gate-Deploy-T049-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T049-APP2' } }
		stage('Team-Gate-Deploy-T049-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T049-APP3' } }
		stage('Team-Gate-Deploy-T049-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T049-Exit' } }

		stage('Team-Gate-Test-T049-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T049-Enter' } }
		stage('Team-Gate-Test-T049-Functional') { steps { sh './ci.sh Team-Gate-Test-T049-Functional' } }
		stage('Team-Gate-Test-T049-Performance'){ steps { sh './ci.sh Team-Gate-Test-T049-Performance' } }
		stage('Team-Gate-Test-T049-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T049-Security' } }
		stage('Team-Gate-Test-T049-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T049-Exit' } }

		stage('Team-Gate-T049-Exit') { steps { sh './ci.sh Team-Gate-T049-Exit' } }

		stage('Team-Gate-T049-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T049-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
