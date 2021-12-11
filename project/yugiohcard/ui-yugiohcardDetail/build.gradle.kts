apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    "implementation"(Hilt.android)
    "kapt"(Hilt.compiler)
}