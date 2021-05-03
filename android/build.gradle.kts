plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(BuildConfig.compileSdkVersion)

    defaultConfig {
        applicationId = "com.example.android.app"
        minSdkVersion(BuildConfig.minSdkVersion)
        targetSdkVersion(BuildConfig.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"

        resConfigs("en", "ja")
        vectorDrawables.useSupportLibrary = true
    }

    buildFeatures {
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    signingConfigs {
        getByName("debug") {
//            storeFile = rootProject.file("keystore/debug.keystore")
        }
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(Deps.Coroutines.core)
    implementation(Deps.Coroutines.android)

    implementation(Deps.Androidx.core)
    implementation(Deps.Androidx.activity)
    implementation(Deps.Androidx.appCompat)
    implementation(Deps.Androidx.fragment)

    implementation(Deps.materialDesign)
}