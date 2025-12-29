package com.al4apps.kmp_wizard

interface Platform {
    val name: String
}

interface DateTime {
    val dateTime: String
}

expect fun getPlatform(): Platform
expect fun getDateTime(): DateTime