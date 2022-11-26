// ######################################################################
pipelineJob('DEMO-CI-20-team-gate') {
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

	stages {
		stage('start') { steps { echo 'CI-PIPELINE-TEAM-GATE-START' } } 
		stage('execute') { 
		parallel {
		stage ('DEMO-CI-21-team-gate-MARS') {steps {build job: 'DEMO-CI-21-team-gate-MARS', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-22-team-gate-PLUTO') {steps {build job: 'DEMO-CI-22-team-gate-PLUTO', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-23-team-gate-VENUS') {steps {build job: 'DEMO-CI-23-team-gate-VENUS', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-24-team-gate-EARTH') {steps {build job: 'DEMO-CI-24-team-gate-EARTH', parameters: [string(name: 'param1', value: "value1")]}}
		} }
		stage('end') { steps { echo 'CI-PIPELINE-TEAM-GATE-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
