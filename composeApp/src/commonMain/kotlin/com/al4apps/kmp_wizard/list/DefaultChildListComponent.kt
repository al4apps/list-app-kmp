package com.al4apps.kmp_wizard.list

import com.al4apps.kmp_wizard.core.CoroutineFeature
import com.al4apps.kmp_wizard.core.CoroutineFeatureImpl
import com.al4apps.kmp_wizard.core.StateStore
import com.al4apps.kmp_wizard.core.toUiSate
import com.al4apps.kmp_wizard.list.map.ChildListUiAssembler
import com.al4apps.kmp_wizard.list.model.ChildListUiState
import com.al4apps.kmp_wizard.list.model.ChildListVmState
import com.al4apps.kmp_wizard.root_list.domain.ChildListInteractor
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class DefaultChildListComponent(
    componentContext: ComponentContext,
    private val listId: Int,
    private val onBackClick: () -> Unit,
    private val childListInteractor: ChildListInteractor,
    assembler: ChildListUiAssembler = ChildListUiAssembler(),
) : ChildListComponent, ComponentContext by componentContext,
    CoroutineFeature by CoroutineFeatureImpl(componentContext) {

    private val preservedListState =
        stateKeeper.consume(STATE_LIST_KEY, ChildListVmState.serializer())
            ?: ChildListVmState.INITIAL

    private val vmState = StateStore(preservedListState)
    override val uiState: Value<ChildListUiState> =
        vmState.toUiSate(featureScope, assembler::assembleToUi)

    init {
        initState()
        observeInteractorState()
        registerStateKeeper()
    }

    private fun initState() {
        featureScope.launch {
            childListInteractor.initListInfo(listId)
        }
    }

    private fun observeInteractorState() {
        childListInteractor.state.onEach { iState ->
            vmState.updateState { state ->
                state.copy(
                    rootListId = iState.listId,
                    rootListTitle = iState.listTitle,
                    items = iState.items,
                    isLoading = iState.isLoading
                )
            }
        }.launchIn(featureScope)
    }

    override fun onItemLongClicked(id: Long) {
        updateStateWithSelectedItem(id)
    }

    private fun updateStateWithSelectedItem(id: Long) {
        val updated = vmState.value.items.toMutableList()
        updated.apply {
            val index = indexOfFirst { item -> item.id == id }
            if (index >= 0) {
                val item = get(index)
                set(index, item.copy(isSelected = !item.isSelected))
            }
        }
        vmState.updateState { state ->
            state.copy(
                items = updated,
                isInSelectionMode = updated.any { it.isSelected }
            )
        }
    }

    override fun onSelectAllClicked() {
        vmState.updateState { state ->
            val isAnyUnselected = state.items.any { !it.isSelected }
            state.copy(
                items = state.items.map { it.copy(isSelected = isAnyUnselected) },
                isInSelectionMode = isAnyUnselected
            )
        }
    }

    override fun onItemClicked(id: Long) {
        if (vmState.value.isInSelectionMode) {
            updateStateWithSelectedItem(id)
        } else {
            updateStateWithExpandedItem(id)
        }
    }

    private fun updateStateWithExpandedItem(id: Long) {
        val updated = vmState.value.items.toMutableList().apply {
            val index = indexOfFirst { item -> item.id == id }
            if (index >= 0) {
                val item = this[index]
                set(index, item.copy(isExpandedValues = !item.isExpandedValues))
            }
        }
        vmState.updateState { state ->
            state.copy(items = updated)
        }
    }

    override fun onBackClicked() {
        this.onBackClick()
    }

    override fun onItemValueClicked(id: Long) {
        // TODO: add value click handling
    }

    override fun onItemFieldClicked(id: Long, fieldTitle: String) {
        // TODO: add field click handling
    }

    private fun registerStateKeeper() {
        stateKeeper.register(
            STATE_LIST_KEY,
            strategy = ChildListVmState.serializer()
        ) {
            vmState.value
        }
    }

    companion object {
        private const val STATE_LIST_KEY = "state_child_list"
    }
}
