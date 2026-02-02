package com.al4apps.kmp_wizard

import com.al4apps.kmp_wizard.list.model.NumberValue
import kotlin.test.Test
import kotlin.test.assertEquals

class NumberValueTest {

    fun check(n: Long, scale: Int = 0): String {
        val nValue = NumberValue(n, scale)
        return nValue.getNumberString()
    }

    @Test
    fun `simple test`() {
        val result = check(-1200022, 2)
        assertEquals("-12000.22", result)
    }
}