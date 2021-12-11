apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.yugiohcardDomain))
    "implementation"(project(Modules.yugiohcardInteractors))

    "implementation"(SqlDelight.androidDriver)

    "implementation"(Coil.coil)
}