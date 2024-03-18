import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm")
}

group = "com.agoda"
version = "0.0.1"
val koin_version: String by project

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation(platform("io.insert-koin:koin-bom:$koin_version"))
    implementation("io.insert-koin:koin-core")
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