// ----------------------------------------------------------------------
job('DEMO-CI-010-Main-Pipeline-Entry') {
        description('DEMO-CI-010-Main-Pipeline-Entry')
        wrappers {
                colorizeOutput()
                timestamps()
                preBuildCleanup()
                buildName('#-')
        }
        logRotator {
                daysToKeep(1)
                numToKeep(24)
        }
	scm {github('raogaru/cicd')}
        steps {
        shell('./demo.sh')
        }
}
// ----------------------------------------------------------------------
