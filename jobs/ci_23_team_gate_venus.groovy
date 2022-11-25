// ######################################################################
pipelineJob('DEMO-CI-23-team-gate-VENUS') {
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
		ws('/tmp/cicd')
	}
	environment {
		vGATE = 'TEAM'
		vTEAM = 'VENUS'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-VENUS-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-VENUS-START' } } 

		stage('Team-Gate-VENUS-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'master',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-VENUS-Enter') 		{ steps { sh './ci.sh Team-Gate-VENUS-Enter' } }

		stage('Team-Gate-Build-VENUS-Enter')	{ steps { sh './ci.sh Team-Gate-Build-VENUS-Enter' } }
		stage('Team-Gate-Build-VENUS-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-VENUS-DB1' } }
		stage('Team-Gate-Build-VENUS-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-VENUS-DB2' } }
		stage('Team-Gate-Build-VENUS-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-VENUS-WWW' } }
		stage('Team-Gate-Build-VENUS-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-VENUS-APP1' } }
		stage('Team-Gate-Build-VENUS-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-VENUS-APP2' } }
		stage('Team-Gate-Build-VENUS-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-VENUS-APP3' } }
		stage('Team-Gate-Build-VENUS-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-VENUS-' } }

		stage('Team-Gate-Deploy-VENUS-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-VENUS-Enter' } }
		stage('Team-Gate-Deploy-VENUS-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-VENUS-DB1' } }
		stage('Team-Gate-Deploy-VENUS-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-VENUS-DB2' } }
		stage('Team-Gate-Deploy-VENUS-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-VENUS-WWW' } }
		stage('Team-Gate-Deploy-VENUS-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-VENUS-APP1' } }
		stage('Team-Gate-Deploy-VENUS-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-VENUS-APP2' } }
		stage('Team-Gate-Deploy-VENUS-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-VENUS-APP3' } }
		stage('Team-Gate-Deploy-VENUS-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-VENUS-Exit' } }

		stage('Team-Gate-Test-VENUS-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-VENUS-Enter' } }
		stage('Team-Gate-Test-VENUS-Functional') { steps { sh './ci.sh Team-Gate-Test-VENUS-Functional' } }
		stage('Team-Gate-Test-VENUS-Performance'){ steps { sh './ci.sh Team-Gate-Test-VENUS-Performance' } }
		stage('Team-Gate-Test-VENUS-Security') 	{ steps { sh './ci.sh Team-Gate-Test-VENUS-Security' } }
		stage('Team-Gate-Test-VENUS-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-VENUS-Exit' } }

		stage('Team-Gate-VENUS-Exit') { steps { sh './ci.sh Team-Gate-VENUS-Exit' } }

		stage('Team-Gate-VENUS-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-VENUS' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
