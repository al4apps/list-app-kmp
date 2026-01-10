package com.al4apps.kmp_wizard

import androidx.compose.runtime.Composable
import com.al4apps.kmp_wizard.root.DefaultRootComponent
import com.al4apps.kmp_wizard.root.ui.RootScreen
import com.arkivanov.decompose.ComponentContext
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.expasoft.digitalpictureframe.theme.LAppTheme


@Composable
@Preview
fun App(componentContext: ComponentContext, appSettings: AppSettings) {
    LAppTheme {
        RootScreen(DefaultRootComponent(componentContext, appSettings))
    }
}