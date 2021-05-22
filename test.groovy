// ######################################################################
pipelineJob('TEST-CI-Pipeline') {
  definition {
    cps {
      script('''
pipeline {
	agent any
	 environmentVariables(v_proceed: 'YES')

	options { 
		timestamps()
		ansiColor('xterm')
		disableConcurrentBuilds()
		timeout(59)
		buildDiscarder(logRotator(numToKeepStr: '5', daysToKeepStr: '1'))
	}

	triggers {
		cron('@hourly')
	}

	stages {
		stage('Banner') { steps { echo 'CI-PIPELINE-START' } }

		stage('Git') { steps { git(url: 'https://github.com/raogaru/cicd.git', branch: 'master', credentialsId: 'raogaru') } }

		stage('Main-Gate-Entry') { steps { sh './cicd.sh Main-Gate-Entry' } }

		stage('Main-Gate-Checkin') { 
			when { expression { ${vPROCEED} == 'YES' } }
			steps { sh './cicd.sh Main-Gate-Checkin' } 
		}

		stage('Main-Gate-Build') { steps { sh './cicd.sh Main-Gate-Build' } }

		stage('Team-Gate-Entry') { steps { sh './cicd.sh Team-Gate-Entry' } }

		stage('Exit') { steps { sh './cicd.sh Exit' } }

	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
