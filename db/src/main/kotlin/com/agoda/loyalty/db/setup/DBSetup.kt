package com.agoda.loyalty.db.setup

import com.agoda.loyalty.core.repos.WhiteLabelDataRepo
import com.agoda.loyalty.db.repos.WhiteLabelDataRepoImpl
import org.koin.dsl.module

object DBSetup {
    fun dbSetup() = module {
        single<WhiteLabelDataRepo> { WhiteLabelDataRepoImpl() }
    }
}