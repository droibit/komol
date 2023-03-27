import java.net.URI

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("maven-publish")
}

group = LibraryConfig.group
version = LibraryConfig.version

android {
    namespace = "com.github.droibit.komol"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()

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
    ios()
    iosSimulatorArm64()
    watchos()
    watchosSimulatorArm64()

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test.common)
                implementation(libs.kotlin.test.annotation.common)
            }
        }
        val androidMain by getting
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.junit)
                implementation(libs.kotlin.test.junit)
            }
        }

        val darwinMain by creating {
            dependsOn(commonMain)
        }

        targets.withType<KotlinNativeTarget>().all {
            if (konanTarget.family.isAppleFamily) {
                compilations["main"].defaultSourceSet {
                    dependsOn(darwinMain)
                }
            }
        }
    }
}

publishing {
    repositories {
        maven {
            url = uri("https://repo.repsy.io/mvn/droibit/public")
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