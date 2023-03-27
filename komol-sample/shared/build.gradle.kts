plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

version = "1.0.0"

android {
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}

kotlin {
    android()
    ios()

    cocoapods {
        // Configure fields required by CocoaPods.
        summary = "Shared module for the app."
        homepage = "https://github.com/droibit/komol"
        authors = "Shinya Kumagai"
        license = "Apache License, Version 2.0"
        ios.deploymentTarget = "12.0"
        podfile = project.file("../ios/Podfile")

        framework {
            baseName = "Shared"
            export(project(":komol-core"))
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":komol-core"))

                api(libs.kotlin.coroutines.core)
            }
        }
        val androidMain by getting
        val iosMain by getting
    }
}