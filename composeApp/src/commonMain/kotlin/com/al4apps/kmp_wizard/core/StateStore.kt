package com.al4apps.kmp_wizard.core

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class StateStore<S>(initialState: S) {

    private val mutableStateFlow = MutableStateFlow(initialState)
    val stateFlow: StateFlow<S> = mutableStateFlow.asStateFlow()

    val value get() = stateFlow.value

    fun updateState(block: (S) -> S) {
        val currentState: S = mutableStateFlow.value
        val updatedState: S = block(currentState)

        mutableStateFlow.update { updatedState }
    }
}
