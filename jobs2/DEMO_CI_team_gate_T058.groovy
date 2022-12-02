// ######################################################################
pipelineJob('DEMO-CI-team-gate-T058') {
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
		vTEAM = 'T058'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-T058-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-T058-START' } } 

		stage('Team-Gate-T058-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-T058',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-T058-Enter') 		{ steps { sh './ci.sh Team-Gate-T058-Enter' } }

		stage('Team-Gate-Build-T058-Enter')	{ steps { sh './ci.sh Team-Gate-Build-T058-Enter' } }
		stage('Team-Gate-Build-T058-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-T058-DB1' } }
		stage('Team-Gate-Build-T058-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-T058-DB2' } }
		stage('Team-Gate-Build-T058-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-T058-WWW' } }
		stage('Team-Gate-Build-T058-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-T058-APP1' } }
		stage('Team-Gate-Build-T058-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-T058-APP2' } }
		stage('Team-Gate-Build-T058-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-T058-APP3' } }
		stage('Team-Gate-Build-T058-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-T058-' } }

		stage('Team-Gate-Deploy-T058-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-T058-Enter' } }
		stage('Team-Gate-Deploy-T058-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T058-DB1' } }
		stage('Team-Gate-Deploy-T058-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T058-DB2' } }
		stage('Team-Gate-Deploy-T058-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-T058-WWW' } }
		stage('Team-Gate-Deploy-T058-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-T058-APP1' } }
		stage('Team-Gate-Deploy-T058-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-T058-APP2' } }
		stage('Team-Gate-Deploy-T058-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-T058-APP3' } }
		stage('Team-Gate-Deploy-T058-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-T058-Exit' } }

		stage('Team-Gate-Test-T058-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-T058-Enter' } }
		stage('Team-Gate-Test-T058-Functional') { steps { sh './ci.sh Team-Gate-Test-T058-Functional' } }
		stage('Team-Gate-Test-T058-Performance'){ steps { sh './ci.sh Team-Gate-Test-T058-Performance' } }
		stage('Team-Gate-Test-T058-Security') 	{ steps { sh './ci.sh Team-Gate-Test-T058-Security' } }
		stage('Team-Gate-Test-T058-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-T058-Exit' } }

		stage('Team-Gate-T058-Exit') { steps { sh './ci.sh Team-Gate-T058-Exit' } }

		stage('Team-Gate-T058-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-T058-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
