plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":infrastructure:shared"))
    implementation(project(":infrastructure:dataAccess"))
    implementation("dev.icerock.moko:mvvm:0.11.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    // MULTI DEX
    implementation ("androidx.multidex:multidex:2.0.1")
}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "com.example.retokmm.android"
        minSdkVersion(22)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}