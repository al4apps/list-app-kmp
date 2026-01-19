package com.al4apps.kmp_wizard.list.model

import kotlinx.serialization.Serializable


@Serializable
data class ChildListItem(
    val id: Long,
    val title: String,
    val mValue: ItemValue,
    val fields: List<ItemField> = emptyList(),
    val icon: ItemIcon = ItemIcon.NONE,
    val comment: String? = null,
    val isSelected: Boolean = false,
    val isExpandedValues: Boolean = false,
    val isExpandedActions: Boolean = false,
)
