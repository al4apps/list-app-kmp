package com.al4apps.kmp_wizard

import com.russhwolf.settings.NSUserDefaultsSettings

actual class AppSettingsFactory {
    actual fun create(): AppSettings {
        val factory = NSUserDefaultsSettings.Factory()
        return AppSettingsImpl(factory.create())
    }
}