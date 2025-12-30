package com.al4apps.kmp_wizard.root.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.al4apps.kmp_wizard.home.ui.HomeScreen
import com.al4apps.kmp_wizard.root.RootComponent
import com.arkivanov.decompose.extensions.compose.stack.Children

@Composable
fun RootScreen(component: RootComponent) {

    Scaffold(
    ) {
        Children(
            stack = component.stack,
            modifier = Modifier
        ) {
            when (val instance = it.instance) {
                is RootComponent.StackChild.Onboarding -> {}
                is RootComponent.StackChild.HomeFeature -> {
                    HomeScreen(instance.component)
                }
            }
        }
    }
}

