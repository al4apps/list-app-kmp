package ru.expasoft.digitalpictureframe.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Black = Color(0xFF363636)
val BeigeDarker = Color(0xFF9C5614)
val BeigeDark = Color(0xFFCB792C)
val Beige = Color(0xFFDA9D64)
val Accent = Color(0xFFC37935)
val Folder = Color(0xFFF5E4B8)
val BeigeLight = Color(0xFFFFE4CA)
val BeigeLighter = Color(0xFFFFF7E9)
val GrayLight = Color(0xFFF7F7F7)
val White = Color(0xFFFFFFFF)
val Gray = Color(0xFFDADADA)
val Gray70 = Color(0x70CBCBCB)
val GrayDark = Color(0xFF999292)
val Success = Color(0xFF30B11C)
val Error = Color(0xFFF85B43)
val BlackLight = Color(0xB3363636)
val Gray64 = Color(0xA3413F3F)
val warning = Color(0xFFFF7768)

@Immutable
data class LAppColors(
    val background: BackgroundColors,
    val button: ButtonColors,
    val text: TextColors,
    val border: BorderColors,
    val icon: IconColors,
) {
    data class BackgroundColors(
        val primary: Color,
        val secondary: Color,
        val default: Color,
        val gray: Color,
        val gray70: Color,
        val blackLight: Color,
        val success: Color,
        val error: Color,
        val folder: Color,
        val gray64: Color,
        val warning: Color
    )

    data class ButtonColors(
        val primary: Color,
        val primaryPush: Color,
        val primaryDisable: Color,
        val secondary: Color,
        val secondaryPush: Color,
        val secondaryDisable: Color,
        val primaryTextColor: Color,
        val primaryDisabledTextColor: Color,
        val secondaryTextColor: Color,
        val secondaryDisabledTextColor: Color,
    )

    data class TextColors(
        val default: Color,
        val primary: Color,
        val secondary: Color,
        val white: Color,
        val accent: Color,
        val disabledSecondary: Color,
        val tertiary: Color
    )

    data class IconColors(
        val black: Color,
        val white: Color,
        val accent: Color,
        val success: Color,
        val error: Color,
        val favorite: Color,
        val grayDark: Color,
    )

    data class BorderColors(
        val secondary: Color,
        val secondaryDisabled: Color,
        val divider: Color,
    )
}

val lAppColors = LAppColors(
    background = LAppColors.BackgroundColors(
        primary = BeigeLight,
        secondary = BeigeLighter,
        default = White,
        gray = GrayLight,
        gray70 = Gray70,
        success = Success,
        error = Error,
        folder = Folder,
        blackLight = BlackLight,
        gray64 = Gray64,
        warning = warning
    ),
    button = LAppColors.ButtonColors(
        primary = Beige,
        primaryPush = BeigeDark,
        primaryDisable = BeigeLight,
        secondary = White,
        secondaryPush = BeigeLighter,
        secondaryDisable = White,
        primaryTextColor = White,
        primaryDisabledTextColor = White,
        secondaryTextColor = BeigeDark,
        secondaryDisabledTextColor = BeigeLight,
    ),
    text = LAppColors.TextColors(
        default = Black,
        primary = BeigeDarker,
        secondary = BeigeDark,
        white = White,
        accent = Accent,
        disabledSecondary = BeigeLight,
        tertiary = GrayDark
    ),
    border = LAppColors.BorderColors(
        secondary = BeigeDark,
        secondaryDisabled = BeigeLight,
        divider = Gray,
    ),
    icon = LAppColors.IconColors(
        black = Black,
        white = White,
        accent = Accent,
        success = Success,
        error = Error,
        favorite = Error,
        grayDark = GrayDark
    )
)

val LocalDPFColors = staticCompositionLocalOf { lAppColors }
