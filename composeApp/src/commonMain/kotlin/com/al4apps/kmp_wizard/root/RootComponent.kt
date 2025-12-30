package com.al4apps.kmp_wizard.root

import androidx.compose.runtime.Stable
import com.al4apps.kmp_wizard.home.HomeComponent
import com.al4apps.kmp_wizard.onboarding.OnboardingComponent
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

@Stable
interface RootComponent {

    val stack: Value<ChildStack<*, StackChild>>
    val uiState: Value<String>

    sealed class StackChild {
        class Onboarding(val component: OnboardingComponent) : StackChild()
        class HomeFeature(val component: HomeComponent) : StackChild()
    }
}