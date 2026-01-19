package com.al4apps.kmp_wizard.list.model

import org.jetbrains.compose.resources.DrawableResource

data class ChildListItemUi(
    val id: Long,
    val title: String,
    val value: ItemValue,
    val fields: List<ItemField> = emptyList(),
    val comment: String? = null,
    val isSelected: Boolean = false,
    val icon: DrawableResource? = null,
    val isExpandedBottom: Boolean = false,
    val expandableInfo: ExpandableInfo? = null,
) {
    companion object {
        val INITIAL = ChildListItemUi(
            id = 0,
            title = "Title",
            value = TextValue(""),
            comment = null,
            isSelected = false,
            icon = null,
            isExpandedBottom = false,
            expandableInfo = null
        )
    }
}
