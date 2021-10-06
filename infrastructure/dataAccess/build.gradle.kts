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

    iosTarget("ios") {}

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        frameworkName = "dataAccess"
        // set path to your ios project podfile, e.g. podfile = project.file("../iosApp/Podfile")
    }
    
    sourceSets {
        val ktorVersion = "1.6.1"
        val serializationVersion = "1.2.2"
        val sqlDelightVersion: String by project
        val kodeinVersion = "7.1.0"

        val commonMain by getting {
            dependencies {
                // KTOR
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                // SQL Delight
                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
                //SERIALIZATION
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")
                // KODE IN
                implementation ("org.kodein.di:kodein-di:$kodeinVersion")
                implementation(project(":infrastructure:domain"))
                implementation(project(":infrastructure:shared"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                // KTOR
                implementation("io.ktor:ktor-client-android:$ktorVersion")
                // SQL Delight
                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting{
            dependencies {
                implementation("io.ktor:ktor-client-ios:$ktorVersion")
                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(22)
        targetSdkVersion(31)
    }
}

sqldelight {
    database("MarvelDatabase") {
        packageName = "droal.shareddb"
    }
}
