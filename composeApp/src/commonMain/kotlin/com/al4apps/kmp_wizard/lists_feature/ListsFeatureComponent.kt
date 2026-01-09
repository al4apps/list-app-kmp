package com.al4apps.kmp_wizard.lists_feature

import com.al4apps.kmp_wizard.list.ChildListComponent
import com.al4apps.kmp_wizard.root_list.RootListComponent
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface ListsFeatureComponent {
    val stack: Value<ChildStack<*, StackChild>>

    sealed class StackChild {
        class List(val component: ChildListComponent): StackChild()
        class RootList(val component: RootListComponent): StackChild()
    }
}