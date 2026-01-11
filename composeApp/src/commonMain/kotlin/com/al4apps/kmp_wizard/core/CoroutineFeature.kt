package com.al4apps.kmp_wizard.core

import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

interface CoroutineFeature {
    val featureScope: CoroutineScope

    fun <T> FlowCollector<T>.launchEmit(value: T) {
        featureScope.launch { emit(value) }
    }
}

class CoroutineFeatureImpl(lifecycleOwner: LifecycleOwner) : CoroutineFeature {
    override val featureScope: CoroutineScope =
        lifecycleOwner.coroutineScope(Dispatchers.Main.immediate + SupervisorJob())
}

fun CoroutineScope(context: CoroutineContext, lifecycle: Lifecycle): CoroutineScope {
    val scope = CoroutineScope(context)
    lifecycle.doOnDestroy(scope::cancel)
    return scope
}
