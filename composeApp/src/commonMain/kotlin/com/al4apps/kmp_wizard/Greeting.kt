package com.al4apps.kmp_wizard

class Greeting {
    private val platform = getPlatform()
    private val dateTime = getDateTime()

    fun greet(): String {
        return "Hello, ${platform.name}. Time: ${dateTime.dateTime}!"
    }
}