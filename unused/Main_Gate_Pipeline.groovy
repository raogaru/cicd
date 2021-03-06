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

		stage('Team-Gate-Entry') { steps { build 'DEMO-CI-410-Team-Gate-Entry' } }

		stage('Team-Build-1') { parallel {
		stage('Build-MARS-1') { steps { build 'DEMO-CI-421-Team-Gate-MARS-Build-1' } }
		stage('Build-VENUS-1') { steps { build 'DEMO-CI-421-Team-Gate-VENUS-Build-1' } }
		stage('Build-PLUTO-1') { steps { build 'DEMO-CI-421-Team-Gate-PLUTO-Build-1' } }
		}}
		stage('Team-Build-2') { parallel {
		stage('Build-MARS-2') { steps { build 'DEMO-CI-422-Team-Gate-MARS-Build-2' } }
		stage('Build-VENUS-2') { steps { build 'DEMO-CI-422-Team-Gate-VENUS-Build-2' } }
		stage('Build-PLUTO-2') { steps { build 'DEMO-CI-422-Team-Gate-PLUTO-Build-2' } }
		}}
		stage('Team-Build-3') { parallel {
		stage('Build-MARS-3') { steps { build 'DEMO-CI-423-Team-Gate-MARS-Build-3' } }
		stage('Build-VENUS-3') { steps { build 'DEMO-CI-423-Team-Gate-VENUS-Build-3' } }
		stage('Build-PLUTO-3') { steps { build 'DEMO-CI-423-Team-Gate-PLUTO-Build-3' } }
		}}
		stage('Team-Build-4') { parallel {
		stage('Build-MARS-4') { steps { build 'DEMO-CI-424-Team-Gate-MARS-Build-4' } }
		stage('Build-VENUS-4') { steps { build 'DEMO-CI-424-Team-Gate-VENUS-Build-4' } }
		stage('Build-PLUTO-4') { steps { build 'DEMO-CI-424-Team-Gate-PLUTO-Build-4' } }
		}}
		stage('Team-Build-5') { parallel {
		stage('Build-MARS-5') { steps { build 'DEMO-CI-425-Team-Gate-MARS-Build-5' } }
		stage('Build-VENUS-5') { steps { build 'DEMO-CI-425-Team-Gate-VENUS-Build-5' } }
		stage('Build-PLUTO-5') { steps { build 'DEMO-CI-425-Team-Gate-PLUTO-Build-5' } }
		}}

		stage('Team-Deploy-1') { parallel {
		stage('Deploy-MARS-1') { steps { build 'DEMO-CI-431-Team-Gate-MARS-Deploy-1' } }
		stage('Deploy-VENUS-1') { steps { build 'DEMO-CI-431-Team-Gate-VENUS-Deploy-1' } }
		stage('Deploy-PLUTO-1') { steps { build 'DEMO-CI-431-Team-Gate-PLUTO-Deploy-1' } }
		}}
		stage('Team-Deploy-2') { parallel {
		stage('Deploy-MARS-2') { steps { build 'DEMO-CI-432-Team-Gate-MARS-Deploy-2' } }
		stage('Deploy-VENUS-2') { steps { build 'DEMO-CI-432-Team-Gate-VENUS-Deploy-2' } }
		stage('Deploy-PLUTO-2') { steps { build 'DEMO-CI-432-Team-Gate-PLUTO-Deploy-2' } }
		}}
		stage('Team-Deploy-3') { parallel {
		stage('Deploy-MARS-3') { steps { build 'DEMO-CI-433-Team-Gate-MARS-Deploy-3' } }
		stage('Deploy-VENUS-3') { steps { build 'DEMO-CI-433-Team-Gate-VENUS-Deploy-3' } }
		stage('Deploy-PLUTO-3') { steps { build 'DEMO-CI-433-Team-Gate-PLUTO-Deploy-3' } }
		}}
		stage('Team-Deploy-4') { parallel {
		stage('Deploy-MARS-4') { steps { build 'DEMO-CI-434-Team-Gate-MARS-Deploy-4' } }
		stage('Deploy-VENUS-4') { steps { build 'DEMO-CI-434-Team-Gate-VENUS-Deploy-4' } }
		stage('Deploy-PLUTO-4') { steps { build 'DEMO-CI-434-Team-Gate-PLUTO-Deploy-4' } }
		}}
		stage('Team-Deploy-5') { parallel {
		stage('Deploy-MARS-5') { steps { build 'DEMO-CI-435-Team-Gate-MARS-Deploy-5' } }
		stage('Deploy-VENUS-5') { steps { build 'DEMO-CI-435-Team-Gate-VENUS-Deploy-5' } }
		stage('Deploy-PLUTO5') { steps { build 'DEMO-CI-435-Team-Gate-PLUTO-Deploy-5' } }
		}}

		stage('Team-Test-1') { parallel {
		stage('Test-MARS-1') { steps { build 'DEMO-CI-441-Team-Gate-MARS-Test-1' } }
		stage('Test-VENUS-1') { steps { build 'DEMO-CI-441-Team-Gate-VENUS-Test-1' } }
		stage('Test-PLUTO-1') { steps { build 'DEMO-CI-441-Team-Gate-PLUTO-Test-1' } }
		}}
		stage('Team-Test-2') { parallel {
		stage('Test-MARS-2') { steps { build 'DEMO-CI-442-Team-Gate-MARS-Test-2' } }
		stage('Test-VENUS-2') { steps { build 'DEMO-CI-442-Team-Gate-VENUS-Test-2' } }
		stage('Test-PLUTO-2') { steps { build 'DEMO-CI-442-Team-Gate-PLUTO-Test-2' } }
		}}
		stage('Team-Test-3') { parallel {
		stage('Test-MARS-3') { steps { build 'DEMO-CI-443-Team-Gate-MARS-Test-3' } }
		stage('Test-VENUS-3') { steps { build 'DEMO-CI-443-Team-Gate-VENUS-Test-3' } }
		stage('Test-PLUTO-3') { steps { build 'DEMO-CI-443-Team-Gate-PLUTO-Test-3' } }
		}}
		stage('Team-Test-4') { parallel {
		stage('Test-MARS-4') { steps { build 'DEMO-CI-444-Team-Gate-MARS-Test-4' } }
		stage('Test-VENUS-4') { steps { build 'DEMO-CI-444-Team-Gate-VENUS-Test-4' } }
		stage('Test-PLUTO-4') { steps { build 'DEMO-CI-444-Team-Gate-PLUTO-Test-4' } }
		}}
		stage('Team-Test-5') { parallel {
		stage('Test-MARS-5') { steps { build 'DEMO-CI-445-Team-Gate-MARS-Test-5' } }
		stage('Test-VENUS-5') { steps { build 'DEMO-CI-445-Team-Gate-VENUS-Test-5' } }
		stage('Test-PLUTO-5') { steps { build 'DEMO-CI-445-Team-Gate-PLUTO-Test-5' } }
		}}

		stage('Team-Gate-Exit') { steps { build 'DEMO-CI-490-Team-Gate-Exit' } }

                stage('System-Gate-Entry') { steps { build 'DEMO-CI-510-System-Gate-Entry' } }

                stage('System-Build-1') { steps { build 'DEMO-CI-521-System-Gate-Build-1' } }
                stage('System-Build-2') { steps { build 'DEMO-CI-522-System-Gate-Build-2' } }
                stage('System-Build-3') { steps { build 'DEMO-CI-523-System-Gate-Build-3' } }
                stage('System-Build-4') { steps { build 'DEMO-CI-524-System-Gate-Build-4' } }
                stage('System-Build-5') { steps { build 'DEMO-CI-525-System-Gate-Build-5' } }

                stage('System-Deploy-1') { steps { build 'DEMO-CI-531-System-Gate-Deploy-1' } }
                stage('System-Deploy-2') { steps { build 'DEMO-CI-532-System-Gate-Deploy-2' } }
                stage('System-Deploy-3') { steps { build 'DEMO-CI-533-System-Gate-Deploy-3' } }
                stage('System-Deploy-4') { steps { build 'DEMO-CI-534-System-Gate-Deploy-4' } }
                stage('System-Deploy-5') { steps { build 'DEMO-CI-535-System-Gate-Deploy-5' } }

                stage('System-Test-1') { steps { build 'DEMO-CI-541-System-Gate-Test-1' } }
                stage('System-Test-2') { steps { build 'DEMO-CI-542-System-Gate-Test-2' } }
                stage('System-Test-3') { steps { build 'DEMO-CI-543-System-Gate-Test-3' } }
                stage('System-Test-4') { steps { build 'DEMO-CI-544-System-Gate-Test-4' } }
                stage('System-Test-5') { steps { build 'DEMO-CI-545-System-Gate-Test-5' } }

		stage('System-Gate-Exit') { steps { build 'DEMO-CI-590-System-Gate-Exit' } }

		stage('Release-Gate-Entry') { steps { build 'DEMO-CI-600-Release-Gate-Entry' } }
		stage('Release-Gate-Prepare') { steps { build 'DEMO-CI-610-Release-Gate-Prepare' } }
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
