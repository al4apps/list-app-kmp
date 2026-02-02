package com.al4apps.kmp_wizard.root_list

import com.al4apps.kmp_wizard.core.CoroutineFeature
import com.al4apps.kmp_wizard.core.CoroutineFeatureImpl
import com.al4apps.kmp_wizard.core.StateStore
import com.al4apps.kmp_wizard.core.toUiSate
import com.al4apps.kmp_wizard.root_list.map.RootListUiAssembler
import com.al4apps.kmp_wizard.root_list.model.RootListUiState
import com.al4apps.kmp_wizard.root_list.model.RootListVmState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value

class DefaultRootListComponent(
    componentContext: ComponentContext,
    private val onItemClicked: (Int) -> Unit,
    private val initNewList: () -> Unit,
    assembler: RootListUiAssembler = RootListUiAssembler(),
) : RootListComponent, ComponentContext by componentContext,
    CoroutineFeature by CoroutineFeatureImpl(componentContext) {

    private val preservedListState = stateKeeper.consume(
        key = STATE_LIST_KEY,
        strategy = RootListVmState.serializer()
    ) ?: RootListVmState.SAMPLE

    private val vmState = StateStore(preservedListState)
    override val uiState: Value<RootListUiState> = vmState.toUiSate(
        scope = featureScope,
        assemble = assembler::assembleToUi
    )

    init {
        registerStateKeeper()
    }

    override fun onItemClick(id: Int) {

        if (vmState.value.isInSelectionMode) {
            updateStateWithSelectedItem(id)
        } else {
            onItemClicked(id)
        }
    }

    override fun onItemLongClick(id: Int) {
        updateStateWithSelectedItem(id)
    }

    private fun updateStateWithSelectedItem(id: Int) {
        val updated = vmState.value.list.toMutableList()
        updated.apply {
            val index = indexOfFirst { item -> item.id == id }
            if (index >= 0) {
                val item = get(index)
                set(index, item.copy(isSelected = !item.isSelected))
            }
        }
        vmState.updateState { state ->
            state.copy(
                list = updated,
                isInSelectionMode = updated.any { it.isSelected }
            )
        }
    }

    override fun onSelectAllClicked() {
        vmState.updateState { state ->
            val hasAnyUnselected = state.list.any { !it.isSelected }
            state.copy(
                list = state.list.map { it.copy(isSelected = hasAnyUnselected) },
                isInSelectionMode = hasAnyUnselected
            )
        }
    }

    override fun onAddNewListClicked() {
        initNewList()
    }

    private fun registerStateKeeper() {
        stateKeeper.register(
            key = STATE_LIST_KEY,
            strategy = RootListVmState.serializer()
        ) {
            vmState.value
        }
    }

    companion object {
        private const val STATE_LIST_KEY = "state_root_list"
    }
}