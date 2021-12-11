apply {
    from("$rootDir/library-build.gradle")
}
plugins {
    id(SqlDelight.plugin)
}

dependencies {
    "implementation"(project(Modules.yugiohcardDomain))

    "implementation"(Ktor.core)
    "implementation"(Ktor.clientSerialization)
    "implementation"(Ktor.android)

    "implementation"(SqlDelight.runtime)
}

sqldelight {
    database("YugiohCardDatabase") {
        packageName = "com.example.yugiohcard_datasource.cache"
        sourceFolders = listOf("sqldelight")
    }
}