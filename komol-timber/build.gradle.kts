import java.net.URI

plugins {
    id("com.android.library")
    id("kotlin-android")
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
}

dependencies {
    api(project(":komol-core"))
    api(Deps.timber)
}

afterEvaluate {
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
            create<MavenPublication>("release") {
                from(components.getByName("release"))

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
}