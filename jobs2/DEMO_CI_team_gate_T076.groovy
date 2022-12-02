// ######################################################################
pipelineJob('DEMO-CI-team-gate-T076') {
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
		vTEAM = 'T076'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T076-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T076-START' } } 

		stage('Team-Gate-T076-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T076',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T076-Enter') 		{ steps { sh './ci.sh Team-Gate-T076-Enter' } }

		stage('Team-Gate-Build-T076-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T076-Enter' } }
		stage('Team-Gate-Build-T076-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T076-DB1' } }
		stage('Team-Gate-Build-T076-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T076-DB2' } }
		stage('Team-Gate-Build-T076-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T076-WWW' } }
		stage('Team-Gate-Build-T076-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T076-APP1' } }
		stage('Team-Gate-Build-T076-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T076-APP2' } }
		stage('Team-Gate-Build-T076-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T076-APP3' } }
		stage('Team-Gate-Build-T076-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T076-' } }

		stage('Team-Gate-Deploy-T076-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T076-Enter' } }
		stage('Team-Gate-Deploy-T076-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T076-DB1' } }
		stage('Team-Gate-Deploy-T076-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T076-DB2' } }
		stage('Team-Gate-Deploy-T076-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T076-WWW' } }
		stage('Team-Gate-Deploy-T076-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T076-APP1' } }
		stage('Team-Gate-Deploy-T076-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T076-APP2' } }
		stage('Team-Gate-Deploy-T076-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T076-APP3' } }
		stage('Team-Gate-Deploy-T076-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T076-Exit' } }

		stage('Team-Gate-Test-T076-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T076-Enter' } }
		stage('Team-Gate-Test-T076-Functional') { steps { sh './ci.sh Team-Gate-Test-T076-Functional' } }
		stage('Team-Gate-Test-T076-Performance'){ steps { sh './ci.sh Team-Gate-Test-T076-Performance' } }
		stage('Team-Gate-Test-T076-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T076-Security' } }
		stage('Team-Gate-Test-T076-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T076-Exit' } }

		stage('Team-Gate-T076-Exit') { steps { sh './ci.sh Team-Gate-T076-Exit' } }

		stage('Team-Gate-T076-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T076-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
