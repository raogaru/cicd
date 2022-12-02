// ######################################################################
pipelineJob('DEMO-CI-team-gate-T077') {
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
		vTEAM = 'T077'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T077-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T077-START' } } 

		stage('Team-Gate-T077-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T077',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T077-Enter') 		{ steps { sh './ci.sh Team-Gate-T077-Enter' } }

		stage('Team-Gate-Build-T077-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T077-Enter' } }
		stage('Team-Gate-Build-T077-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T077-DB1' } }
		stage('Team-Gate-Build-T077-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T077-DB2' } }
		stage('Team-Gate-Build-T077-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T077-WWW' } }
		stage('Team-Gate-Build-T077-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T077-APP1' } }
		stage('Team-Gate-Build-T077-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T077-APP2' } }
		stage('Team-Gate-Build-T077-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T077-APP3' } }
		stage('Team-Gate-Build-T077-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T077-' } }

		stage('Team-Gate-Deploy-T077-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T077-Enter' } }
		stage('Team-Gate-Deploy-T077-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T077-DB1' } }
		stage('Team-Gate-Deploy-T077-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T077-DB2' } }
		stage('Team-Gate-Deploy-T077-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T077-WWW' } }
		stage('Team-Gate-Deploy-T077-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T077-APP1' } }
		stage('Team-Gate-Deploy-T077-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T077-APP2' } }
		stage('Team-Gate-Deploy-T077-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T077-APP3' } }
		stage('Team-Gate-Deploy-T077-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T077-Exit' } }

		stage('Team-Gate-Test-T077-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T077-Enter' } }
		stage('Team-Gate-Test-T077-Functional') { steps { sh './ci.sh Team-Gate-Test-T077-Functional' } }
		stage('Team-Gate-Test-T077-Performance'){ steps { sh './ci.sh Team-Gate-Test-T077-Performance' } }
		stage('Team-Gate-Test-T077-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T077-Security' } }
		stage('Team-Gate-Test-T077-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T077-Exit' } }

		stage('Team-Gate-T077-Exit') { steps { sh './ci.sh Team-Gate-T077-Exit' } }

		stage('Team-Gate-T077-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T077-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
