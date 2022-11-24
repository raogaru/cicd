// ######################################################################
pipelineJob('DEMO-CI-10-main-gate') {
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
		vGATE = 'MAIN'
	}

	stages { 

	stage('Main-Gate-Start') { steps { echo 'CI-PIPELINE-MAIN-GATE-START' } } 

	stage('Main-Gate-Git-CICD') { steps { git(url: 'https://github.com/raogaru/cicd.git', branch: 'master', credentialsId: 'raogaru', poll: 'false') } }

	stage('Main-Gate-Git-MyApp') { steps { dir('myapp') { git(url: 'https://github.com/raogaru/myapp.git', branch: 'master', credentialsId: 'raogaru', poll: 'false') } } }

    stage('Main-Gate-Enter') { steps { sh './ci.sh mg_Enter' } }

    stage('Main-Gate-Checkin') { steps { sh './ci.sh mg_Checkin' } }

	//stage('Main-Gate-Prepare') { parallel {
			stage('Main-Gate-Prepare-DB-Docker') { steps { sh './ci.sh mg_Prepare db' } }
			stage('Main-Gate-Prepare-Web-Docker') { steps { sh './ci.sh mg_Prepare web' } }
			stage('Main-Gate-Prepare-App-Docker') { steps { sh './ci.sh mg_Prepare app' } }
	//} }

	stage('Main-Gate-Verify') { steps { sh './ci.sh mg_Verify' } }

	stage('Main-Gate-End') { steps { echo 'CI-PIPELINE-MAIN-GATE-END' } } 

	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
