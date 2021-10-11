plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":infrastructure:shared"))
    implementation(project(":infrastructure:dataAccess"))
    implementation("dev.icerock.moko:mvvm:0.11.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")
    // MULTI DEX
    implementation("androidx.multidex:multidex:2.0.1")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.example.retokmm.android"
        minSdk = 22
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}