// ######################################################################
pipelineJob('DEMO-CI-Pipeline') {
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

		stage('Hello-1') { 
			steps { 
				sh 'echo hell-1a'
				sh 'echo hell-1b'
				sh 'echo hell-1c'
			} 
		}

		stage('Hello-2') { 
			steps { 
				shell( 'echo hell-2a')
				shell( 'echo hell-2b')
				shell( 'echo hell-2c')
			} 
		}

/*
		stage('Main-Gate-Entry') { steps { sh './cicd.sh Main-Gate-Entry' } }

		stage('Team-Gate-Entry') { steps { sh './cicd.sh Team-Gate-Entry' } }

		//stage('Team-Build-1') { parallel {
		stage('Team-Build-MARS-1') { steps { sh './cicd.sh Team-Build-MARS-1' } }
		stage('Team-Build-VENUS-1') { steps { sh './cicd.sh Team-Build-VENUS-1' } }
		stage('Team-Build-PLUTO-1') { steps { sh './cicd.sh Team-Build-PLUTO-1' } }
		//}}
		
		//stage('Team-Build-2') { parallel {
		stage('Team-Build-MARS-2') { steps { sh './cicd.sh Team-Build-MARS-2' } }
		stage('Team-Build-VENUS-2') { steps { sh './cicd.sh Team-Build-VENUS-2' } }
		stage('Team-Build-PLUTO-2') { steps { sh './cicd.sh Team-Build-PLUTO-2' } }
		//}}

		//stage('Team-Build-3') { parallel {
		stage('Team-Build-MARS-3') { steps { sh './cicd.sh Team-Build-MARS-3' } }
		stage('Team-Build-VENUS-3') { steps { sh './cicd.sh Team-Build-VENUS-3' } }
		stage('Team-Build-PLUTO-3') { steps { sh './cicd.sh Team-Build-PLUTO-3' } }
		//}}

		stage('Team-Build-Exit') { steps { sh './cicd.sh Team-Build-Exit' } }

		//stage('Team-Deploy-1') { parallel {
		stage('Team-Deploy-MARS-1') { steps { sh './cicd.sh Team-Deploy-MARS-1' } }
		stage('Team-Deploy-VENUS-1') { steps { sh './cicd.sh Team-Deploy-VENUS-1' } }
		stage('Team-Deploy-PLUTO-1') { steps { sh './cicd.sh Team-Deploy-PLUTO-1' } }
		//}}

		//stage('Team-Deploy-2') { parallel {
		stage('Team-Deploy-MARS-2') { steps { sh './cicd.sh Team-Deploy-MARS-2' } }
		stage('Team-Deploy-VENUS-2') { steps { sh './cicd.sh Team-Deploy-VENUS-2' } }
		stage('Team-Deploy-PLUTO-2') { steps { sh './cicd.sh Team-Deploy-PLUTO-2' } }
		//}}

		//stage('Team-Deploy-3') { parallel {
		stage('Team-Deploy-MARS-3') { steps { sh './cicd.sh Team-Deploy-MARS-3' } }
		stage('Team-Deploy-VENUS-3') { steps { sh './cicd.sh Team-Deploy-VENUS-3' } }
		stage('Team-Deploy-PLUTO-3') { steps { sh './cicd.sh Team-Deploy-PLUTO-3' } }
		//}}

		stage('Team-Deploy-Exit') { steps { sh './cicd.sh Team-Deploy-Exit' } }

		//stage('Team-Test-1') { parallel {
		stage('Team-Test-MARS-1') { steps { sh './cicd.sh Team-Test-MARS-1' } }
		stage('Team-Test-VENUS-1') { steps { sh './cicd.sh Team-Test-VENUS-1' } }
		stage('Team-Test-PLUTO-1') { steps { sh './cicd.sh Team-Test-PLUTO-1' } }
		//}}

		//stage('Team-Test-2') { parallel {
		stage('Team-Test-MARS-2') { steps { sh './cicd.sh Team-Test-MARS-2' } }
		stage('Team-Test-VENUS-2') { steps { sh './cicd.sh Team-Test-VENUS-2' } }
		stage('Team-Test-PLUTO-2') { steps { sh './cicd.sh Team-Test-PLUTO-2' } }
		//}}

		//stage('Team-Test-3') { parallel {
		stage('Team-Test-MARS-3') { steps { sh './cicd.sh Team-Test-MARS-3' } }
		stage('Team-Test-VENUS-3') { steps { sh './cicd.sh Team-Test-VENUS-3' } }
		stage('Team-Test-PLUTO-3') { steps { sh './cicd.sh Team-Test-PLUTO-3' } }
		//}}

		stage('Team-Test-Exit') { steps { sh './cicd.sh Team-Test-Exit' } }

		stage('Team-Gate-Exit') { steps { sh './cicd.sh Team-Gate-Exit' } }

		stage('System-Gate-Entry') { steps { sh './cicd.sh System-Gate-Entry' } }

		stage('System-Build-1') { steps { sh './cicd.sh System-Build-1' } }
		stage('System-Build-2') { steps { sh './cicd.sh System-Build-2' } }
		stage('System-Build-3') { steps { sh './cicd.sh System-Build-3' } }
		stage('System-Build-Exit') { steps { sh './cicd.sh System-Build-Exit' } }

		stage('System-Deploy-1') { steps { sh './cicd.sh System-Deploy-1' }} 
		stage('System-Deploy-2') { steps { sh './cicd.sh System-Deploy-2' } }
		stage('System-Deploy-3') { steps { sh './cicd.sh System-Deploy-3' } }
		stage('System-Deploy-Exit') { steps { sh './cicd.sh System-Deploy-Exit' } }

		stage('System-Test-1') { steps { sh './cicd.sh System-Test-1' } }
		stage('System-Test-2') { steps { sh './cicd.sh System-Test-2' } }
		stage('System-Test-3') { steps { sh './cicd.sh System-Test-3' } }
		stage('System-Test-Exit') { steps { sh './cicd.sh System-Test-Exit' } }

		stage('System-Gate-Exit') { steps { sh './cicd.sh System-Gate-Exit' } }

		stage('Release-Gate-Entry') { steps { sh './cicd.sh Release-Gate-Entry' } }
		stage('Release-Prepare') { steps { sh './cicd.sh Release-Prepare' } }
		stage('Release-Build') { steps { sh './cicd.sh Release-Build' } }
		stage('Release-Verify') { steps { sh './cicd.sh Release-Verify' }} 
		stage('Release-Publish') { steps { sh './cicd.sh Release-Publish' }} 
		stage('Release-Notify') { steps { sh './cicd.sh Release-Notify' } }
		stage('Release-Gate-Exit') { steps { sh './cicd.sh Release-Gate-Exit' } }

		stage('Exit') { steps { sh './cicd.sh Exit' } }
*/
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
