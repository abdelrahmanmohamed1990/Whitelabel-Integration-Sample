package com.agoda.loyalty.whitelabels.x

import com.agoda.loyalty.core.handler.SearchCustomerHandler
import com.agoda.loyalty.core.models.SearchCustomerRequest
import com.agoda.loyalty.core.models.SearchCustomerResponse
import com.agoda.loyalty.core.validator.SearchCustomerValidator

class XSearchCustomerHandlerImpl(validator: SearchCustomerValidator) : SearchCustomerHandler(validator) {
    override fun process(searchCustomerRequest: SearchCustomerRequest): SearchCustomerResponse {
        // Call Third Party Api and map it
        return SearchCustomerResponse("X", "Customer", 10)
    }
} // Test