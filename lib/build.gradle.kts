import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ktLint)
    `maven-publish`
}

kotlin {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    applyDefaultHierarchyTemplate() {
        common {
            group("mobile") {
                withIos()
                withAndroidTarget()
            }
        }
    }

    androidTarget {
        publishAllLibraryVariants()
    }
    jvmToolchain(17)

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    jvm("desktop")

    sourceSets {
        androidMain.dependencies {
            implementation(libs.firebase.analytics.ktx)
        }
        commonMain.dependencies {
            implementation(libs.kermit)
            implementation(libs.kwikstart.core)
            implementation(libs.koin.core)
            implementation(libs.kotlin.reflect)
            implementation(libs.kotlin.stdlib.jdk7)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kvault)
            implementation(libs.napier)
        }
        iosMain.dependencies {}
    }
}

android {
    namespace = "com.sheltek.kwikstart.utils"
    compileSdk = libs.versions.compile.sdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.min.sdk.get().toInt()
    }
}

//ktlint {
//    verbose.set(true)
//    outputToConsole.set(true)
//    ignoreFailures.set(true)
//}

group = extra["publishing.group"] as String
version = libs.versions.kwikstart.utils.get()

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/ShelTek/KwikStart-Utils")
            credentials {
                username = System.getenv("REPO_READ_WRITE_USER")
                password = System.getenv("REPO_READ_WRITE_TOKEN")
            }
        }
    }
}
