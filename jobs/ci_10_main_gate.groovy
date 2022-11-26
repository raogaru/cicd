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
//		ws('/tmp/cicd')
	}
	environment {
		vPROCEED = 'YES'
		v_gate = 'MAIN'
	}

	stages { 

	stage('Main-Gate-Start') { steps { echo 'CI-PIPELINE-MAIN-GATE-START' } } 

	stage('Main-Gate-Git') 	{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-MARS',credentialsId:'raogaru',poll:'false')} 
		} }

	stage('Main-Gate-Enter') { steps { sh './ci.sh Main-Gate-Enter' } }

	stage('Main-Gate-Checkin') { steps { sh './ci.sh Main-Gate-Checkin' } }

	stage('Main-Gate-Prepare') { steps { sh './ci.sh Main-Gate-Prepare' } }

	stage('Main-Gate-Verify') { steps { sh './ci.sh Main-Gate-Verify' } }

	stage('Main-Gate-End') { steps { echo 'CI-PIPELINE-MAIN-GATE-END' } } 

	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
