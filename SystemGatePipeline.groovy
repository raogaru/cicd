// ######################################################################
pipelineJob('DEMO-CI-500-System-Gate-Pipeline') {
  definition {
    cps {
      script('''
pipeline {
	agent any
	options { timestamps() }
	stages {
		stage('Enter') { steps { build 'DEMO-CI-510-System-Gate-Entry' } }

		stage ('Build') { parallel {
		stage('Build-1') { steps { build 'DEMO-CI-521-System-Gate-Build-1' } }
		stage('Build-2') { steps { build 'DEMO-CI-522-System-Gate-Build-2' } }
		stage('Build-3') { steps { build 'DEMO-CI-523-System-Gate-Build-3' } }
		stage('Build-4') { steps { build 'DEMO-CI-524-System-Gate-Build-4' } }
		stage('Build-5') { steps { build 'DEMO-CI-525-System-Gate-Build-5' } }
		}}

		stage ('Deploy') { parallel {
		stage('Deploy-1') { steps { build 'DEMO-CI-531-System-Gate-Deploy-1' } }
		stage('Deploy-2') { steps { build 'DEMO-CI-532-System-Gate-Deploy-2' } }
		stage('Deploy-3') { steps { build 'DEMO-CI-533-System-Gate-Deploy-3' } }
		stage('Deploy-4') { steps { build 'DEMO-CI-534-System-Gate-Deploy-4' } }
		stage('Deploy-5') { steps { build 'DEMO-CI-535-System-Gate-Deploy-5' } }
		}}

		stage ('Test') { parallel {
		stage('Test-1') { steps { build 'DEMO-CI-541-System-Gate-Test-1' } }
		stage('Test-2') { steps { build 'DEMO-CI-542-System-Gate-Test-2' } }
		stage('Test-3') { steps { build 'DEMO-CI-543-System-Gate-Test-3' } }
		stage('Test-4') { steps { build 'DEMO-CI-544-System-Gate-Test-4' } }
		stage('Test-5') { steps { build 'DEMO-CI-545-System-Gate-Test-5' } }
		}}

		stage('Exit') { steps { build 'DEMO-CI-510-System-Gate-Exit' } }
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
