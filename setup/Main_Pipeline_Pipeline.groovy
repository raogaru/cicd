// ######################################################################
pipelineJob('DEMO-CI-000-Main-Pipeline') {
  definition {
    cps {
      script('''
pipeline {
	agent any
	options { timestamps() }
	stages {
		stage('Enter') 		{ steps { build 'DEMO-CI-010-Main-Pipeline-Entry' } }
		stage('TeamGate') 	{ steps { build 'DEMO-CI-400-Team-Gate-Pipeline' } }
		stage('SystemGate') { steps { build 'DEMO-CI-500-System-Gate-Pipeline' } }
		stage('ReleaseGate') { steps { build 'DEMO-CI-600-Release-Gate-Pipeline' } }
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
