// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-421-Team-Gate-VENUS-Build-1') {
        description('DEMO-CI-421-Team-Gate-VENUS-Build-1')
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
        shell('./demo.sh TEAM_BUILD VENUS 1')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-422-Team-Gate-VENUS-Build-2') {
        description('DEMO-CI-422-Team-Gate-VENUS-Build-2')
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
        shell('./demo.sh TEAM_BUILD VENUS 2')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-423-Team-Gate-VENUS-Build-3') {
        description('DEMO-CI-423-Team-Gate-VENUS-Build-3')
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
        shell('./demo.sh TEAM_BUILD VENUS 3')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-424-Team-Gate-VENUS-Build-4') {
        description('DEMO-CI-424-Team-Gate-VENUS-Build-4')
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
        shell('./demo.sh TEAM_BUILD VENUS 4')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-425-Team-Gate-VENUS-Build-5') {
        description('DEMO-CI-425-Team-Gate-VENUS-Build-5')
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
        shell('./demo.sh TEAM_BUILD VENUS 5')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-431-Team-Gate-VENUS-Deploy-1') {
        description('DEMO-CI-431-Team-Gate-VENUS-Deploy-1')
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
        shell('./demo.sh TEAM_DEPLOY VENUS 1')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-432-Team-Gate-VENUS-Deploy-2') {
        description('DEMO-CI-432-Team-Gate-VENUS-Deploy-2')
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
        shell('./demo.sh TEAM_DEPLOY VENUS 2')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-433-Team-Gate-VENUS-Deploy-3') {
        description('DEMO-CI-433-Team-Gate-VENUS-Deploy-3')
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
        shell('./demo.sh TEAM_DEPLOY VENUS 3')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-434-Team-Gate-VENUS-Deploy-4') {
        description('DEMO-CI-434-Team-Gate-VENUS-Deploy-4')
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
        shell('./demo.sh TEAM_DEPLOY VENUS 4')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-435-Team-Gate-VENUS-Deploy-5') {
        description('DEMO-CI-435-Team-Gate-VENUS-Deploy-5')
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
        shell('./demo.sh TEAM_DEPLOY VENUS 5')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-441-Team-Gate-VENUS-Test-1') {
        description('DEMO-CI-441-Team-Gate-VENUS-Test-1')
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
        shell('./demo.sh TEAM_TEST VENUS 1')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-442-Team-Gate-VENUS-Test-2') {
        description('DEMO-CI-442-Team-Gate-VENUS-Test-2')
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
        shell('./demo.sh TEAM_TEST VENUS 2')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-443-Team-Gate-VENUS-Test-3') {
        description('DEMO-CI-443-Team-Gate-VENUS-Test-3')
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
        shell('./demo.sh TEAM_TEST VENUS 3')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-444-Team-Gate-VENUS-Test-4') {
        description('DEMO-CI-444-Team-Gate-VENUS-Test-4')
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
        shell('./demo.sh TEAM_TEST VENUS 4')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-445-Team-Gate-VENUS-Test-5') {
        description('DEMO-CI-445-Team-Gate-VENUS-Test-5')
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
        shell('./demo.sh TEAM_TEST VENUS 5')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
