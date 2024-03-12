package com.agoda.loyalty.whitelabels.z

import com.agoda.loyalty.core.handler.SearchCustomerHandler
import com.agoda.loyalty.core.models.SearchCustomerRequest
import com.agoda.loyalty.core.models.SearchCustomerResponse
import com.agoda.loyalty.core.validator.SearchCustomerValidator

class ZSearchCustomerHandlerImpl(validator: SearchCustomerValidator) : SearchCustomerHandler(validator) {
    override fun process(searchCustomerRequest: SearchCustomerRequest): SearchCustomerResponse {
        // Call Third Party Api and map it
        return SearchCustomerResponse("Z", "Customer", 30)
    }
}