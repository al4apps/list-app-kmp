package com.al4apps.kmp_wizard.list.model

import org.jetbrains.compose.resources.DrawableResource

sealed class ExpandableInfo

object ExpandableFields : ExpandableInfo()

data class ExpandableIcons(
    val icon1: DrawableResource,
    val icon2: DrawableResource,
    val icon3: DrawableResource,
    val icon4: DrawableResource,
) : ExpandableInfo()

data class ExpandableText(
    val text1: String,
    val text2: String,
    val text3: String,
    val text4: String,
) : ExpandableInfo()

data class ExpandableActions(
    val actions: List<ItemAction>
) : ExpandableInfo()

enum class ItemAction {
    REMOVE, EDIT, DETAIL, HISTORY
}
