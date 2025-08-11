package com.example.richmanscalculator
import java.util.Stack

fun calculation(infix : String) : String{
    val forPostfix = infixToPostfix(infix)
    val finalAns = evaluation(forPostfix)

    return finalAns.toString()

}
fun fontSize(){

}

    fun infixToPostfix(infix : String) : String {
        val result = StringBuilder()
        val stack = Stack<Char>()

        for(ch in infix.replace(" ","")){
            when{
                ch.isDigit() || ch == '.'  -> result.append(ch)
                ch == '(' -> stack.push(ch)
                ch == ')' -> {
                    while (stack.isNotEmpty() && stack.peek() != '('){
                        result.append(' ').append(stack.pop())
                    }
                    if(stack.isNotEmpty() && stack.peek() == '('){
                        stack.pop()
                    }
                }
                isOperator(ch) -> {
                    result.append(' ')
                    while (stack.isNotEmpty() && precedence(ch) <= precedence(stack.peek())){
                        result.append(stack.pop()).append(' ')
                    }
                    stack.push(ch)
                }
            }
        }
        while (stack.isNotEmpty()){
            result.append(' ').append(stack.pop())
        }

        return result.toString()
    }

    fun isOperator(ch : Char) : Boolean{
        return ch == '+' || ch == '-' || ch == '^' || ch == '/' || ch == '*'
    }

    fun precedence(op : Char ) : Int = when(op){
        '+','-' -> 1
        '*','/' -> 2
        '^' -> 3
        else -> -1
    }

    fun evaluation(postfix : String) : Double {
        val stack = Stack<Double>()
        val tokens = postfix.trim().split(" ").filter{it.isNotEmpty()}

        for(token in tokens){
            when{
                token.toDoubleOrNull() != null -> stack.push(token.toDouble())

                else -> {
                    val b = stack.pop()
                    val a = stack.pop()
                    val res = when(token){
                        "+" -> a + b
                        "-" -> a - b
                        "*" -> a * b
                        "/" -> a / b
                        "^" -> Math.pow(a,b)
                        else -> throw IllegalArgumentException("Invalid Operator ")
                    }
                    stack.push(res)
                }
            }


        }

        return stack.pop()
    }


























