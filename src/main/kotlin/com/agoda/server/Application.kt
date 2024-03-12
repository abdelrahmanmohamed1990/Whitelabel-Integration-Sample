package com.agoda.server

import com.agoda.loyalty.api.loyaltyRoutes
import com.agoda.server.setup.ServerSetup
import io.ktor.serialization.gson.gson
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.routing.routing
import org.koin.ktor.plugin.Koin

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        gson {
        }
    }
    install(Koin) {
        val app = modules(ServerSetup.appContext())
        routing {
            loyaltyRoutes(app)
        }
        app
    }
}
