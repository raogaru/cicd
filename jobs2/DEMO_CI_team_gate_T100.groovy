// ######################################################################
pipelineJob('DEMO-CI-team-gate-T100') {
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
		vTEAM = 'T100'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T100-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T100-START' } } 

		stage('Team-Gate-T100-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T100',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T100-Enter') 		{ steps { sh './ci.sh Team-Gate-T100-Enter' } }

		stage('Team-Gate-Build-T100-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T100-Enter' } }
		stage('Team-Gate-Build-T100-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T100-DB1' } }
		stage('Team-Gate-Build-T100-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T100-DB2' } }
		stage('Team-Gate-Build-T100-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T100-WWW' } }
		stage('Team-Gate-Build-T100-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T100-APP1' } }
		stage('Team-Gate-Build-T100-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T100-APP2' } }
		stage('Team-Gate-Build-T100-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T100-APP3' } }
		stage('Team-Gate-Build-T100-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T100-' } }

		stage('Team-Gate-Deploy-T100-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T100-Enter' } }
		stage('Team-Gate-Deploy-T100-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T100-DB1' } }
		stage('Team-Gate-Deploy-T100-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T100-DB2' } }
		stage('Team-Gate-Deploy-T100-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T100-WWW' } }
		stage('Team-Gate-Deploy-T100-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T100-APP1' } }
		stage('Team-Gate-Deploy-T100-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T100-APP2' } }
		stage('Team-Gate-Deploy-T100-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T100-APP3' } }
		stage('Team-Gate-Deploy-T100-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T100-Exit' } }

		stage('Team-Gate-Test-T100-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T100-Enter' } }
		stage('Team-Gate-Test-T100-Functional') { steps { sh './ci.sh Team-Gate-Test-T100-Functional' } }
		stage('Team-Gate-Test-T100-Performance'){ steps { sh './ci.sh Team-Gate-Test-T100-Performance' } }
		stage('Team-Gate-Test-T100-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T100-Security' } }
		stage('Team-Gate-Test-T100-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T100-Exit' } }

		stage('Team-Gate-T100-Exit') { steps { sh './ci.sh Team-Gate-T100-Exit' } }

		stage('Team-Gate-T100-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T100-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
