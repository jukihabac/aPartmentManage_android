package com.example.apartmentmanage_android.utils

import java.util.regex.Pattern

object PatternUtils {
    val PASSWORD_PATTERN: Pattern =
        Pattern.compile("((?=.*\\d)(?=.*[a-z]).{6,})")

    val USERNAME_PATTERN: Pattern =
        Pattern.compile("((?=.*[a-z]).{5,})")
}
