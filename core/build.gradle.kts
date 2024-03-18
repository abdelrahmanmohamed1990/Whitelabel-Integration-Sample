import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm")
}

group = "com.agoda"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
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