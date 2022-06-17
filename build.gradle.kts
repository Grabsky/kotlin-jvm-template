val buildsDirectory = "${System.getenv("DEVELOPMENT_DIR")}/builds"

group = "just.testing"
version = "1.0-SNAPSHOT"

plugins {
    id("java-library")
    id("application")
    id("org.jetbrains.kotlin.jvm") version "1.7.0"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

application {
    mainClass.set("just.testing.MainKt")
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    // ...
}

dependencies {
    implementation("org.jetbrains.kotlin", "kotlin-stdlib-jdk8", "1.7.0")
    implementation("org.jetbrains.kotlin", "kotlin-reflect", "1.7.0")
    // ...
}

tasks {
    assemble {
        dependsOn(shadowJar)
        doLast {
            // Copying output file to builds directory
            copy {
                from(shadowJar)
                into(buildsDirectory)
                // Renaming output file
                rename(shadowJar.get().archiveFileName.get(), "${rootProject.name}.jar")
            }
        }
    }
    compileKotlin { kotlinOptions.jvmTarget = "16" }
    processResources { filteringCharset = Charsets.UTF_8.name() }
}