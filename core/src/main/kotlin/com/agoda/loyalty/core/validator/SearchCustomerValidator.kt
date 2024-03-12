package com.agoda.loyalty.core.validator

import com.agoda.loyalty.core.models.SearchCustomerRequest

interface SearchCustomerValidator {
    fun validate(searchCustomerRequest: SearchCustomerRequest): Boolean
}