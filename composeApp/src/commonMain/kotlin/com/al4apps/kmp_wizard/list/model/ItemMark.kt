package com.al4apps.kmp_wizard.list.model

import kmpwizardproject.composeapp.generated.resources.Res
import kmpwizardproject.composeapp.generated.resources.ic_check
import kmpwizardproject.composeapp.generated.resources.ic_close
import kmpwizardproject.composeapp.generated.resources.ic_cloudy
import kmpwizardproject.composeapp.generated.resources.ic_favorite_selected
import kmpwizardproject.composeapp.generated.resources.ic_minus
import org.jetbrains.compose.resources.DrawableResource

enum class ItemMark(val drawableRes: DrawableResource) {
    NONE(drawableRes = Res.drawable.ic_close),
    CHECKED(drawableRes = Res.drawable.ic_check),
    STAR(drawableRes = Res.drawable.ic_cloudy),
    LIKE(drawableRes = Res.drawable.ic_favorite_selected),
    BRICK(drawableRes = Res.drawable.ic_minus)
}