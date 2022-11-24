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
		stage('Team-Gate-Start-PLUTO') { steps { echo 'CI-PIPELINE-TEAM-GATE-PLUTO-START' } } 

		stage('Team-Gate-Enter-PLUTO') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-Build-Enter-PLUTO') { steps { sh './ci.sh DUMMY' } }

		//stage('Team-Gate-Build-PLUTO') { parallel {
		stage('Team-Gate-Build-DB-Docker-PLUTO') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Build-Web-Docker-PLUTO') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Build-App-Docker-PLUTO') { steps { sh './ci.sh DUMMY' } }
		//} }

		stage('Team-Gate-Build-Exit-PLUTO') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-Deploy-Enter-PLUTO') { steps { sh './ci.sh DUMMY' } }

		//stage('Team-Gate-Deploy-PLUTO') { parallel {
		stage('Team-Gate-Deploy-DB-Docker-PLUTO') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Deploy-Web-Docker-PLUTO') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Deploy-App-Docker-PLUTO') { steps { sh './ci.sh DUMMY' } }
		//} }

		stage('Team-Gate-Deploy-Exit-PLUTO') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-Test-Enter-PLUTO') { steps { sh './ci.sh DUMMY' } }

		//stage('Team-Gate-Test-PLUTO') { parallel {
		stage('Team-Gate-Test-Functional-PLUTO') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Test-Performance-PLUTO') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Test-Security-PLUTO') { steps { sh './ci.sh DUMMY' } }
		//} }

		stage('Team-Gate-Test-Exit-PLUTO') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-Exit-PLUTO') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-End-PLUTO') { steps { echo 'CI-PIPELINE-TEAM-GATE-PLUTO-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
