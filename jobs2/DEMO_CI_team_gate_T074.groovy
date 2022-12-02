// ######################################################################
pipelineJob('DEMO-CI-team-gate-T074') {
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
		vTEAM = 'T074'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T074-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T074-START' } } 

		stage('Team-Gate-T074-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T074',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T074-Enter') 		{ steps { sh './ci.sh Team-Gate-T074-Enter' } }

		stage('Team-Gate-Build-T074-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T074-Enter' } }
		stage('Team-Gate-Build-T074-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T074-DB1' } }
		stage('Team-Gate-Build-T074-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T074-DB2' } }
		stage('Team-Gate-Build-T074-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T074-WWW' } }
		stage('Team-Gate-Build-T074-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T074-APP1' } }
		stage('Team-Gate-Build-T074-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T074-APP2' } }
		stage('Team-Gate-Build-T074-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T074-APP3' } }
		stage('Team-Gate-Build-T074-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T074-' } }

		stage('Team-Gate-Deploy-T074-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T074-Enter' } }
		stage('Team-Gate-Deploy-T074-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T074-DB1' } }
		stage('Team-Gate-Deploy-T074-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T074-DB2' } }
		stage('Team-Gate-Deploy-T074-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T074-WWW' } }
		stage('Team-Gate-Deploy-T074-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T074-APP1' } }
		stage('Team-Gate-Deploy-T074-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T074-APP2' } }
		stage('Team-Gate-Deploy-T074-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T074-APP3' } }
		stage('Team-Gate-Deploy-T074-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T074-Exit' } }

		stage('Team-Gate-Test-T074-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T074-Enter' } }
		stage('Team-Gate-Test-T074-Functional') { steps { sh './ci.sh Team-Gate-Test-T074-Functional' } }
		stage('Team-Gate-Test-T074-Performance'){ steps { sh './ci.sh Team-Gate-Test-T074-Performance' } }
		stage('Team-Gate-Test-T074-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T074-Security' } }
		stage('Team-Gate-Test-T074-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T074-Exit' } }

		stage('Team-Gate-T074-Exit') { steps { sh './ci.sh Team-Gate-T074-Exit' } }

		stage('Team-Gate-T074-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T074-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
