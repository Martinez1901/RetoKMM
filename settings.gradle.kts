pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "RetoKMM"
include(":androidApp")
include(":infrastructure:shared")
include(":infrastructure:domain")
include(":infrastructure:dataAccess")
include(":infrastructure:utilities")
