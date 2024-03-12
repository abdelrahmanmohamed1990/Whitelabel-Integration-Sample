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

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}