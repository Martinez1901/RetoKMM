pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "RetoKMM"
include(":infrastructure:androidApp")
include(":infrastructure:shared")
include(":infrastructure:domain")
include(":infrastructure:dataAccess")
