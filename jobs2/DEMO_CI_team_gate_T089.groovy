// ######################################################################
pipelineJob('DEMO-CI-team-gate-T089') {
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
		vTEAM = 'T089'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T089-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T089-START' } } 

		stage('Team-Gate-T089-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T089',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T089-Enter') 		{ steps { sh './ci.sh Team-Gate-T089-Enter' } }

		stage('Team-Gate-Build-T089-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T089-Enter' } }
		stage('Team-Gate-Build-T089-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T089-DB1' } }
		stage('Team-Gate-Build-T089-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T089-DB2' } }
		stage('Team-Gate-Build-T089-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T089-WWW' } }
		stage('Team-Gate-Build-T089-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T089-APP1' } }
		stage('Team-Gate-Build-T089-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T089-APP2' } }
		stage('Team-Gate-Build-T089-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T089-APP3' } }
		stage('Team-Gate-Build-T089-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T089-' } }

		stage('Team-Gate-Deploy-T089-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T089-Enter' } }
		stage('Team-Gate-Deploy-T089-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T089-DB1' } }
		stage('Team-Gate-Deploy-T089-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T089-DB2' } }
		stage('Team-Gate-Deploy-T089-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T089-WWW' } }
		stage('Team-Gate-Deploy-T089-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T089-APP1' } }
		stage('Team-Gate-Deploy-T089-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T089-APP2' } }
		stage('Team-Gate-Deploy-T089-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T089-APP3' } }
		stage('Team-Gate-Deploy-T089-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T089-Exit' } }

		stage('Team-Gate-Test-T089-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T089-Enter' } }
		stage('Team-Gate-Test-T089-Functional') { steps { sh './ci.sh Team-Gate-Test-T089-Functional' } }
		stage('Team-Gate-Test-T089-Performance'){ steps { sh './ci.sh Team-Gate-Test-T089-Performance' } }
		stage('Team-Gate-Test-T089-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T089-Security' } }
		stage('Team-Gate-Test-T089-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T089-Exit' } }

		stage('Team-Gate-T089-Exit') { steps { sh './ci.sh Team-Gate-T089-Exit' } }

		stage('Team-Gate-T089-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T089-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
