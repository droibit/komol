object Deps {
    object Plugins {
        const val android = "com.android.tools.build:gradle:4.1.3"

        object Kotlin {
            internal const val version = "1.4.32"
            const val gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        }
    }

    object Test {
        const val junit = "junit:junit:4.13.1"

        object Kotlin {
            const val common = "org.jetbrains.kotlin:kotlin-test-common:${Plugins.Kotlin.version}"
            const val annotationsCommon = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Plugins.Kotlin.version}"
        }        
    }

    const val timber = "com.jakewharton.timber:timber:4.7.1"

    object Version {
        const val spotless = "5.10.1"
        const val ktlint = "0.40.0"
    }
}