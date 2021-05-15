// ----------------------------------------------------------------------
listView("DEMO-CI-Team-Gate") {
    description("DEMO-CI-Team-Gate")
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/DEMO-CI-4..-Team-Gate-.+/)
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
// ----------------------------------------------------------------------
listView("DEMO-CI-Team-Gate-MARS") {
    description("DEMO-CI-Team-Gate-MARS")
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/DEMO-CI-4..-Team-Gate-MARS-.+/)
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
// ----------------------------------------------------------------------
listView("DEMO-CI-Team-Gate-VENUS") {
    description("DEMO-CI-Team-Gate-VENUS")
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/DEMO-CI-4..-Team-Gate-VENUS-.+/)
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
// ----------------------------------------------------------------------
listView("DEMO-CI-Team-Gate-PLUTO") {
    description("DEMO-CI-Team-Gate-PLUTO")
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/DEMO-CI-4..-Team-Gate-PLUTO-.+/)
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
