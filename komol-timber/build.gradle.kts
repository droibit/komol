plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "com.github.droibit.komol.timber"
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
}

dependencies {
    api(project(":komol-core"))
    api(libs.timber)
}

apply(from = "$rootDir/gradle/gradle-mvn-mpp-push.gradle.kts")