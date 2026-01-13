package com.al4apps.kmp_wizard.list.model

import org.jetbrains.compose.resources.DrawableResource

data class ChildListItemUi(
    val id: Long,
    val title: String,
    val value: String? = null,
    val subtitle: String? = null,
    val comment: String? = null,
    val isSelected: Boolean = false,
    val markIcon: DrawableResource? = null,
    val icon: DrawableResource? = null,
    val isExpandedBottom: Boolean = false,
    val expandableInfo: ExpandableInfo? = null,
) {
    companion object {
        val INITIAL = ChildListItemUi(
            id = 0,
            title = "Title",
            value = "100",
            subtitle = null,
            comment = null,
            isSelected = false,
            markIcon = null,
            icon = null,
            isExpandedBottom = false,
            expandableInfo = null
        )
    }
}
