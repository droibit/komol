import org.gradle.api.publish.PublishingExtension

apply(plugin = "maven-publish")

val POM_URL: String by project
val POM_LICENCE_NAME: String by project
val POM_LICENCE_URL: String by project
val POM_LICENCE_DIST: String by project

if (plugins.hasPlugin("org.jetbrains.kotlin.multiplatform")) {
    configure<PublishingExtension> {
        repositories {
            maven {
                url = uri(POM_URL)
                credentials {
                    username = "${project.findProperty("repsy.username")}"
                    password = "${project.findProperty("repsy.password")}"
                }
            }
        }

        publications {
            publications.withType<MavenPublication> {
                pom {
                    licenses {
                        license {
                            name.set(POM_LICENCE_NAME)
                            url.set(POM_LICENCE_URL)
                            distribution.set(POM_LICENCE_DIST)
                        }
                    }
                }
            }
        }
    }
} else {
    afterEvaluate {
        configure<PublishingExtension> {
            repositories {
                maven {
                    url = uri(POM_URL)
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
                                name.set(POM_LICENCE_NAME)
                                url.set(POM_LICENCE_URL)
                                distribution.set(POM_LICENCE_DIST)
                            }
                        }
                    }
                }
            }
        }
    }
}