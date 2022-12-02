// ######################################################################
pipelineJob('DEMO-CI-team-gate-T073') {
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
		vTEAM = 'T073'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T073-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T073-START' } } 

		stage('Team-Gate-T073-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T073',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T073-Enter') 		{ steps { sh './ci.sh Team-Gate-T073-Enter' } }

		stage('Team-Gate-Build-T073-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T073-Enter' } }
		stage('Team-Gate-Build-T073-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T073-DB1' } }
		stage('Team-Gate-Build-T073-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T073-DB2' } }
		stage('Team-Gate-Build-T073-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T073-WWW' } }
		stage('Team-Gate-Build-T073-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T073-APP1' } }
		stage('Team-Gate-Build-T073-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T073-APP2' } }
		stage('Team-Gate-Build-T073-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T073-APP3' } }
		stage('Team-Gate-Build-T073-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T073-' } }

		stage('Team-Gate-Deploy-T073-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T073-Enter' } }
		stage('Team-Gate-Deploy-T073-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T073-DB1' } }
		stage('Team-Gate-Deploy-T073-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T073-DB2' } }
		stage('Team-Gate-Deploy-T073-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T073-WWW' } }
		stage('Team-Gate-Deploy-T073-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T073-APP1' } }
		stage('Team-Gate-Deploy-T073-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T073-APP2' } }
		stage('Team-Gate-Deploy-T073-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T073-APP3' } }
		stage('Team-Gate-Deploy-T073-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T073-Exit' } }

		stage('Team-Gate-Test-T073-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T073-Enter' } }
		stage('Team-Gate-Test-T073-Functional') { steps { sh './ci.sh Team-Gate-Test-T073-Functional' } }
		stage('Team-Gate-Test-T073-Performance'){ steps { sh './ci.sh Team-Gate-Test-T073-Performance' } }
		stage('Team-Gate-Test-T073-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T073-Security' } }
		stage('Team-Gate-Test-T073-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T073-Exit' } }

		stage('Team-Gate-T073-Exit') { steps { sh './ci.sh Team-Gate-T073-Exit' } }

		stage('Team-Gate-T073-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T073-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
