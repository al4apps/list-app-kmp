package com.al4apps.kmp_wizard.list.model

import kotlinx.serialization.Serializable


@Serializable
data class ChildListItem(
    val id: Long,
    val title: String,
    val value: ItemValue,
    val icon: ItemIcon = ItemIcon.NONE,
    val subtitle: String? = null,
    val comment: String? = null,
    val isSelected: Boolean = false,
    val markIcon: ItemMark = ItemMark.NONE,
    val isExpandedValues: Boolean = false,
    val isExpandedActions: Boolean = false,
)
