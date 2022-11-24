// ######################################################################
pipelineJob('DEMO-CI-Pipeline') {
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
		vPROCEED = 'YES'
	}

	stages {
		stage('Team-Gate-Start-VENUS') { steps { echo 'CI-PIPELINE-TEAM-GATE-VENUS-START' } } 

		stage('Team-Gate-Enter-VENUS') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-Build-Enter-VENUS') { steps { sh './ci.sh DUMMY' } }

		//stage('Team-Gate-Build-VENUS') { parallel {
		stage('Team-Gate-Build-DB-Docker-VENUS') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Build-Web-Docker-VENUS') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Build-App-Docker-VENUS') { steps { sh './ci.sh DUMMY' } }
		//} }

		stage('Team-Gate-Build-Exit-VENUS') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-Deploy-Enter-VENUS') { steps { sh './ci.sh DUMMY' } }

		//stage('Team-Gate-Deploy-VENUS') { parallel {
		stage('Team-Gate-Deploy-DB-Docker-VENUS') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Deploy-Web-Docker-VENUS') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Deploy-App-Docker-VENUS') { steps { sh './ci.sh DUMMY' } }
		//} }

		stage('Team-Gate-Deploy-Exit-VENUS') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-Test-Enter-VENUS') { steps { sh './ci.sh DUMMY' } }

		//stage('Team-Gate-Test-VENUS') { parallel {
		stage('Team-Gate-Test-Functional-VENUS') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Test-Performance-VENUS') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Test-Security-VENUS') { steps { sh './ci.sh DUMMY' } }
		//} }

		stage('Team-Gate-Test-Exit-VENUS') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-Exit-VENUS') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-End-VENUS') { steps { echo 'CI-PIPELINE-TEAM-GATE-VENUS-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
