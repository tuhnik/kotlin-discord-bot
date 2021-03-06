import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.serialization") version "1.5.0"
}

group = "me.user"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit"))
    implementation("dev.kord:kord-core:0.7.0-RC3")
    implementation("io.github.cdimascio:dotenv-kotlin:6.2.2")
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.8")
    implementation("org.reflections:reflections:0.9.12")
    implementation("com.github.kittinunf.fuel:fuel:2.3.1")
    implementation("org.slf4j:slf4j-log4j12:1.7.30")
}

tasks.test {
    useJUnit()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

