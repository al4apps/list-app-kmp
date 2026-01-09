package com.al4apps.kmp_wizard.lists_feature.ui

import androidx.compose.runtime.Composable
import com.al4apps.kmp_wizard.list.ui.ListScreen
import com.al4apps.kmp_wizard.lists_feature.ListsFeatureComponent
import com.al4apps.kmp_wizard.root_list.ui.RootListScreen
import com.arkivanov.decompose.extensions.compose.stack.Children

@Composable
fun ListsFeatureScreen(component: ListsFeatureComponent) {
    Children(component.stack) {
        when (val instance = it.instance) {
            is ListsFeatureComponent.StackChild.List -> ListScreen(instance.component)
            is ListsFeatureComponent.StackChild.RootList -> RootListScreen(instance.component)
        }
    }
}