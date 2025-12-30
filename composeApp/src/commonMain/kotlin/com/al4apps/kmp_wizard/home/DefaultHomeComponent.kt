package com.al4apps.kmp_wizard.home

import com.al4apps.kmp_wizard.home.model.HomeUiState
import com.al4apps.kmp_wizard.root.DefaultRootComponent
import com.al4apps.kmp_wizard.root.DefaultRootComponent.NavConfig
import com.al4apps.kmp_wizard.root.RootComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

class DefaultHomeComponent(
    componentContext: ComponentContext
): HomeComponent, ComponentContext by componentContext {

    val navigation = StackNavigation<NavConfig>()
    override val stack: Value<ChildStack<*, HomeComponent.HomeStackChild>> = childStack(
        source = navigation,
        serializer = DefaultHomeComponent.NavConfig.serializer(),
        initialConfiguration = DefaultHomeComponent.NavConfig.List,
        handleBackButton = true,
        childFactory = ::createChild
    )
    override val uiState: HomeUiState = HomeUiState()


    private fun createChild(
        config: DefaultHomeComponent.NavConfig,
        componentContext: ComponentContext
    ): HomeComponent.HomeStackChild = when (config) {

        is DefaultHomeComponent.NavConfig.RootList -> {
            HomeComponent.HomeStackChild.RootList()
        }

        is DefaultHomeComponent.NavConfig.List -> {
            HomeComponent.HomeStackChild.ListFeature()
        }

    }

    @Serializable
    sealed interface NavConfig {
        @Serializable
        data object RootList : DefaultHomeComponent.NavConfig

        @Serializable
        data object List: DefaultHomeComponent.NavConfig
    }
}