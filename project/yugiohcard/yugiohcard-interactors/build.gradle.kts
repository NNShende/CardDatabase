apply {
    from("$rootDir/library-build.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.yugiohcardDataSource))
    "implementation"(project(Modules.yugiohcardDomain))

    "implementation"(Kotlinx.coroutinesCore)
}