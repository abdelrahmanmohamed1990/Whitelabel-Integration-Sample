package com.agoda.loyalty.whitelabels.x

import com.agoda.loyalty.core.handler.SearchCustomerHandler
import com.agoda.loyalty.core.validator.SearchCustomerValidator
import org.koin.core.KoinApplication
import org.koin.core.module.Module
import org.koin.dsl.koinApplication
import org.koin.dsl.module

object WhiteLabelXSetup {
    fun setup(sharedModules: List<Module>): KoinApplication {
        val xAppContext = module {
            single<SearchCustomerValidator> { XSearchCustomerValidatorImpl() }
            single<SearchCustomerHandler> { XSearchCustomerHandlerImpl(get()) }
        }
        val appModules = sharedModules.plus(xAppContext)
        return koinApplication {
            modules(appModules)
        }
    }
} // Test