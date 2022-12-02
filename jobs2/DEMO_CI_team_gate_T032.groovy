// ######################################################################
pipelineJob('DEMO-CI-team-gate-T032') {
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
		vTEAM = 'T032'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T032-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T032-START' } } 

		stage('Team-Gate-T032-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T032',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T032-Enter') 		{ steps { sh './ci.sh Team-Gate-T032-Enter' } }

		stage('Team-Gate-Build-T032-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T032-Enter' } }
		stage('Team-Gate-Build-T032-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T032-DB1' } }
		stage('Team-Gate-Build-T032-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T032-DB2' } }
		stage('Team-Gate-Build-T032-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T032-WWW' } }
		stage('Team-Gate-Build-T032-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T032-APP1' } }
		stage('Team-Gate-Build-T032-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T032-APP2' } }
		stage('Team-Gate-Build-T032-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T032-APP3' } }
		stage('Team-Gate-Build-T032-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T032-' } }

		stage('Team-Gate-Deploy-T032-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T032-Enter' } }
		stage('Team-Gate-Deploy-T032-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T032-DB1' } }
		stage('Team-Gate-Deploy-T032-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T032-DB2' } }
		stage('Team-Gate-Deploy-T032-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T032-WWW' } }
		stage('Team-Gate-Deploy-T032-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T032-APP1' } }
		stage('Team-Gate-Deploy-T032-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T032-APP2' } }
		stage('Team-Gate-Deploy-T032-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T032-APP3' } }
		stage('Team-Gate-Deploy-T032-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T032-Exit' } }

		stage('Team-Gate-Test-T032-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T032-Enter' } }
		stage('Team-Gate-Test-T032-Functional') { steps { sh './ci.sh Team-Gate-Test-T032-Functional' } }
		stage('Team-Gate-Test-T032-Performance'){ steps { sh './ci.sh Team-Gate-Test-T032-Performance' } }
		stage('Team-Gate-Test-T032-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T032-Security' } }
		stage('Team-Gate-Test-T032-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T032-Exit' } }

		stage('Team-Gate-T032-Exit') { steps { sh './ci.sh Team-Gate-T032-Exit' } }

		stage('Team-Gate-T032-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T032-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
