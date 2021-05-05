listView("DEMO-CI-System-Gate") {
    description("DEMO-CI-System-Gate")
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/DEMO-CI-5..-System-Gate-.+/)
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
