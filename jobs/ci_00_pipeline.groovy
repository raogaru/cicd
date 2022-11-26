// ######################################################################
pipelineJob('DEMO-CI-00-pipeline') {
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
	triggers {
		cron('@hourly')
	}

	stages {
		stage('start') { steps { echo 'CI-PIPELINE-START' } } 
		stage ('DEMO-CI-10-main-gate') {steps {build job: 'DEMO-CI-10-main-gate', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-20-team-gate') {steps {build job: 'DEMO-CI-20-team-gate', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-30-system-gate') {steps {build job: 'DEMO-CI-30-system-gate', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-40-release-gate') {steps {build job: 'DEMO-CI-40-release-gate', parameters: [string(name: 'param1', value: "value1")]}}
		stage('end') { steps { echo 'CI-PIPELINE-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
