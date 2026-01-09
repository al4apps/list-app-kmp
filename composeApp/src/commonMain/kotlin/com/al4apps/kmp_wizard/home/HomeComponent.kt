package com.al4apps.kmp_wizard.home

import com.al4apps.kmp_wizard.home.model.HomeUiState
import com.al4apps.kmp_wizard.lists_feature.ListsFeatureComponent
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface HomeComponent {

    val stack: Value<ChildStack<*, HomeStackChild>>
    val uiState: HomeUiState

    sealed class HomeStackChild {
        class ListsFeature(val component: ListsFeatureComponent) : HomeStackChild()
    }
}