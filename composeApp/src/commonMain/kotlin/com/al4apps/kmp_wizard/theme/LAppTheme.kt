package ru.expasoft.digitalpictureframe.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.al4apps.kmp_wizard.theme.LAppTypography
import com.al4apps.kmp_wizard.theme.LocalTypography
import com.al4apps.kmp_wizard.theme.lappTypography

object LAppTheme {

    val typography: LAppTypography
        @Composable
        get() = LocalTypography().current

    val colors: LAppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalDPFColors.current
}

@Composable
fun LAppTheme(
    content: @Composable () -> Unit
) {
    val typography = lappTypography()
    val local = LocalTypography()
    CompositionLocalProvider(
        local provides typography,
        LocalDPFColors provides lAppColors,
        content = content
    )
}
