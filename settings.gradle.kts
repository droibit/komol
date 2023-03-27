pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
dependencyResolutionManagement {
    // ref. https://github.com/realm/realm-java/issues/7374#issuecomment-809267410
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://repo.repsy.io/mvn/chrynan/public") }
    }
}

include(
    ":komol-core",
    ":komol-timber",
    ":komol-sample:android",
    ":komol-sample:shared"
)
