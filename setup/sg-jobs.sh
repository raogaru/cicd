cat sg-jobs.lst | while read v_JOB_NAME
do
echo "// ----------------------------------------------------------------------
job('${v_JOB_NAME}') {
        description('${v_JOB_NAME}')
        wrappers {
                colorizeOutput()
                timestamps()
                preBuildCleanup()
                buildName('#${BUILD_NUMBER}-${PIPE_NUM}')
        }
        logRotator {
                daysToKeep(1)
                numToKeep(24)
        }
        steps {
        shell('./System-Gate-Build.sh 1')
        }
}
// ----------------------------------------------------------------------"
done
