package com.agoda.loyalty.whitelabels.x

import com.agoda.loyalty.core.models.SearchCustomerRequest
import com.agoda.loyalty.core.validator.SearchCustomerValidator

class XSearchCustomerValidatorImpl : SearchCustomerValidator {
    override fun validate(searchCustomerRequest: SearchCustomerRequest): Boolean {
        return true
    }
}