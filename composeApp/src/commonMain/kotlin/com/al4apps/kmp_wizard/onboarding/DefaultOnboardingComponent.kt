package com.al4apps.kmp_wizard.onboarding

import com.al4apps.kmp_wizard.onboarding.domain.OnboardingInteractor
import com.arkivanov.decompose.ComponentContext

class DefaultOnboardingComponent(
    componentContext: ComponentContext,
    onboardingInteractor: OnboardingInteractor,
    private val onFinished: () -> Unit
) : OnboardingComponent, ComponentContext by componentContext {

    override fun onSkipClick() {
        onFinished()
    }

    init {
        onboardingInteractor.updateOnboardingShowingState()
    }
}