// ######################################################################
pipelineJob('ci-00-pipeline') {
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
	triggers {
		cron('@hourly')
	}

	stages {
		stage('start') { steps { echo 'CI-PIPELINE-START' } } 
		stage ('ci-10-main-gate') {steps {build job: 'ci-10-main-gate', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('ci-20-team-gate') {steps {build job: 'ci-20-team-gate', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('ci-30-system-gate') {steps {build job: 'ci-30-system-gate', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('ci-40-release-gate') {steps {build job: 'ci-40-release-gate', parameters: [string(name: 'param1', value: "value1")]}}
		stage('end') { steps { echo 'CI-PIPELINE-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
