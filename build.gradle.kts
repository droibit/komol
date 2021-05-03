import com.android.build.gradle.AppPlugin
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.DynamicFeaturePlugin
import com.android.build.gradle.LibraryPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Deps.Plugins.Kotlin.gradle)
        classpath(Deps.Plugins.android)
    }
}

plugins {
    id("com.diffplug.spotless") version Deps.Plugins.Spotless.version
}

subprojects {
    repositories {
        google()
        mavenCentral()
    }

    apply(plugin = "com.diffplug.spotless")

    spotless {
        kotlin {
            target("**/*.kt")
            targetExclude("$buildDir/**/*.kt")
            targetExclude("**/generated/**/*.kt")
            ktlint(Deps.Version.ktlint)
                .userData(
                    mapOf(
                        "android" to "true",
                        "experimental" to "true"
                    )
                )

        }
    }

    plugins.whenPluginAdded {
        if (this is AppPlugin || this is LibraryPlugin || this is DynamicFeaturePlugin) {
            project.extensions.getByType<BaseExtension>().apply {
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
            }
        }
    }

    tasks.withType(KotlinCompile::class.java) {
        kotlinOptions {
            useIR = true
            jvmTarget = "1.8"
            freeCompilerArgs = listOf(
                "-Xinline-classes",
                "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xopt-in=kotlin.ExperimentalMultiplatform"
            )
        }
    }
}