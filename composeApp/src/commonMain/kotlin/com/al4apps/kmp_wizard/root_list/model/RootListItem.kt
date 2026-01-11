package com.al4apps.kmp_wizard.root_list.model

import kotlinx.serialization.Serializable

@Serializable
data class RootListItem(
    val id: Int,
    val title: String,
    val isSelected: Boolean,
    val date: String,
)