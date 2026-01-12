package com.al4apps.kmp_wizard.lists_feature

import com.al4apps.kmp_wizard.list.DefaultChildListComponent
import com.al4apps.kmp_wizard.root_list.DefaultRootListComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

class DefaultListsFeatureComponent(
    componentContext: ComponentContext,
) : ListsFeatureComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<NavConfig>()
    override val stack: Value<ChildStack<*, ListsFeatureComponent.StackChild>> = childStack(
        source = navigation,
        serializer = NavConfig.serializer(),
        initialConfiguration = NavConfig.RootList,
        handleBackButton = true,
        childFactory = ::createChild
    )

    @OptIn(DelicateDecomposeApi::class)
    private fun createChild(
        config: NavConfig,
        componentContext: ComponentContext
    ): ListsFeatureComponent.StackChild {
        return when (config) {

            is NavConfig.RootList -> ListsFeatureComponent.StackChild.RootList(
                DefaultRootListComponent(componentContext, onItemClicked = {
                    navigation.push(NavConfig.List)
                })
            )

            is NavConfig.List -> ListsFeatureComponent.StackChild.List(
                DefaultChildListComponent(componentContext) {
                    navigation.pop()
                }
            )
        }
    }


    @Serializable
    sealed interface NavConfig {

        @Serializable
        data object List : NavConfig

        @Serializable
        data object RootList : NavConfig
    }

}