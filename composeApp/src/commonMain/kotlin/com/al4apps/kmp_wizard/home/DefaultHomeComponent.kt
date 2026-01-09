package com.al4apps.kmp_wizard.home

import com.al4apps.kmp_wizard.home.model.HomeUiState
import com.al4apps.kmp_wizard.lists_feature.DefaultListsFeatureComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

class DefaultHomeComponent(
    componentContext: ComponentContext
) : HomeComponent, ComponentContext by componentContext {

    val navigation = StackNavigation<NavConfig>()
    override val stack: Value<ChildStack<*, HomeComponent.HomeStackChild>> = childStack(
        source = navigation,
        serializer = NavConfig.serializer(),
        initialConfiguration = NavConfig.ListsFeature,
        handleBackButton = true,
        childFactory = ::createChild
    )
    override val uiState: HomeUiState = HomeUiState()


    private fun createChild(
        config: NavConfig,
        componentContext: ComponentContext
    ): HomeComponent.HomeStackChild = when (config) {

        is NavConfig.ListsFeature -> {
            HomeComponent.HomeStackChild.ListsFeature(DefaultListsFeatureComponent(componentContext))
        }

    }

    @Serializable
    sealed interface NavConfig {

        @Serializable
        data object ListsFeature : NavConfig

    }
}