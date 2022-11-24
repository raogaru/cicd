// ######################################################################
pipelineJob('ci-21-team-gate-MARS') {
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
		stage('Team-Gate-Start-MARS') { steps { echo 'CI-PIPELINE-TEAM-GATE-MARS-START' } } 

		stage('Team-Gate-Git-MARS') { steps { git(url: 'https://github.com/raogaru/cicd.git', branch: 'master', credentialsId: 'raogaru', poll: 'false') } }
		stage('Team-Gate-Enter-MARS') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-Build-Enter-MARS') { steps { sh './ci.sh DUMMY' } }

		//stage('Team-Gate-Build-MARS') { parallel {
		stage('Team-Gate-Build-DB-Docker-MARS') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Build-Web-Docker-MARS') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Build-App-Docker-MARS') { steps { sh './ci.sh DUMMY' } }
		//} }

		stage('Team-Gate-Build-Exit-MARS') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-Deploy-Enter-MARS') { steps { sh './ci.sh DUMMY' } }

		//stage('Team-Gate-Deploy-MARS') { parallel {
		stage('Team-Gate-Deploy-DB-Docker-MARS') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Deploy-Web-Docker-MARS') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Deploy-App-Docker-MARS') { steps { sh './ci.sh DUMMY' } }
		//} }

		stage('Team-Gate-Deploy-Exit-MARS') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-Test-Enter-MARS') { steps { sh './ci.sh DUMMY' } }

		//stage('Team-Gate-Test-MARS') { parallel {
		stage('Team-Gate-Test-Functional-MARS') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Test-Performance-MARS') { steps { sh './ci.sh DUMMY' } }
		stage('Team-Gate-Test-Security-MARS') { steps { sh './ci.sh DUMMY' } }
		//} }

		stage('Team-Gate-Test-Exit-MARS') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-Exit-MARS') { steps { sh './ci.sh DUMMY' } }

		stage('Team-Gate-End-MARS') { steps { echo 'CI-PIPELINE-TEAM-GATE-MARS-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
