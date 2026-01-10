package com.al4apps.kmp_wizard

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.backhandler.BackDispatcher
import com.arkivanov.essenty.lifecycle.LifecycleRegistry

fun MainViewController() = ComposeUIViewController {
    val lifecycleRegistry = LifecycleRegistry()
    val backDispatcher = BackDispatcher()
    val componentContext = DefaultComponentContext(lifecycleRegistry, backHandler = backDispatcher)
    val appSettings: AppSettings = AppSettingsFactory().create()
    App(componentContext, appSettings = appSettings)
}
