// ----------------------------------------------------------------------
job('DEMO-CI-600-Release-Gate-Entry') {
        description('DEMO-CI-600-Release-Gate-Entry')
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
        shell('./cicd.sh RELEASE ENTRY')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-610-Release-Gate-Prepare') {
        description('DEMO-CI-610-Release-Gate-Prepare')
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
        shell('./cicd.sh RELEASE PREPARE')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-620-Release-Gate-Build') {
        description('DEMO-CI-620-Release-Gate-Build')
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
        shell('./cicd.sh RELEASE BUILD')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-630-Release-Gate-Verify') {
        description('DEMO-CI-630-Release-Gate-Verify')
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
        shell('./cicd.sh RELEASE VERIFY')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-640-Release-Gate-Publish') {
        description('DEMO-CI-640-Release-Gate-Publish')
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
        shell('./cicd.sh RELEASE PUBLISH')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-650-Release-Gate-Notify') {
        description('DEMO-CI-650-Release-Gate-Notify')
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
        shell('./cicd.sh RELEASE NOTIFY')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-690-Release-Gate-Exit') {
        description('DEMO-CI-690-Release-Gate-Exit')
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
        shell('./cicd.sh RELEASE EXIT')
        }
}
// ----------------------------------------------------------------------
