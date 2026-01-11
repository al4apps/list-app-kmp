package com.al4apps.kmp_wizard.core

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.coroutines.CoroutineContext

fun <VM : Any, UI : Any> StateStore<VM>.toUiSate(
    scope: CoroutineScope,
    assemble: (VM) -> UI,
): Value<UI> {
    val mutableValue = MutableValue(assemble(value))
    stateFlow.onEach { vm -> mutableValue.value = assemble(vm) }.launchIn(scope)
    return mutableValue
}

fun LifecycleOwner.coroutineScope(context: CoroutineContext): CoroutineScope {
    return CoroutineScope(context, lifecycle)
}