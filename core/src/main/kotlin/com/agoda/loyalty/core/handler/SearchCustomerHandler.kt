package com.agoda.loyalty.core.handler

import com.agoda.loyalty.core.models.SearchCustomerRequest
import com.agoda.loyalty.core.models.SearchCustomerResponse
import com.agoda.loyalty.core.validator.SearchCustomerValidator

abstract class SearchCustomerHandler(private val validator: SearchCustomerValidator) {
    fun handle(searchCustomerRequest: SearchCustomerRequest): SearchCustomerResponse {
        validator.validate(searchCustomerRequest)
        return process(searchCustomerRequest)
    }

    protected abstract fun process(searchCustomerRequest: SearchCustomerRequest): SearchCustomerResponse
}