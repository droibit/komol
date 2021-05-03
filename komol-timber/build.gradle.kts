plugins {
    id("com.android.library")
    id("kotlin-android")
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
}

dependencies {
    api(project(":komol"))
    api(Deps.timber)
}