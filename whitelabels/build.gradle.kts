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
    testImplementation("com.lemonappdev:konsist:0.14.0")
}
val changedModules = System.getenv("CHANGED_MODULES").split(",")
val changedWhiteLabels = changedModules.filter { it != "api" && it != "db" && it != "core" }
tasks.test {
    onlyIf {
        changedWhiteLabels.isNotEmpty()
    }
    filter {
        changedWhiteLabels.forEach {
            includeTestsMatching("com.agoda.loyalty.whitelabels.$it")
        }
        includeTestsMatching("com.agoda.loyalty.ArchitectureTest")
        isFailOnNoMatchingTests = false
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