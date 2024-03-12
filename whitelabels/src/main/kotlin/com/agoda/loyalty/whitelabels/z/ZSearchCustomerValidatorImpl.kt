package com.agoda.loyalty.whitelabels.z

import com.agoda.loyalty.core.models.SearchCustomerRequest
import com.agoda.loyalty.core.validator.SearchCustomerValidator

class ZSearchCustomerValidatorImpl : SearchCustomerValidator {
    override fun validate(searchCustomerRequest: SearchCustomerRequest): Boolean {
        return true
    }
}