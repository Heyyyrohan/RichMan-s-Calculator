package com.example.richmanscalculator.ui.theme

fun isValidExpression(expr: String): Boolean {
    val cleanExpr = expr.replace(" ", "")

    // Only valid characters
    if (!cleanExpr.matches(Regex("^[0-9+\\-*/^().]*$"))) return false

    // Balanced parentheses
    var balance = 0
    for (ch in cleanExpr) {
        if (ch == '(') balance++
        if (ch == ')') balance--
        if (balance < 0) return false
    }
    if (balance != 0) return false

    // No consecutive operators
    if (cleanExpr.contains(Regex("[+\\-*/^]{2,}"))) return false

    // Expression doesn’t start with invalid operator
    if (cleanExpr.matches(Regex("^[+*/^)].*"))) return false

    // Expression doesn’t end with invalid operator
    if (cleanExpr.matches(Regex(".*[+\\-*/^(]$"))) return false


    // Valid decimal numbers
    if (cleanExpr.contains(Regex("\\d*\\.\\d*\\."))) return false

    return true
}
