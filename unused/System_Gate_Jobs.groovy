// ----------------------------------------------------------------------
job('DEMO-CI-510-System-Gate-Entry') {
        description('DEMO-CI-510-System-Gate-Entry')
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
        shell('./cicd.sh SYSTEM ENTRY')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-521-System-Gate-Build-1') {
        description('DEMO-CI-521-System-Gate-Build-1')
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
        shell('./cicd.sh SYSTEM BUILD 1')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-522-System-Gate-Build-2') {
        description('DEMO-CI-522-System-Gate-Build-2')
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
        shell('./cicd.sh SYSTEM BUILD 2')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-523-System-Gate-Build-3') {
        description('DEMO-CI-523-System-Gate-Build-3')
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
        shell('./cicd.sh SYSTEM BUILD 3')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-524-System-Gate-Build-4') {
        description('DEMO-CI-524-System-Gate-Build-4')
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
        shell('./cicd.sh SYSTEM BUILD 4')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-525-System-Gate-Build-5') {
        description('DEMO-CI-525-System-Gate-Build-5')
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
        shell('./cicd.sh SYSTEM BUILD 5')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-531-System-Gate-Deploy-1') {
        description('DEMO-CI-531-System-Gate-Deploy-1')
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
        shell('./cicd.sh SYSTEM DEPLOY 1')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-532-System-Gate-Deploy-2') {
        description('DEMO-CI-532-System-Gate-Deploy-2')
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
        shell('./cicd.sh SYSTEM DEPLOY 2')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-533-System-Gate-Deploy-3') {
        description('DEMO-CI-533-System-Gate-Deploy-3')
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
        shell('./cicd.sh SYSTEM DEPLOY 3')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-534-System-Gate-Deploy-4') {
        description('DEMO-CI-534-System-Gate-Deploy-4')
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
        shell('./cicd.sh SYSTEM DEPLOY 4')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-535-System-Gate-Deploy-5') {
        description('DEMO-CI-535-System-Gate-Deploy-5')
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
        shell('./cicd.sh SYSTEM DEPLOY 5')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-541-System-Gate-Test-1') {
        description('DEMO-CI-541-System-Gate-Test-1')
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
        shell('./cicd.sh SYSTEM TEST 1')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-542-System-Gate-Test-2') {
        description('DEMO-CI-542-System-Gate-Test-2')
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
        shell('./cicd.sh SYSTEM TEST 2')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-543-System-Gate-Test-3') {
        description('DEMO-CI-543-System-Gate-Test-3')
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
        shell('./cicd.sh SYSTEM TEST 3')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-544-System-Gate-Test-4') {
        description('DEMO-CI-544-System-Gate-Test-4')
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
        shell('./cicd.sh SYSTEM TEST 4')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-545-System-Gate-Test-5') {
        description('DEMO-CI-545-System-Gate-Test-5')
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
        shell('./cicd.sh SYSTEM TEST 5')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-590-System-Gate-Exit') {
        description('DEMO-CI-590-System-Gate-Exit')
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
        shell('./cicd.sh SYSTEM EXIT 1')
        }
}
// ----------------------------------------------------------------------
