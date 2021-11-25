import java.net.URI

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("maven-publish")
}

group = LibraryConfig.group
version = LibraryConfig.version

android {
    compileSdk = LibraryConfig.Android.compileSdk

    defaultConfig {
        minSdk = LibraryConfig.Android.minSdk
        targetSdk = LibraryConfig.Android.targetSdk

        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        buildConfig = false
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
        publishAllLibraryVariants()
    }
    ios() {
        binaries {
            framework {
                baseName = "Komol"
            }
        }
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
    repositories {
        maven {
            url = URI("https://repo.repsy.io/mvn/droibit/public")
            credentials {
                username = "${project.findProperty("repsy.username")}"
                password = "${project.findProperty("repsy.password")}"
            }
        }
    }

    publications {
        publications.withType<MavenPublication> {
            pom {
                licenses {
                    license {
                        name.set(LibraryConfig.License.name)
                        url.set(LibraryConfig.License.url)
                        distribution.set(LibraryConfig.License.distribution)
                    }
                }
            }
        }
    }
}