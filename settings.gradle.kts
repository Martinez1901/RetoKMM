pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "RetoKMM"
include(":androidApp")
include(":shared")
include(":domain")
include(":dataAccess")
