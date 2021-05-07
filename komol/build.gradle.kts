plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("maven-publish")
}

group = Komol.group
version = Komol.versionName

android {
    compileSdkVersion(Komol.Config.compileSdkVersion)

    defaultConfig {
        minSdkVersion(Komol.Config.minSdkVersion)
        targetSdkVersion(Komol.Config.targetSdkVersion)
        versionCode = Komol.versionCode
        versionName = "${project.version}"
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
    android {
        publishLibraryVariants("release")
    }
    ios()

    cocoapods {
        // Configure fields required by CocoaPods.
        summary = "A simple logger for Kotlin Multiplatform Mobile."
        homepage = "https://github.com/droibit/komol"
        authors = "Shinya Kumagai"
        license = "Apache License, Version 2.0"
        frameworkName = "Komol"

        ios.deploymentTarget = "12.0"
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(Deps.Test.Kotlin.common)
                implementation(Deps.Test.Kotlin.annotationsCommon)
            }
        }
        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation(Deps.Test.junit)
                implementation(Deps.Test.Kotlin.junit)
            }
        }
        val iosMain by getting
        val iosTest by getting
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            pom {
                licenses {
                    license {
                        name.set(Komol.License.name)
                        url.set(Komol.License.url)
                    }
                }
            }
        }
    }
}