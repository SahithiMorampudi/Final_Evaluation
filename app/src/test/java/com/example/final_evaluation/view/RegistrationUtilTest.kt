package com.example.final_evaluation.view

import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class RegistrationUtilTest {
    @Test
    fun `test validate input`() {
        val result = RegistrationUtil.validate("qweqweq", "87435357as")
        Assert.assertTrue(result)
    }
}