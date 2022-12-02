// ######################################################################
pipelineJob('DEMO-CI-team-gate-T021') {
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
		vTEAM = 'T021'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T021-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T021-START' } } 

		stage('Team-Gate-T021-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T021',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T021-Enter') 		{ steps { sh './ci.sh Team-Gate-T021-Enter' } }

		stage('Team-Gate-Build-T021-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T021-Enter' } }
		stage('Team-Gate-Build-T021-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T021-DB1' } }
		stage('Team-Gate-Build-T021-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T021-DB2' } }
		stage('Team-Gate-Build-T021-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T021-WWW' } }
		stage('Team-Gate-Build-T021-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T021-APP1' } }
		stage('Team-Gate-Build-T021-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T021-APP2' } }
		stage('Team-Gate-Build-T021-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T021-APP3' } }
		stage('Team-Gate-Build-T021-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T021-' } }

		stage('Team-Gate-Deploy-T021-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T021-Enter' } }
		stage('Team-Gate-Deploy-T021-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T021-DB1' } }
		stage('Team-Gate-Deploy-T021-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T021-DB2' } }
		stage('Team-Gate-Deploy-T021-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T021-WWW' } }
		stage('Team-Gate-Deploy-T021-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T021-APP1' } }
		stage('Team-Gate-Deploy-T021-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T021-APP2' } }
		stage('Team-Gate-Deploy-T021-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T021-APP3' } }
		stage('Team-Gate-Deploy-T021-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T021-Exit' } }

		stage('Team-Gate-Test-T021-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T021-Enter' } }
		stage('Team-Gate-Test-T021-Functional') { steps { sh './ci.sh Team-Gate-Test-T021-Functional' } }
		stage('Team-Gate-Test-T021-Performance'){ steps { sh './ci.sh Team-Gate-Test-T021-Performance' } }
		stage('Team-Gate-Test-T021-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T021-Security' } }
		stage('Team-Gate-Test-T021-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T021-Exit' } }

		stage('Team-Gate-T021-Exit') { steps { sh './ci.sh Team-Gate-T021-Exit' } }

		stage('Team-Gate-T021-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T021-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
