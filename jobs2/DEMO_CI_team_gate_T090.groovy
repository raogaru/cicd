// ######################################################################
pipelineJob('DEMO-CI-team-gate-T090') {
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
		vTEAM = 'T090'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T090-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T090-START' } } 

		stage('Team-Gate-T090-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T090',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T090-Enter') 		{ steps { sh './ci.sh Team-Gate-T090-Enter' } }

		stage('Team-Gate-Build-T090-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T090-Enter' } }
		stage('Team-Gate-Build-T090-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T090-DB1' } }
		stage('Team-Gate-Build-T090-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T090-DB2' } }
		stage('Team-Gate-Build-T090-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T090-WWW' } }
		stage('Team-Gate-Build-T090-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T090-APP1' } }
		stage('Team-Gate-Build-T090-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T090-APP2' } }
		stage('Team-Gate-Build-T090-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T090-APP3' } }
		stage('Team-Gate-Build-T090-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T090-' } }

		stage('Team-Gate-Deploy-T090-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T090-Enter' } }
		stage('Team-Gate-Deploy-T090-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T090-DB1' } }
		stage('Team-Gate-Deploy-T090-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T090-DB2' } }
		stage('Team-Gate-Deploy-T090-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T090-WWW' } }
		stage('Team-Gate-Deploy-T090-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T090-APP1' } }
		stage('Team-Gate-Deploy-T090-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T090-APP2' } }
		stage('Team-Gate-Deploy-T090-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T090-APP3' } }
		stage('Team-Gate-Deploy-T090-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T090-Exit' } }

		stage('Team-Gate-Test-T090-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T090-Enter' } }
		stage('Team-Gate-Test-T090-Functional') { steps { sh './ci.sh Team-Gate-Test-T090-Functional' } }
		stage('Team-Gate-Test-T090-Performance'){ steps { sh './ci.sh Team-Gate-Test-T090-Performance' } }
		stage('Team-Gate-Test-T090-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T090-Security' } }
		stage('Team-Gate-Test-T090-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T090-Exit' } }

		stage('Team-Gate-T090-Exit') { steps { sh './ci.sh Team-Gate-T090-Exit' } }

		stage('Team-Gate-T090-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T090-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
