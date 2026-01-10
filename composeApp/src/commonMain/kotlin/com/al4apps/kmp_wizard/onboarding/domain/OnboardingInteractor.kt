package com.al4apps.kmp_wizard.onboarding.domain

import com.al4apps.kmp_wizard.AppSettings

class OnboardingInteractor(
    private val appSettings: AppSettings
) {

    fun updateOnboardingShowingState() {
        appSettings.onbShowCount++
    }

    fun shouldShowOnboarding(): Boolean {
        return appSettings.onbShowCount < MAX_ONB_SHOW_COUNT
    }

    companion object {
        const val MAX_ONB_SHOW_COUNT = 3
    }
}