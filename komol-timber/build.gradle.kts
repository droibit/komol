import java.net.URI

plugins {
    id("com.android.library")
    id("kotlin-android")
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
                            name.set(Komol.License.name)
                            url.set(Komol.License.url)
                            distribution.set(Komol.License.distribution)
                        }
                    }
                }
            }
        }
    }
}