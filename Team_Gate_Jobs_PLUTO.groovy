// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-421-Team-Gate-PLUTO-Build-1') {
        description('DEMO-CI-421-Team-Gate-PLUTO-Build-1')
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
        steps {
        shell('./Team-Gate-Build.sh PLUTO 1')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-422-Team-Gate-PLUTO-Build-2') {
        description('DEMO-CI-422-Team-Gate-PLUTO-Build-2')
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
        steps {
        shell('./Team-Gate-Build.sh PLUTO 2')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-423-Team-Gate-PLUTO-Build-3') {
        description('DEMO-CI-423-Team-Gate-PLUTO-Build-3')
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
        steps {
        shell('./Team-Gate-Build.sh PLUTO 3')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-424-Team-Gate-PLUTO-Build-4') {
        description('DEMO-CI-424-Team-Gate-PLUTO-Build-4')
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
        steps {
        shell('./Team-Gate-Build.sh PLUTO 4')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-425-Team-Gate-PLUTO-Build-5') {
        description('DEMO-CI-425-Team-Gate-PLUTO-Build-5')
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
        steps {
        shell('./Team-Gate-Build.sh PLUTO 5')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-431-Team-Gate-PLUTO-Deploy-1') {
        description('DEMO-CI-431-Team-Gate-PLUTO-Deploy-1')
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
        steps {
        shell('./Team-Gate-Deploy.sh PLUTO 1')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-432-Team-Gate-PLUTO-Deploy-2') {
        description('DEMO-CI-432-Team-Gate-PLUTO-Deploy-2')
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
        steps {
        shell('./Team-Gate-Deploy.sh PLUTO 2')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-433-Team-Gate-PLUTO-Deploy-3') {
        description('DEMO-CI-433-Team-Gate-PLUTO-Deploy-3')
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
        steps {
        shell('./Team-Gate-Deploy.sh PLUTO 3')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-434-Team-Gate-PLUTO-Deploy-4') {
        description('DEMO-CI-434-Team-Gate-PLUTO-Deploy-4')
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
        steps {
        shell('./Team-Gate-Deploy.sh PLUTO 4')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-435-Team-Gate-PLUTO-Deploy-5') {
        description('DEMO-CI-435-Team-Gate-PLUTO-Deploy-5')
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
        steps {
        shell('./Team-Gate-Deploy.sh PLUTO 5')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-441-Team-Gate-PLUTO-Test-1') {
        description('DEMO-CI-441-Team-Gate-PLUTO-Test-1')
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
        steps {
        shell('./Team-Gate-Test.sh PLUTO 1')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-442-Team-Gate-PLUTO-Test-2') {
        description('DEMO-CI-442-Team-Gate-PLUTO-Test-2')
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
        steps {
        shell('./Team-Gate-Test.sh PLUTO 2')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-443-Team-Gate-PLUTO-Test-3') {
        description('DEMO-CI-443-Team-Gate-PLUTO-Test-3')
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
        steps {
        shell('./Team-Gate-Test.sh PLUTO 3')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-444-Team-Gate-PLUTO-Test-4') {
        description('DEMO-CI-444-Team-Gate-PLUTO-Test-4')
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
        steps {
        shell('./Team-Gate-Test.sh PLUTO 4')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-445-Team-Gate-PLUTO-Test-5') {
        description('DEMO-CI-445-Team-Gate-PLUTO-Test-5')
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
        steps {
        shell('./Team-Gate-Test.sh PLUTO 5')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
