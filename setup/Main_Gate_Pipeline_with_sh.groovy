// ######################################################################
pipelineJob('DEMO-CI-000-Pipeline-Calling-Shell') {
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
	}

	stages {
		stage('Banner') { steps { echo 'CI-PIPELINE-START' } }

		stage('Git') { steps { git(url: 'https://github.com/raogaru/cicd.git', branch: 'master', credentialsId: 'raogaru') } }

		stage('Main-Gate-Entry') { steps { sh './demo.sh Main-Gate-Entry' } }

		stage('Team-Gate-Entry') { steps { sh './demo.sh Team-Gate-Entry' } }

		stage('Team-Build-1') { 
		//parallel {
		stage('Team-Build-MARS-1') { steps { sh './demo.sh Team-Build-MARS-1' } }
		stage('Team-Build-VENUS-1') { steps { sh './demo.sh Team-Build-VENUS-1' } }
		stage('Team-Build-PLUTO-1') { steps { sh './demo.sh Team-Build-PLUTO-1' } }
		//}
		}
/*		
		stage('Team-Build-2') { parallel {
		stage('Team-Build-MARS-2') { steps { sh './demo.sh Team-Build-MARS-2' } }
		stage('Team-Build-VENUS-2') { steps { sh './demo.sh Team-Build-VENUS-2' } }
		stage('Team-Build-PLUTO-2') { steps { sh './demo.sh Team-Build-PLUTO-2' } }
		}}
		stage('Team-Build-3') { parallel {
		stage('Team-Build-MARS-3') { steps { sh './demo.sh Team-Build-MARS-3' } }
		stage('Team-Build-VENUS-3') { steps { sh './demo.sh Team-Build-VENUS-3' } }
		stage('Team-Build-PLUTO-3') { steps { sh './demo.sh Team-Build-PLUTO-3' } }
		}}
*/


		stage('Team-Deploy-1') { 
		//parallel {
		stage('Team-Deploy-MARS-1') { steps { sh './demo.sh Team-Deploy-MARS-1' } }
		stage('Team-Deploy-VENUS-1') { steps { sh './demo.sh Team-Deploy-VENUS-1' } }
		stage('Team-Deploy-PLUTO-1') { steps { sh './demo.sh Team-Deploy-PLUTO-1' } }
		//}
		}
/*
		stage('Team-Deploy-2') { parallel {
		stage('Team-Deploy-MARS-2') { steps { sh './demo.sh Team-Deploy-MARS-2' } }
		stage('Team-Deploy-VENUS-2') { steps { sh './demo.sh Team-Deploy-VENUS-2' } }
		stage('Team-Deploy-PLUTO-2') { steps { sh './demo.sh Team-Deploy-PLUTO-2' } }
		}}
		stage('Team-Deploy-3') { parallel {
		stage('Team-Deploy-MARS-3') { steps { sh './demo.sh Team-Deploy-MARS-3' } }
		stage('Team-Deploy-VENUS-3') { steps { sh './demo.sh Team-Deploy-VENUS-3' } }
		stage('Team-Deploy-PLUTO-3') { steps { sh './demo.sh Team-Deploy-PLUTO-3' } }
		}}
*/

		stage('Team-Test-1') { 
		//parallel {
		stage('Team-Test-MARS-1') { steps { sh './demo.sh Team-Test-MARS-1' } }
		stage('Team-Test-VENUS-1') { steps { sh './demo.sh Team-Test-VENUS-1' } }
		stage('Team-Test-PLUTO-1') { steps { sh './demo.sh Team-Test-PLUTO-1' } }
		//}
		}
/*
		stage('Team-Test-2') { parallel {
		stage('Team-Test-MARS-2') { steps { sh './demo.sh Team-Test-MARS-2' } }
		stage('Team-Test-VENUS-2') { steps { sh './demo.sh Team-Test-VENUS-2' } }
		stage('Team-Test-PLUTO-2') { steps { sh './demo.sh Team-Test-PLUTO-2' } }
		}}
		stage('Team-Test-3') { parallel {
		stage('Team-Test-MARS-3') { steps { sh './demo.sh Team-Test-MARS-3' } }
		stage('Team-Test-VENUS-3') { steps { sh './demo.sh Team-Test-VENUS-3' } }
		stage('Team-Test-PLUTO-3') { steps { sh './demo.sh Team-Test-PLUTO-3' } }
		}}
*/

		stage('Team-Gate-Exit') { steps { sh './demo.sh Team-Gate-Exit' } }

/*
		stage('System-Gate-Entry') { steps { sh './demo.sh System-Gate-Entry' } }
		stage('System-Build-1') { steps { sh './demo.sh System-Build-1' } }
		stage('System-Build-2') { steps { sh './demo.sh System-Build-2' } }
		stage('System-Build-3') { steps { sh './demo.sh System-Build-3' } }
		stage('System-Deploy-1') { steps { sh './demo.sh System-Deploy-1' }} 
		stage('System-Deploy-2') { steps { sh './demo.sh System-Deploy-2' } }
		stage('System-Deploy-3') { steps { sh './demo.sh System-Deploy-3' } }
		stage('System-Test-1') { steps { sh './demo.sh System-Test-1' } }
		stage('System-Test-2') { steps { sh './demo.sh System-Test-2' } }
		stage('System-Test-3') { steps { sh './demo.sh System-Test-3' } }
		stage('System-Gate-Exit') { steps { sh './demo.sh System-Gate-Exit' } }

		stage('Release-Gate-Entry') { steps { sh './demo.sh Release-Gate-Entry' } }
		stage('Release-Prepare') { steps { sh './demo.sh Release-Prepare' } }
		stage('Release-Build') { steps { sh './demo.sh Release-Build' } }
		stage('Release-Verify') { steps { sh './demo.sh Release-Verify' }} 
		stage('Release-Publish') { steps { sh './demo.sh Release-Publish' }} 
		stage('Release-Notify') { steps { sh './demo.sh Release-Notify' } }
		stage('Release-Gate-Exit') { steps { sh './demo.sh Release-Gate-Exit' } }
*/


		stage('Exit') { steps { sh './demo.sh Exit' } }
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
