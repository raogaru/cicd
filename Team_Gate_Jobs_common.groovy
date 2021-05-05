// ----------------------------------------------------------------------
job('DEMO-CI-410-Team-Gate-Entry') {
        description('DEMO-CI-410-Team-Gate-Entry')
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
        shell('./Team-Gate-Entry.sh')
        }
}
// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
job('DEMO-CI-490-Team-Gate-Exit') {
        description('DEMO-CI-490-Team-Gate-Exit')
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
        shell('./Team-Gate-Build.sh 1')
        }
}
// ----------------------------------------------------------------------
