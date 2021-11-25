object Deps {
    object Plugins {
        const val android = "com.android.tools.build:gradle:7.0.3"
        const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${Dagger.version}"

        object Kotlin {
            internal const val version = "1.6.0"
            const val gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        }
    }

    object Coroutines {
        // Strictly requires `native-mt` version.
        private const val version = "1.6.0-RC"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${version}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Android {
        const val core = "androidx.core:core-ktx:1.7.0"
        const val appcompat = "androidx.appcompat:appcompat:1.4.0"
        const val materialDesign = "com.google.android.material:material:1.4.0"
    }

    object Dagger {
        internal const val version = "2.40.1"
        const val hilt = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"

        object Kotlin {
            const val common = "org.jetbrains.kotlin:kotlin-test-common:${Plugins.Kotlin.version}"
            const val annotationsCommon = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Plugins.Kotlin.version}"
            const val junit = "org.jetbrains.kotlin:kotlin-test-junit:${Plugins.Kotlin.version}"
        }        
    }

    const val timber = "com.jakewharton.timber:timber:5.0.1"
    const val inject = "com.chrynan.inject:inject:1.0.0"

    object Version {
        const val spotless = "5.17.1"
        const val ktlint = "0.43.0"
    }
}