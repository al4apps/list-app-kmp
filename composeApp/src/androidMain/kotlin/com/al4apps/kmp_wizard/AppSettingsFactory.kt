package com.al4apps.kmp_wizard

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

actual class AppSettingsFactory(
    private val context: Context
) {
    actual fun create(): AppSettings {
        val settingsFactory: Settings.Factory = SharedPreferencesSettings.Factory(context)
        return AppSettingsImpl(settingsFactory.create())
    }
}