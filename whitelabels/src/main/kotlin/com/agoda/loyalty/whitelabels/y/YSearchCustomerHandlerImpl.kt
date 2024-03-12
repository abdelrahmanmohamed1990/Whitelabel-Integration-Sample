package com.agoda.loyalty.whitelabels.y

import com.agoda.loyalty.core.handler.SearchCustomerHandler
import com.agoda.loyalty.core.models.SearchCustomerRequest
import com.agoda.loyalty.core.models.SearchCustomerResponse
import com.agoda.loyalty.core.validator.SearchCustomerValidator

class YSearchCustomerHandlerImpl(validator: SearchCustomerValidator) : SearchCustomerHandler(validator) {
    override fun process(searchCustomerRequest: SearchCustomerRequest): SearchCustomerResponse {
        // Call Third Party Api and map it
        return SearchCustomerResponse("Y", "Customer", 20)
    }
}