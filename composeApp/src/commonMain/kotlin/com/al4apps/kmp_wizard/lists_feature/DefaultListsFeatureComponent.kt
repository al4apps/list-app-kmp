package com.al4apps.kmp_wizard.lists_feature

import com.al4apps.kmp_wizard.core.GlobalConstants
import com.al4apps.kmp_wizard.list.DefaultChildListComponent
import com.al4apps.kmp_wizard.root_list.DefaultRootListComponent
import com.al4apps.kmp_wizard.root_list.domain.ChildListInteractor
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
    private val childListInteractor: ChildListInteractor
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
                component = DefaultRootListComponent(
                    componentContext = componentContext,
                    onItemClicked = {
                        navigation.push(NavConfig.List(0))
                    },
                    initNewList = {
                        navigation.push(NavConfig.List(GlobalConstants.NEW_LIST_ID))
                    }
                )
            )

            is NavConfig.List -> ListsFeatureComponent.StackChild.List(
                DefaultChildListComponent(
                    componentContext = componentContext,
                    listId = config.id,
                    onBackClick = { navigation.pop() },
                    childListInteractor = childListInteractor
                )
            )
        }
    }


    @Serializable
    sealed interface NavConfig {

        @Serializable
        data class List(val id: Int) : NavConfig

        @Serializable
        data object RootList : NavConfig
    }

}