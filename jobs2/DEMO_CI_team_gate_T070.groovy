// ######################################################################
pipelineJob('DEMO-CI-team-gate-T070') {
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
		vTEAM = 'T070'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T070-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T070-START' } } 

		stage('Team-Gate-T070-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T070',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T070-Enter') 		{ steps { sh './ci.sh Team-Gate-T070-Enter' } }

		stage('Team-Gate-Build-T070-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T070-Enter' } }
		stage('Team-Gate-Build-T070-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T070-DB1' } }
		stage('Team-Gate-Build-T070-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T070-DB2' } }
		stage('Team-Gate-Build-T070-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T070-WWW' } }
		stage('Team-Gate-Build-T070-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T070-APP1' } }
		stage('Team-Gate-Build-T070-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T070-APP2' } }
		stage('Team-Gate-Build-T070-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T070-APP3' } }
		stage('Team-Gate-Build-T070-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T070-' } }

		stage('Team-Gate-Deploy-T070-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T070-Enter' } }
		stage('Team-Gate-Deploy-T070-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T070-DB1' } }
		stage('Team-Gate-Deploy-T070-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T070-DB2' } }
		stage('Team-Gate-Deploy-T070-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T070-WWW' } }
		stage('Team-Gate-Deploy-T070-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T070-APP1' } }
		stage('Team-Gate-Deploy-T070-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T070-APP2' } }
		stage('Team-Gate-Deploy-T070-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T070-APP3' } }
		stage('Team-Gate-Deploy-T070-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T070-Exit' } }

		stage('Team-Gate-Test-T070-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T070-Enter' } }
		stage('Team-Gate-Test-T070-Functional') { steps { sh './ci.sh Team-Gate-Test-T070-Functional' } }
		stage('Team-Gate-Test-T070-Performance'){ steps { sh './ci.sh Team-Gate-Test-T070-Performance' } }
		stage('Team-Gate-Test-T070-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T070-Security' } }
		stage('Team-Gate-Test-T070-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T070-Exit' } }

		stage('Team-Gate-T070-Exit') { steps { sh './ci.sh Team-Gate-T070-Exit' } }

		stage('Team-Gate-T070-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T070-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
