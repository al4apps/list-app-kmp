package com.al4apps.kmp_wizard.root

import com.al4apps.kmp_wizard.AppSettings
import com.al4apps.kmp_wizard.home.DefaultHomeComponent
import com.al4apps.kmp_wizard.onboarding.DefaultOnboardingComponent
import com.al4apps.kmp_wizard.onboarding.domain.OnboardingInteractor
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

class DefaultRootComponent(
    componentContext: ComponentContext,
    appSettings: AppSettings,
) : RootComponent, ComponentContext by componentContext {

    private val onboardingInteractor: OnboardingInteractor = OnboardingInteractor(appSettings)

    private val navigation = StackNavigation<NavConfig>()

    override val stack: Value<ChildStack<*, RootComponent.StackChild>> = childStack(
        source = navigation,
        handleBackButton = true,
        initialConfiguration = getNavigationInitialConfig(),
        serializer = NavConfig.serializer(),
        childFactory = ::createChild
    )
    override val uiState: Value<String> = MutableValue("FromRoot")

    private fun createChild(
        config: NavConfig,
        componentContext: ComponentContext
    ): RootComponent.StackChild = when (config) {

        is NavConfig.Onboarding -> {
            RootComponent.StackChild.Onboarding(
                component = DefaultOnboardingComponent(
                    componentContext = componentContext,
                    onboardingInteractor = onboardingInteractor
                ) {
                    navigation.replaceAll(NavConfig.Home)
                }
            )
        }

        is NavConfig.Home -> {
            RootComponent.StackChild.HomeFeature(DefaultHomeComponent(componentContext))
        }

    }

    private fun getNavigationInitialConfig(): NavConfig {
        val shouldShowOnboarding = onboardingInteractor.shouldShowOnboarding()

        return if (shouldShowOnboarding) {
            NavConfig.Onboarding
        } else {
            NavConfig.Home
        }
    }

    @Serializable
    private sealed interface NavConfig {
        @Serializable
        data object Onboarding : NavConfig

        @Serializable
        data object Home : NavConfig
    }
}