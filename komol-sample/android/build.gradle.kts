plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(LibraryConfig.Android.compileSdkVersion)

    defaultConfig {
        applicationId = "com.github.droibit.komol.sample"
        minSdkVersion(LibraryConfig.Android.minSdkVersion)
        targetSdkVersion(LibraryConfig.Android.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"

        resConfigs("en", "ja")
        vectorDrawables.useSupportLibrary = true
    }

    buildFeatures {
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
}

dependencies {
    implementation(project(":komol-timber"))
    implementation(project(":komol-sample:shared"))

    implementation(Deps.Coroutines.core)
    implementation(Deps.Coroutines.android)

    implementation(Deps.Android.core)
    implementation(Deps.Android.appcompat)
    implementation(Deps.Android.materialDesign)

    implementation(Deps.Dagger.hilt)
    "kapt"(Deps.Dagger.compiler)
}