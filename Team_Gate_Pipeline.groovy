// ######################################################################
pipelineJob('DEMO-CI-400-Team-Gate-Pipeline') {
  definition {
    cps {
      script('''
pipeline {
	agent any
	options { timestamps() }
	stages {
		stage('Enter') { steps { build 'DEMO-CI-410-Team-Gate-Entry' } }

		stage('TeamGate-MARS') { parallel {
		stage ('Build') { parallel {
		stage('Build-1') { steps { build 'DEMO-CI-421-Team-Gate-MARS-Build-1' } }
		stage('Build-2') { steps { build 'DEMO-CI-422-Team-Gate-MARS-Build-2' } }
		stage('Build-3') { steps { build 'DEMO-CI-423-Team-Gate-MARS-Build-3' } }
		stage('Build-4') { steps { build 'DEMO-CI-424-Team-Gate-MARS-Build-4' } }
		stage('Build-5') { steps { build 'DEMO-CI-425-Team-Gate-MARS-Build-5' } }
		}}

		stage ('Deploy') { parallel {
		stage('Deploy-1') { steps { build 'DEMO-CI-431-Team-Gate-MARS-Deploy-1' } }
		stage('Deploy-2') { steps { build 'DEMO-CI-432-Team-Gate-MARS-Deploy-2' } }
		stage('Deploy-3') { steps { build 'DEMO-CI-433-Team-Gate-MARS-Deploy-3' } }
		stage('Deploy-4') { steps { build 'DEMO-CI-434-Team-Gate-MARS-Deploy-4' } }
		stage('Deploy-5') { steps { build 'DEMO-CI-435-Team-Gate-MARS-Deploy-5' } }
		}}

		stage ('Test') { parallel {
		stage('Test-1') { steps { build 'DEMO-CI-441-Team-Gate-MARS-Test-1' } }
		stage('Test-2') { steps { build 'DEMO-CI-442-Team-Gate-MARS-Test-2' } }
		stage('Test-3') { steps { build 'DEMO-CI-443-Team-Gate-MARS-Test-3' } }
		stage('Test-4') { steps { build 'DEMO-CI-444-Team-Gate-MARS-Test-4' } }
		stage('Test-5') { steps { build 'DEMO-CI-445-Team-Gate-MARS-Test-5' } }
		}}
		}



		stage('TeamGate-VENUS') { parallel {
		stage ('Build') { parallel {
		stage('Build-1') { steps { build 'DEMO-CI-421-Team-Gate-VENUS-Build-1' } }
		stage('Build-2') { steps { build 'DEMO-CI-422-Team-Gate-VENUS-Build-2' } }
		stage('Build-3') { steps { build 'DEMO-CI-423-Team-Gate-VENUS-Build-3' } }
		stage('Build-4') { steps { build 'DEMO-CI-424-Team-Gate-VENUS-Build-4' } }
		stage('Build-5') { steps { build 'DEMO-CI-425-Team-Gate-VENUS-Build-5' } }
		}}

		stage ('Deploy') { parallel {
		stage('Deploy-1') { steps { build 'DEMO-CI-431-Team-Gate-VENUS-Deploy-1' } }
		stage('Deploy-2') { steps { build 'DEMO-CI-432-Team-Gate-VENUS-Deploy-2' } }
		stage('Deploy-3') { steps { build 'DEMO-CI-433-Team-Gate-VENUS-Deploy-3' } }
		stage('Deploy-4') { steps { build 'DEMO-CI-434-Team-Gate-VENUS-Deploy-4' } }
		stage('Deploy-5') { steps { build 'DEMO-CI-435-Team-Gate-VENUS-Deploy-5' } }
		}}

		stage ('Test') { parallel {
		stage('Test-1') { steps { build 'DEMO-CI-441-Team-Gate-VENUS-Test-1' } }
		stage('Test-2') { steps { build 'DEMO-CI-442-Team-Gate-VENUS-Test-2' } }
		stage('Test-3') { steps { build 'DEMO-CI-443-Team-Gate-VENUS-Test-3' } }
		stage('Test-4') { steps { build 'DEMO-CI-444-Team-Gate-VENUS-Test-4' } }
		stage('Test-5') { steps { build 'DEMO-CI-445-Team-Gate-VENUS-Test-5' } }
		}}
		}



		stage('TeamGate-PLUTO') { parallel {
		stage ('Build') { parallel {
		stage('Build-1') { steps { build 'DEMO-CI-421-Team-Gate-PLUTO-Build-1' } }
		stage('Build-2') { steps { build 'DEMO-CI-422-Team-Gate-PLUTO-Build-2' } }
		stage('Build-3') { steps { build 'DEMO-CI-423-Team-Gate-PLUTO-Build-3' } }
		stage('Build-4') { steps { build 'DEMO-CI-424-Team-Gate-PLUTO-Build-4' } }
		stage('Build-5') { steps { build 'DEMO-CI-425-Team-Gate-PLUTO-Build-5' } }
		}}

		stage ('Deploy') { parallel {
		stage('Deploy-1') { steps { build 'DEMO-CI-431-Team-Gate-PLUTO-Deploy-1' } }
		stage('Deploy-2') { steps { build 'DEMO-CI-432-Team-Gate-PLUTO-Deploy-2' } }
		stage('Deploy-3') { steps { build 'DEMO-CI-433-Team-Gate-PLUTO-Deploy-3' } }
		stage('Deploy-4') { steps { build 'DEMO-CI-434-Team-Gate-PLUTO-Deploy-4' } }
		stage('Deploy-5') { steps { build 'DEMO-CI-435-Team-Gate-PLUTO-Deploy-5' } }
		}}

		stage ('Test') { parallel {
		stage('Test-1') { steps { build 'DEMO-CI-441-Team-Gate-PLUTO-Test-1' } }
		stage('Test-2') { steps { build 'DEMO-CI-442-Team-Gate-PLUTO-Test-2' } }
		stage('Test-3') { steps { build 'DEMO-CI-443-Team-Gate-PLUTO-Test-3' } }
		stage('Test-4') { steps { build 'DEMO-CI-444-Team-Gate-PLUTO-Test-4' } }
		stage('Test-5') { steps { build 'DEMO-CI-445-Team-Gate-PLUTO-Test-5' } }
		}}
		}


		stage('Exit') { steps { build 'DEMO-CI-410-Team-Gate-Exit' } }
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
