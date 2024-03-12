package com.agoda.server.setup

import com.agoda.loyalty.db.setup.DBSetup
import com.agoda.loyalty.whitelabels.x.WhiteLabelXSetup
import com.agoda.loyalty.whitelabels.y.WhiteLabelYSetup
import com.agoda.loyalty.whitelabels.z.WhitelabelZSetup
import org.koin.core.KoinApplication
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

object ServerSetup {
    fun appContext():List<Module> {
        val sharedModules = listOf(DBSetup.dbSetup())
        val parentModule = module {
            single<KoinApplication>(named("51")) {
                WhiteLabelXSetup.setup(sharedModules)
            }
            single<KoinApplication>(named("52")) {
                WhiteLabelYSetup.setup(sharedModules)
            }
            single<KoinApplication>(named("53")) {
                WhitelabelZSetup.setup(sharedModules)
            }
        }
        return sharedModules.plus(parentModule)
    }
}