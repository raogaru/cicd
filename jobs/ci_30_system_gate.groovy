// ######################################################################
pipelineJob('DEMO-CI-30-system-gate') {
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
		vGATE = 'SYSTEM'
		vSTAGE = ''
		vTEAM = ''
		vPROCEED = 'YES'
	}

	stages {
		stage('System-Gate-Start') { steps { echo 'CI-PIPELINE-SYSTEM-GATE-START' } } 

		stage('System-Gate-Git') { steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-MARS',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('System-Gate-Enter') 		{ steps { sh './ci.sh System-Gate-Enter' } }

		stage('System-Gate-Build-Enter') 	{ steps { sh './ci.sh System-Gate-Build-Enter' } }
		stage('System-Gate-Build-DB1') 		{ steps { sh './ci.sh System-Gate-Build-DB1' } }
		stage('System-Gate-Build-DB2') 		{ steps { sh './ci.sh System-Gate-Build-DB2' } }
		stage('System-Gate-Build-WWW') 		{ steps { sh './ci.sh System-Gate-Build-WWW' } }
		stage('System-Gate-Build-APP1') 	{ steps { sh './ci.sh System-Gate-Build-APP1' } }
		stage('System-Gate-Build-APP2') 	{ steps { sh './ci.sh System-Gate-Build-APP2' } }
		stage('System-Gate-Build-APP3') 	{ steps { sh './ci.sh System-Gate-Build-APP3' } }
		stage('System-Gate-Build-Exit') 	{ steps { sh './ci.sh System-Gate-Build-Exit' } }

		stage('System-Gate-Deploy-Enter') 	{ steps { sh './ci.sh System-Gate-Deploy-Enter' } }
		stage('System-Gate-Deploy-DB1') 	{ steps { sh './ci.sh System-Gate-Deploy-DB1' } }
		stage('System-Gate-Deploy-DB2') 	{ steps { sh './ci.sh System-Gate-Deploy-DB2' } }
		stage('System-Gate-Deploy-WWW') 	{ steps { sh './ci.sh System-Gate-Deploy-WWW' } }
		stage('System-Gate-Deploy-APP1') 	{ steps { sh './ci.sh System-Gate-Deploy-APP1' } }
		stage('System-Gate-Deploy-APP2') 	{ steps { sh './ci.sh System-Gate-Deploy-APP2' } }
		stage('System-Gate-Deploy-APP3') 	{ steps { sh './ci.sh System-Gate-Deploy-APP3' } }
		stage('System-Gate-Deploy-Exit') 	{ steps { sh './ci.sh System-Gate-Deploy-Exit' } }

		stage('System-Gate-Test-Enter') 	{ steps { sh './ci.sh System-Gate-Test-Enter' } }
		stage('System-Gate-Test-Functional') 	{ steps { sh './ci.sh System-Gate-Test-Functional' } }
		stage('System-Gate-Test-Performance')	{ steps { sh './ci.sh System-Gate-Test-Performance' } }
		stage('System-Gate-Test-Security') 	{ steps { sh './ci.sh System-Gate-Test-Security' } }
		stage('System-Gate-Test-Exit') 		{ steps { sh './ci.sh System-Gate-Test-Exit' } }

		stage('System-Gate-Exit') { steps { sh './ci.sh System-Gate-Exit' } }

		stage('System-Gate-End') { steps { echo 'CI-PIPELINE-SYSTEM-GATE-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
