plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "Whitelabel-Integration-Sample"
include("db")
include("core")
include("whitelabels")
include("api")
include("server")
