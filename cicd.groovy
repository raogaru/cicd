// ######################################################################
pipelineJob('DEMO-CI-Pipeline') {
  definition {
    cps {
      script('''
pipeline {
	agent any
//	environmentVariables(PROCEED: 'YES')

	options { 
		colorizeOutput()
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
		stage('Banner') { steps { echo 'CI-PIPELINE-START' } }

		stage('Git-CICD') { steps { git(url: 'https://github.com/raogaru/cicd.git', branch: 'master', credentialsId: 'raogaru', poll: 'false') } }
		stage('Git-MyApp') { steps { dir('myapp') { git(url: 'https://github.com/raogaru/myapp.git', branch: 'master', credentialsId: 'raogaru', poll: 'false') } } }

		stage('Main-Gate-Entry') { steps { sh './cicd.sh Main-Gate-Entry' } }

		stage('Main-Gate-Build') { steps { sh './cicd.sh Main-Gate-Build' } }

		stage('Team-Gate-Entry') { steps { sh './cicd.sh Team-Gate-Entry' } }

		//stage('Team-Gate-Build-1') { parallel {
		stage('Team-Gate-Build-MARS-1') { steps { sh './cicd.sh Team-Build-MARS-1' } }
		stage('Team-Gate-Build-VENUS-1') { steps { sh './cicd.sh Team-Build-VENUS-1' } }
		stage('Team-Gate-Build-PLUTO-1') { steps { sh './cicd.sh Team-Build-PLUTO-1' } }
		//}}
		
		//stage('Team-Gate-Build-2') { parallel {
		stage('Team-Gate-Build-MARS-2') { steps { sh './cicd.sh Team-Build-MARS-2' } }
		stage('Team-Gate-Build-VENUS-2') { steps { sh './cicd.sh Team-Build-VENUS-2' } }
		stage('Team-Gate-Build-PLUTO-2') { steps { sh './cicd.sh Team-Build-PLUTO-2' } }
		//}}

		//stage('Team-Gate-Build-3') { parallel {
		stage('Team-Gate-Build-MARS-3') { steps { sh './cicd.sh Team-Build-MARS-3' } }
		stage('Team-Gate-Build-VENUS-3') { steps { sh './cicd.sh Team-Build-VENUS-3' } }
		stage('Team-Gate-Build-PLUTO-3') { steps { sh './cicd.sh Team-Build-PLUTO-3' } }
		//}}

		stage('Team-Build-Exit') { steps { sh './cicd.sh Team-Build-Exit' } }

		//stage('Team-Gate-Deploy-1') { parallel {
		stage('Team-Gate-Deploy-MARS-1') { steps { sh './cicd.sh Team-Deploy-MARS-1' } }
		stage('Team-Gate-Deploy-VENUS-1') { steps { sh './cicd.sh Team-Deploy-VENUS-1' } }
		stage('Team-Gate-Deploy-PLUTO-1') { steps { sh './cicd.sh Team-Deploy-PLUTO-1' } }
		//}}

		//stage('Team-Gate-Deploy-2') { parallel {
		stage('Team-Gate-Deploy-MARS-2') { steps { sh './cicd.sh Team-Deploy-MARS-2' } }
		stage('Team-Gate-Deploy-VENUS-2') { steps { sh './cicd.sh Team-Deploy-VENUS-2' } }
		stage('Team-Gate-Deploy-PLUTO-2') { steps { sh './cicd.sh Team-Deploy-PLUTO-2' } }
		//}}

		//stage('Team-Gate-Deploy-3') { parallel {
		stage('Team-Gate-Deploy-MARS-3') { steps { sh './cicd.sh Team-Deploy-MARS-3' } }
		stage('Team-Gate-Deploy-VENUS-3') { steps { sh './cicd.sh Team-Deploy-VENUS-3' } }
		stage('Team-Gate-Deploy-PLUTO-3') { steps { sh './cicd.sh Team-Deploy-PLUTO-3' } }
		//}}

		stage('Team-Gate-Deploy-Exit') { steps { sh './cicd.sh Team-Deploy-Exit' } }

		//stage('Team-Gate-Test-1') { parallel {
		stage('Team-Gate-Test-MARS-1') { steps { sh './cicd.sh Team-Test-MARS-1' } }
		stage('Team-Gate-Test-VENUS-1') { steps { sh './cicd.sh Team-Test-VENUS-1' } }
		stage('Team-Gate-Test-PLUTO-1') { steps { sh './cicd.sh Team-Test-PLUTO-1' } }
		//}}

		//stage('Team-Gate-Test-2') { parallel {
		stage('Team-Gate-Test-MARS-2') { steps { sh './cicd.sh Team-Test-MARS-2' } }
		stage('Team-Gate-Test-VENUS-2') { steps { sh './cicd.sh Team-Test-VENUS-2' } }
		stage('Team-Gate-Test-PLUTO-2') { steps { sh './cicd.sh Team-Test-PLUTO-2' } }
		//}}

		//stage('Team-Gate-Test-3') { parallel {
		stage('Team-Gate-Test-MARS-3') { steps { sh './cicd.sh Team-Test-MARS-3' } }
		stage('Team-Gate-Test-VENUS-3') { steps { sh './cicd.sh Team-Test-VENUS-3' } }
		stage('Team-Gate-Test-PLUTO-3') { steps { sh './cicd.sh Team-Test-PLUTO-3' } }
		//}}

		stage('Team-Gate-Test-Exit') { steps { sh './cicd.sh Team-Test-Exit' } }

		stage('Team-Gate-Exit') { steps { sh './cicd.sh Team-Gate-Exit' } }

		stage('System-Gate-Entry') { steps { sh './cicd.sh System-Gate-Entry' } }

		stage('System-Gate-Build-1') { steps { sh './cicd.sh System-Build-1' } }
		stage('System-Gate-Build-2') { steps { sh './cicd.sh System-Build-2' } }
		stage('System-Gate-Build-3') { steps { sh './cicd.sh System-Build-3' } }
		stage('System-Gate-Build-Exit') { steps { sh './cicd.sh System-Build-Exit' } }

		stage('System-Gate-Deploy-1') { steps { sh './cicd.sh System-Deploy-1' }} 
		stage('System-Gate-Deploy-2') { steps { sh './cicd.sh System-Deploy-2' } }
		stage('System-Gate-Deploy-3') { steps { sh './cicd.sh System-Deploy-3' } }
		stage('System-Gate-Deploy-Exit') { steps { sh './cicd.sh System-Deploy-Exit' } }

		stage('System-Gate-Test-1') { steps { sh './cicd.sh System-Test-1' } }
		stage('System-Gate-Test-2') { steps { sh './cicd.sh System-Test-2' } }
		stage('System-Gate-Test-3') { steps { sh './cicd.sh System-Test-3' } }
		stage('System-Gate-Test-Exit') { steps { sh './cicd.sh System-Test-Exit' } }

		stage('System-Gate-Exit') { steps { sh './cicd.sh System-Gate-Exit' } }

		stage('Release-Gate-Entry') { steps { sh './cicd.sh Release-Gate-Entry' } }
		stage('Release-Gate-Prepare') { steps { sh './cicd.sh Release-Gate-Prepare' } }
		stage('Release-Gate-Build') { steps { sh './cicd.sh Release-Gate-Build' } }
		stage('Release-Gate-Artifacts') { steps { sh './cicd.sh Release-Gate-Artifacts' } }
		stage('Release-Gate-Verify') { steps { sh './cicd.sh Release-Gate-Verify' }} 
		stage('Release-Gate-Publish') { steps { sh './cicd.sh Release-Gate-Publish' }} 
		stage('Release-Gate-Notify') { steps { sh './cicd.sh Release-Gate-Notify' } }
		stage('Release-Gate-Exit') { steps { sh './cicd.sh Release-Gate-Exit' } }

		stage('Exit') { steps { sh './cicd.sh Exit' } }

	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
