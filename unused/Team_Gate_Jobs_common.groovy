// ----------------------------------------------------------------------
job('DEMO-CI-410-Team-Gate-Entry') {
        description('DEMO-CI-410-Team-Gate-Entry')
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
        shell('./cicd.sh TEAM_GATE ENTRY')
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
                buildName('#${BUILD_NUMBER}-${PIPE_NUMBER}')
        }
        logRotator {
                daysToKeep(1)
                numToKeep(24)
        }
	scm {github('raogaru/cicd')}
        steps {
        shell('./cicd.sh TEAM_GATE EXIT')
        }
}
// ----------------------------------------------------------------------
