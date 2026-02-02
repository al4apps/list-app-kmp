package com.al4apps.kmp_wizard.list.model

data class ChildListState(
    val listId: Int,
    val listTitle: String,
    val items: List<ChildListItem>,
    val isLoading: Boolean,
) {
    companion object {
        val INITIAL = ChildListState(
            listId = 0,
            listTitle = "",
            items = emptyList(),
            isLoading = false
        )
    }
}
