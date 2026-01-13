package com.al4apps.kmp_wizard.list.model

import kotlinx.serialization.Serializable

@Serializable
sealed class ItemValue

@Serializable
data class NumberValue(val number: Double) : ItemValue()
@Serializable
data class StringValue(val text: String) : ItemValue()