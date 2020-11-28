import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    jvm("server") {
        val main by compilations.getting {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }

    }
    android()
    js().browser {
        testTask {
            useKarma {
                useChromeHeadless()
            }
        }
    }
    ios()

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val serverTest by getting {
            dependencies {
                implementation("io.cucumber:cucumber-java8:6.9.0")
                implementation("io.cucumber:cucumber-junit:6.9.0")
                implementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
                implementation("org.junit.jupiter:junit-jupiter-params:5.4.2")

                runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
            }
        }

        val androidTest by getting {
            dependencies {
                implementation("io.cucumber:cucumber-java8:6.9.0")
                implementation("io.cucumber:cucumber-junit:6.9.0")
                implementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
                implementation("org.junit.jupiter:junit-jupiter-params:5.4.2")

                runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(npm("cucumber", "6"))
                implementation(npm("karma-cucumber-js-latest", "1.0.5"))
            }
        }
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}
