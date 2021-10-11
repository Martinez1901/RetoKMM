plugins {
    kotlin("android")
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {
    implementation(project(":infrastructure:shared"))
    implementation(project(":infrastructure:domain"))
    implementation(project(":infrastructure:utilities"))
    implementation(project(":infrastructure:dataAccess"))
    implementation("dev.icerock.moko:mvvm:0.11.0")
    // MULTI DEX
    implementation ("androidx.multidex:multidex:2.0.1")

    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")

    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("androidx.activity:activity-ktx:1.3.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // Image Loading library Coil
    implementation("io.coil-kt:coil:1.3.2")
    implementation("com.google.code.gson:gson:2.8.8")
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
    buildFeatures {
        viewBinding = true
    }
}