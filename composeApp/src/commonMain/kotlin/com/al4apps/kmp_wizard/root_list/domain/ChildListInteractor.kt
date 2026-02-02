package com.al4apps.kmp_wizard.root_list.domain

import com.al4apps.kmp_wizard.core.GlobalConstants
import com.al4apps.kmp_wizard.core.StateStore
import com.al4apps.kmp_wizard.list.model.ChildListState
import com.al4apps.kmp_wizard.root_list.model.RootListItem
import com.al4apps.kmp_wizard.utils.childListItemsSampleNumbers

class ChildListInteractor {

    private val stateStore = StateStore(ChildListState.INITIAL)
    val state = stateStore.stateFlow

    suspend fun addNewList(list: RootListItem) {

    }

    suspend fun initListInfo(id: Int) {
        if (id == GlobalConstants.NEW_LIST_ID) {
            stateStore.updateState { state ->
                state.copy(
                    listId = id,
                    listTitle = "New list",
                    items = emptyList(),
                    isLoading = false
                )
            }
        } else {
            stateStore.updateState { state ->
                state.copy(
                    listId = id,
                    listTitle = "List 22",
                    items = childListItemsSampleNumbers,
                    isLoading = false
                )
            }
        }
    }
}