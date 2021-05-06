// ######################################################################
pipelineJob('DEMO-CI-000-Pipeline-Calling-Jobs') {
  definition {
    cps {
      script('''
pipeline {
	agent any
	options { timestamps() }
	stages {
		stage('Enter') { steps { build 'DEMO-CI-010-Main-Gate-Entry' } }

		stage('Git') { steps { sh 'echo Git' } }

		stage('Release-Gate-Build') { steps { build 'DEMO-CI-620-Release-Gate-Build' } }
		stage('Release-Gate-Verify') { steps { build 'DEMO-CI-630-Release-Gate-Verify' } }
		stage('Release-Gate-Publish') { steps { build 'DEMO-CI-640-Release-Gate-Publish' } }
		stage('Release-Gate-Notify') { steps { build 'DEMO-CI-650-Release-Gate-Notify' } }
		stage('Release-Gate-Exit') { steps { build 'DEMO-CI-690-Release-Gate-Exit' } }

		stage('Exit') { steps { build 'DEMO-CI-990-Main-Gate-Exit' } }
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
