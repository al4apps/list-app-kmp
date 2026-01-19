package com.al4apps.kmp_wizard.list.model

import kotlinx.serialization.Serializable

@Serializable
sealed class ItemValue

@Serializable
data class NumberValue(val number: Long, val scale: Int = 0) : ItemValue() {
    fun toNumString(): String {
        val prefix = when {
            number > 0L -> "+"
            number == 0L -> "-"
            else -> ""
        }
        val sNum = number.toString()
        val aPoint = sNum.takeLast(scale)
        val bPoint = sNum.take(sNum.length - scale)
        return if (aPoint.isNotEmpty()) "$prefix$bPoint.$aPoint"
        else "$prefix$bPoint"
    }
}

@Serializable
data class TextValue(val text: String) : ItemValue()

@Serializable
data class IconValue(val icon: ItemMark) : ItemValue()