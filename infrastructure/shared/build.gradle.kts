import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

version = "1.0"

kotlin {
    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../../iosApp/Podfile")
    }
    
    sourceSets {
        val kodeinVersion = "7.1.0"
        val mokomvvmVersion = "0.11.0"
        val sqlDelightVersion: String by project
        val commonMain by getting {
            dependencies {
                implementation ("org.kodein.di:kodein-di:$kodeinVersion")
                // MOKO - MVVM
                implementation ("dev.icerock.moko:mvvm:$mokomvvmVersion")
                implementation("io.ktor:ktor-client-core:1.6.4")
                implementation("io.ktor:ktor-client-serialization:1.6.4")
                implementation(project(":infrastructure:utilities"))
                implementation(project(":infrastructure:domain"))
                implementation(project(":infrastructure:dataAccess"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting
        val iosTest by getting
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("AndroidManifest.xml")
    defaultConfig {
        minSdk = 22
        targetSdk = 31
    }
}