package com.agoda.loyalty

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import com.lemonappdev.konsist.api.ext.list.withPackage
import com.lemonappdev.konsist.api.verify.assertFalse
import kotlin.test.Test

class ArchitectureTest {
    @Test
    fun testingAppArchitecture() {
        Konsist
            .scopeFromProject().assertArchitecture {
                val core = Layer("Core", "com.agoda.loyalty.core..")
                val api = Layer("Presentation", "com.agoda.loyalty.api..")
                val data = Layer("Data", "com.agoda.loyalty.db..")
                val whitelabels = Layer("Whitelabels", "com.agoda.loyalty.whitelabels..")

                // Define architecture assertions
                core.dependsOnNothing()
                api.dependsOn(core)
                data.dependsOn(core)
                whitelabels.dependsOn(core)
            }
    }

    @Test
    fun whitelabelsIsolationTest() {
        val whitelabelPackages =
            Konsist.scopeFromProject()
                .packages
                .filter { it.fullyQualifiedName.contains("com.agoda.loyalty.whitelabels.") }
                .groupBy { it.fullyQualifiedName }.keys.toList()
        whitelabelPackages.forEach { current ->
            val otherWhiteLabelsPackages = whitelabelPackages.filter { it != current }.map { "${it}.." }
            val currentWhiteLabel = Konsist
                .scopeFromProject()
                .files
                .withPackage("${current}..")

            otherWhiteLabelsPackages.forEach { otherWhiteLabelsPackage ->
                currentWhiteLabel.assertFalse { currentWhiteLabelRule ->
                    currentWhiteLabelRule.hasImportWithName(otherWhiteLabelsPackage)
                }
            }
        }
    }
}