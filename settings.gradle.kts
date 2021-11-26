pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

include(
    ":komol-core",
    ":komol-timber",
    ":komol-sample:android",
    ":komol-sample:shared"
)
