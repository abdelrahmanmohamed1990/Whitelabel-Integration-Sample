package com.agoda.loyalty.api


import com.agoda.loyalty.core.handler.SearchCustomerHandler
import com.agoda.loyalty.core.models.SearchCustomerRequest
import com.agoda.loyalty.core.models.SearchCustomerResponse
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import org.koin.core.KoinApplication
import org.koin.core.qualifier.qualifier

fun Routing.loyaltyRoutes(parentApp: KoinApplication) {
    route("customer/") {
        post("search") {
            val whiteLabelId =
                call.request.headers.get("whitelabel-id") ?: throw Exception("Bad Request missing whitelabel header")
            val subContextInjector = parentApp.koin.get<KoinApplication>(qualifier(whiteLabelId)).koin
            val searchCustomerHandler = subContextInjector.get<SearchCustomerHandler>()
            call.receive<SearchCustomerRequest>().let { request ->
                call.respond(
                    HttpStatusCode.OK,
                    searchCustomerHandler.handle(request)
                )
            }
        }
    }
} // TEST