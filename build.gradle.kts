@file:Suppress("PropertyName")

import com.android.build.gradle.BasePlugin
import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.spotless)
}

val GROUP: String by project
val VERSION_NAME: String by project

subprojects {
    apply(plugin = "com.diffplug.spotless")

    group = GROUP
    version = VERSION_NAME

    spotless {
        kotlin {
            target("**/*.kt")
            targetExclude("$buildDir/**/*.kt")
            targetExclude("**/generated/**/*.kt")
            ktlint(libs.versions.ktlint.get())
        }
        isEnforceCheck = false
    }

    plugins.whenPluginAdded {
        if (this is BasePlugin) {
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
            jvmTarget = "1.8"
        }
    }
}