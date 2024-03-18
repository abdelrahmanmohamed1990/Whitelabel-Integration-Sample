import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm")
    id("io.ktor.plugin")
}
group = "com.agoda"
version = "0.0.1"

repositories {
    mavenCentral()
}
val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koin_version: String by project

dependencies {
    implementation(project(":core"))
    implementation(platform("io.insert-koin:koin-bom:$koin_version"))
    implementation("io.insert-koin:koin-core")
    implementation("io.insert-koin:koin-ktor")
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-serialization-gson-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

val changedModules = System.getenv("CHANGED_MODULES").split(",")
tasks.test {
    useJUnitPlatform {}
    onlyIf {
        changedModules.contains(project.name)
    }
    testLogging {
        events("skipped", "failed", "passed")
        showStackTraces = true
        exceptionFormat = TestExceptionFormat.FULL
    }
}
kotlin {
    jvmToolchain(11)
}