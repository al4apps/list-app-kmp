package com.al4apps.kmp_wizard.list.model

import kotlinx.serialization.Serializable

@Serializable
data class ItemField(
    val title: String,
    val value: ItemValue
)
