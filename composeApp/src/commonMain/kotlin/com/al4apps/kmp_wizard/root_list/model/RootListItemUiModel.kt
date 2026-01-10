package com.al4apps.kmp_wizard.root_list.model

data class RootListItemUiModel(
    val id: Int,
    val title: String,
    val date: String,
    val isSelected: Boolean
) {
    companion object Companion {
        val INITIAL = RootListItemUiModel(
            0,
            "List 1",
            "01.01.2026",
            false
        )
    }
}
