buildscript {
    val kotlin_version by extra("1.5.21")
    val sqlDelightVersion: String by project
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlin_version")
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
        classpath("com.android.tools.build:gradle:7.0.2")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}