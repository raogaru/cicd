// ----------------------------------------------------------------------
listView("DEMO-CI") {
    description("DEMO-CI")
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/DEMO-CI-.+/)
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
}
// ----------------------------------------------------------------------
