package com.gluon.gluonapp.utils.validation

fun validatePassword(password: String): List<Pair<String, Boolean>> {
    return listOf(
        "At least 8 characters" to (password.length >= 8),
        "At least 1 uppercase" to password.any { it.isUpperCase() },
        "At least 1 lowercase " to password.any { it.isLowerCase() },
        "At least 1 number " to password.any { it.isDigit()  /* || !it.isLetterOrDigit()*/ }
    )
}
fun validateEmail(email: String): Pair<String, Boolean> {
    return "Invalid email format" to (Regex("^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$").matches(email))
}
