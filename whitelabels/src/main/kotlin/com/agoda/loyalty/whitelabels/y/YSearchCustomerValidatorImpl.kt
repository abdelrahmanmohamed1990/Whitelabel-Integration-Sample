package com.agoda.loyalty.whitelabels.y

import com.agoda.loyalty.core.models.SearchCustomerRequest
import com.agoda.loyalty.core.models.SearchCustomerResponse
import com.agoda.loyalty.core.validator.SearchCustomerValidator

class YSearchCustomerValidatorImpl : SearchCustomerValidator {
    override fun validate(searchCustomerRequest: SearchCustomerRequest): Boolean {
        return true
    }
}