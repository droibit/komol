plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

version = "1.0.0"

android {
    compileSdkVersion(BuildConfig.compileSdkVersion)

    defaultConfig {
        minSdkVersion(BuildConfig.minSdkVersion)
        targetSdkVersion(BuildConfig.targetSdkVersion)
        versionCode = 1
        versionName = "${project.version}"

        resConfigs("en", "ja")
        consumerProguardFiles("consumer-rules.pro")
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

    // Workaround for https://youtrack.jetbrains.com/issue/KT-43944
    configurations {
        create("androidTestApi")
        create("androidTestDebugApi")
        create("androidTestReleaseApi")
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}

kotlin {
    android()
    ios()

    cocoapods {
        // Configure fields required by CocoaPods.
        summary = "Shared module for the app."
        homepage = "https://github.com/droibit/kotlin-multiplatform-mobile-sample"
        authors = "Shinya Kumagai"
        license = "Apache License, Version 2.0"
        frameworkName = "Shared"

        ios.deploymentTarget = "14.0"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Deps.Coroutines.core)
                implementation(Deps.Stately.common)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(Deps.Test.Kotlin.common)
                implementation(Deps.Test.Kotlin.annotationsCommon)
            }
        }
        val androidMain by getting {
            dependencies {
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(Deps.Test.junit)
            }
        }
        val iosMain by getting
        val iosTest by getting
    }
}
