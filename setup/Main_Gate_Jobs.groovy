// ----------------------------------------------------------------------
job('DEMO-CI-010-Main-Pipeline-Entry') {
        description('DEMO-CI-010-Main-Pipeline-Entry')
        wrappers {
                colorizeOutput()
                timestamps()
                preBuildCleanup()
                buildName('#${BUILD_NUMBER}-${PIPE_NUMBER}')
        }
        logRotator {
                daysToKeep(1)
                numToKeep(24)
        }
	scm {github('raogaru/cicd')}
        steps {
        shell('./demo.sh MAIN ENTRY')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-990-Main-Pipeline-Exit') {
        description('DEMO-CI-990-Main-Pipeline-Exit')
        wrappers {
                colorizeOutput()
                timestamps()
                preBuildCleanup()
                buildName('#${BUILD_NUMBER}-${PIPE_NUMBER}')
        }
        logRotator {
                daysToKeep(1)
                numToKeep(24)
        }
	scm {github('raogaru/cicd')}
        steps {
        shell('./demo.sh MAIN EXIT')
        }
}
// ----------------------------------------------------------------------
