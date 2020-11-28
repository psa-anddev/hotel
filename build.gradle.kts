buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.4.10"))
        classpath("com.android.tools.build:gradle:4.0.1")
    }
}

group = "com.psa.hotel"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    google()
    mavenCentral()
}

allprojects {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
}
