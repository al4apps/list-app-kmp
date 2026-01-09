package com.al4apps.kmp_wizard.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.al4apps.kmp_wizard.design_system.LAppTopBar
import com.al4apps.kmp_wizard.home.HomeComponent
import com.al4apps.kmp_wizard.lists_feature.ui.ListsFeatureScreen
import com.arkivanov.decompose.extensions.compose.stack.Children

@Composable
fun HomeScreen(component: HomeComponent) {

    Scaffold(
        modifier = Modifier.fillMaxSize().background(Color.Gray),
        topBar = { LAppTopBar(component.uiState.topBarUiState, onBackClick = {}) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Children(component.stack) { child ->

                when (val instance = child.instance) {

                    is HomeComponent.HomeStackChild.ListsFeature -> {
                        ListsFeatureScreen(instance.component)
                    }

                }
            }
        }
    }
}