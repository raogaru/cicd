// ----------------------------------------------------------------------
job('DEMO-CI-010-Main-Gate-Entry') {
        description('DEMO-CI-010-Main-Gate-Entry')
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
        shell('./cicd.sh MAIN ENTRY')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-990-Main-Gate-Exit') {
        description('DEMO-CI-990-Main-Gate-Exit')
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
        shell('./cicd.sh MAIN EXIT')
        }
}
// ----------------------------------------------------------------------
