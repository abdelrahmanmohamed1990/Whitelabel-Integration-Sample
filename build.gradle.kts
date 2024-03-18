import org.gradle.api.tasks.testing.logging.TestExceptionFormat

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koin_version: String by project

plugins {
    kotlin("jvm") version "1.9.23"
    id("io.ktor.plugin") version "2.3.9"
}

group = "agoda.com"
version = "0.0.1"

application {
    mainClass.set("agoda.com.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(project(":core"))
    implementation(project(":db"))
    implementation(project(":api"))
    implementation(project(":whitelabels"))
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-serialization-gson-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    implementation(platform("io.insert-koin:koin-bom:$koin_version"))
    // Koin for Ktor
    implementation("io.insert-koin:koin-ktor")
    // SLF4J Logger
    implementation("io.insert-koin:koin-logger-slf4j")
    implementation("io.insert-koin:koin-core")
}

val changedModules = System.getenv("CHANGED_MODULES").split(",")
tasks.test {
    useJUnitPlatform {}
    onlyIf {
        changedModules.contains("src")
    }
    testLogging {
        events("skipped", "failed", "passed")
        showStackTraces = true
        exceptionFormat = TestExceptionFormat.FULL
    }
}