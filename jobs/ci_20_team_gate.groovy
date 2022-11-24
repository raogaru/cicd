// ######################################################################
pipelineJob('ci-20-team-gate') {
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

	stages {
		stage('start') { steps { echo 'CI-PIPELINE-TEAM-GATE-START' } } 
		stage ('ci-21-team-gate-MARS') {steps {build job: 'ci-21-team-gate-MARS', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('ci-22-team-gate-PLUTO') {steps {build job: 'ci-22-team-gate-PLUTO', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('ci-23-team-gate-VENUS') {steps {build job: 'ci-23-team-gate-VENUS', parameters: [string(name: 'param1', value: "value1")]}}
		stage('end') { steps { echo 'CI-PIPELINE-TEAM-GATE-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
