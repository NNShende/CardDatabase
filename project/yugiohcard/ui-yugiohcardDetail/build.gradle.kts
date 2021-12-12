apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {

    "implementation"(project(Modules.yugiohcardInteractors))
    "implementation"(project(Modules.yugiohcardDomain))
    "implementation"(project(Modules.core))

    "implementation"(Coil.coil)

    "implementation"(Accompanist.pager)
    "implementation"(Accompanist.pagerIndicator)
}