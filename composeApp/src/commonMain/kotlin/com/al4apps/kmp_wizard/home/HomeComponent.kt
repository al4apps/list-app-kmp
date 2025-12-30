package com.al4apps.kmp_wizard.home

import com.al4apps.kmp_wizard.home.model.HomeUiState
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface HomeComponent {

    val stack: Value<ChildStack<*, HomeStackChild>>
    val uiState: HomeUiState

    sealed class HomeStackChild {
        class RootList : HomeStackChild()
        class ListFeature : HomeStackChild()
    }
}