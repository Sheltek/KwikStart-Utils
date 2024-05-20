plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ktLint)
    `maven-publish`
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget {
        publishAllLibraryVariants()
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    jvm("desktop")
    task("testClasses")

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        androidMain.dependencies {
            implementation(libs.firebase.analytics.ktx)
        }
        commonMain.dependencies {
            // Kotlin
            implementation(libs.kotlin.reflect)
            implementation(libs.kotlin.stdlib.jdk7)

            // KotlinX
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.serialization.json)

            // TODO - Look at removing Koin from library
            // Koin
            implementation(libs.koin.core)

            // Launchpad
            implementation(libs.kmp.launchpad.utils.domain)

            // Logging
            implementation(libs.kermit)
            implementation(libs.napier)
        }
        iosMain.dependencies {}
    }
}

android {
    namespace = "com.bottlerocketstudios.launchpad.utils"
    compileSdk = libs.versions.compile.sdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.min.sdk.get().toInt()
    }
}

ktlint {
    verbose.set(true)
    outputToConsole.set(true)
    ignoreFailures.set(true)
}

group = extra["publishing.group"] as String
version = libs.versions.launchpad.utils.get()

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/BottleRocketStudios/KMP-LaunchPad-Utils")
            credentials {
                username = System.getenv("REPO_READ_WRITE_USER") ?: System.getenv("GH_PUBLISH_USERNAME")
                password = System.getenv("REPO_READ_WRITE_TOKEN") ?: System.getenv("GH_PUBLISH_PASSWORD")
            }
        }
    }
}
