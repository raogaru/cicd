// ######################################################################
pipelineJob('DEMO-CI-22-team-gate-PLUTO') {
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
		v_gate = 'TEAM'
		v_team = 'PLUTO'
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-PLUTO-Start') 		{ steps { echo 'CI-PIPELINE-TEAM-GATE-PLUTO-START' } } 

		stage('Team-Gate-PLUTO-Git') 		{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-PLUTO',credentialsId:'raogaru',poll:'false')} 
		} }

		stage('Team-Gate-PLUTO-Enter') 		{ steps { sh './ci.sh Team-Gate-PLUTO-Enter' } }

		stage('Team-Gate-Build-PLUTO-Enter')	{ steps { sh './ci.sh Team-Gate-Build-PLUTO-Enter' } }
		stage('Team-Gate-Build-PLUTO-DB1') 	{ steps { sh './ci.sh Team-Gate-Build-PLUTO-DB1' } }
		stage('Team-Gate-Build-PLUTO-DB2') 	{ steps { sh './ci.sh Team-Gate-Build-PLUTO-DB2' } }
		stage('Team-Gate-Build-PLUTO-WWW') 	{ steps { sh './ci.sh Team-Gate-Build-PLUTO-WWW' } }
		stage('Team-Gate-Build-PLUTO-APP1') 	{ steps { sh './ci.sh Team-Gate-Build-PLUTO-APP1' } }
		stage('Team-Gate-Build-PLUTO-APP2') 	{ steps { sh './ci.sh Team-Gate-Build-PLUTO-APP2' } }
		stage('Team-Gate-Build-PLUTO-APP3') 	{ steps { sh './ci.sh Team-Gate-Build-PLUTO-APP3' } }
		stage('Team-Gate-Build-PLUTO-Exit') 	{ steps { sh './ci.sh Team-Gate-Build-PLUTO-' } }

		stage('Team-Gate-Deploy-PLUTO-Enter') 	{ steps { sh './ci.sh Team-Gate-Deploy-PLUTO-Enter' } }
		stage('Team-Gate-Deploy-PLUTO-DB1') 	{ steps { sh './ci.sh Team-Gate-Deploy-PLUTO-DB1' } }
		stage('Team-Gate-Deploy-PLUTO-DB2') 	{ steps { sh './ci.sh Team-Gate-Deploy-PLUTO-DB2' } }
		stage('Team-Gate-Deploy-PLUTO-WWW') 	{ steps { sh './ci.sh Team-Gate-Deploy-PLUTO-WWW' } }
		stage('Team-Gate-Deploy-PLUTO-APP1') 	{ steps { sh './ci.sh Team-Gate-Deploy-PLUTO-APP1' } }
		stage('Team-Gate-Deploy-PLUTO-APP2') 	{ steps { sh './ci.sh Team-Gate-Deploy-PLUTO-APP2' } }
		stage('Team-Gate-Deploy-PLUTO-APP3') 	{ steps { sh './ci.sh Team-Gate-Deploy-PLUTO-APP3' } }
		stage('Team-Gate-Deploy-PLUTO-Exit') 	{ steps { sh './ci.sh Team-Gate-Deploy-PLUTO-Exit' } }

		stage('Team-Gate-Test-PLUTO-Enter') 	{ steps { sh './ci.sh Team-Gate-Test-PLUTO-Enter' } }
		stage('Team-Gate-Test-PLUTO-Functional') { steps { sh './ci.sh Team-Gate-Test-PLUTO-Functional' } }
		stage('Team-Gate-Test-PLUTO-Performance'){ steps { sh './ci.sh Team-Gate-Test-PLUTO-Performance' } }
		stage('Team-Gate-Test-PLUTO-Security') 	{ steps { sh './ci.sh Team-Gate-Test-PLUTO-Security' } }
		stage('Team-Gate-Test-PLUTO-Exit') 	{ steps { sh './ci.sh Team-Gate-Test-PLUTO-Exit' } }

		stage('Team-Gate-PLUTO-Exit') { steps { sh './ci.sh Team-Gate-PLUTO-Exit' } }

		stage('Team-Gate-PLUTO-End') { steps { echo 'CI-PIPELINE-TEAM-GATE-PLUTO-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// #####################################################################:
