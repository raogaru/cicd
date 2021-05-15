listView("DEMO-CI-Release-Gate") {
    description("DEMO-CI-Release-Gate")
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/DEMO-CI-6..-Release-Gate-.+/)
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
