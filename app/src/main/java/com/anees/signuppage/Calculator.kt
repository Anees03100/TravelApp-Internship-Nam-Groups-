package com.anees.signuppage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Calculator(navController: NavHostController) {
    var expression by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    var firstNumber by remember { mutableStateOf("") }
    var operator by remember { mutableStateOf("") }
    var secondNumber by remember { mutableStateOf("") }


    val handleOperator: (String) -> Unit = { op ->
        if (firstNumber.isNotEmpty()) {
            if (operator.isEmpty()) {
                operator = op
                expression += op
            } else if (secondNumber.isEmpty()) {
                operator = op
                expression = expression.dropLast(1) + op
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .widthIn(max = 680.dp)
                .fillMaxWidth()
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Column(modifier = Modifier
                .weight(2F)
                .padding(vertical = 10.dp)
                .align(Alignment.End)) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = expression, color = Color.Black, fontSize = 40.sp, maxLines = 3)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = result, color = Color(0xFFE86877), fontSize = 40.sp)
            }
            Column {
                Row {
                    CalculatorButtons(
                        isFunction = true,
                        text = "AC",
                        modifier = Modifier.weight(2F),
                        onClick = {
                            expression = ""
                            result = ""
                            firstNumber = ""
                            operator = ""
                            secondNumber = ""
                        })
                    CalculatorButtons(
                        isFunction = true,
                        text = "⌫",
                        modifier = Modifier.weight(1F),
                        onClick = {
                            if (expression.isNotEmpty()) expression = expression.dropLast(1)
                            firstNumber = ""; operator = ""; secondNumber = ""
                        })
                    CalculatorButtons(
                        isFunction = true,
                        text = "/",
                        modifier = Modifier.weight(1F),
                        onClick = {
                            handleOperator(it)
                        })
                }
                Row {
                    CalculatorButtons(
                        text = "7",
                        modifier = Modifier.weight(1F),
                        onClick = { expression += it; if (operator.isEmpty()) firstNumber += it else secondNumber += it })
                    CalculatorButtons(
                        text = "8",
                        modifier = Modifier.weight(1F),
                        onClick = { expression += it; if (operator.isEmpty()) firstNumber += it else secondNumber += it })
                    CalculatorButtons(
                        text = "9",
                        modifier = Modifier.weight(1F),
                        onClick = { expression += it; if (operator.isEmpty()) firstNumber += it else secondNumber += it })
                    CalculatorButtons(
                        isFunction = true,
                        text = "*",
                        modifier = Modifier.weight(1F),
                        onClick = { handleOperator(it) })
                }
                Row {
                    CalculatorButtons(
                        text = "4",
                        modifier = Modifier.weight(1F),
                        onClick = { expression += it; if (operator.isEmpty()) firstNumber += it else secondNumber += it })
                    CalculatorButtons(
                        text = "5",
                        modifier = Modifier.weight(1F),
                        onClick = { expression += it; if (operator.isEmpty()) firstNumber += it else secondNumber += it })
                    CalculatorButtons(
                        text = "6",
                        modifier = Modifier.weight(1F),
                        onClick = { expression += it; if (operator.isEmpty()) firstNumber += it else secondNumber += it })
                    CalculatorButtons(
                        isFunction = true,
                        text = "+",
                        modifier = Modifier.weight(1F),
                        onClick = { handleOperator(it) })
                }
                Row {
                    CalculatorButtons(
                        text = "1",
                        modifier = Modifier.weight(1F),
                        onClick = { expression += it; if (operator.isEmpty()) firstNumber += it else secondNumber += it })
                    CalculatorButtons(
                        text = "2",
                        modifier = Modifier.weight(1F),
                        onClick = { expression += it; if (operator.isEmpty()) firstNumber += it else secondNumber += it })
                    CalculatorButtons(
                        text = "3",
                        modifier = Modifier.weight(1F),
                        onClick = { expression += it; if (operator.isEmpty()) firstNumber += it else secondNumber += it })
                    CalculatorButtons(
                        isFunction = true,
                        text = "-",
                        modifier = Modifier.weight(1F),
                        onClick = { handleOperator(it) })
                }
                Row {
                    CalculatorButtons(
                        text = "0",
                        modifier = Modifier.weight(2F),
                        onClick = { expression += it; if (operator.isEmpty()) firstNumber += it else secondNumber += it })
                    CalculatorButtons(text = ".", modifier = Modifier.weight(1F), onClick = {
                        if (operator.isEmpty()) {
                            if (!firstNumber.contains(".")) {
                                firstNumber += it
                                expression += it
                            }
                        } else {
                            if (!secondNumber.contains(".")) {
                                secondNumber += it
                                expression += it
                            }
                        }
                    })

                    CalculatorButtons(
                        isFunction = true,
                        text = "=",
                        modifier = Modifier.weight(1F),
                        onClick = {
                            val num1 = firstNumber.toDoubleOrNull() ?: 0.0
                            val num2 = secondNumber.toDoubleOrNull() ?: 0.0

                            val calculation = when (operator) {
                                "+" -> num1 + num2
                                "-" -> num1 - num2
                                "*" -> num1 * num2
                                "/" -> if (num2 != 0.0) num1 / num2 else "infinity"
                                else -> 0.0
                            }
                            result = calculation.toString()
                        })
                }
                Spacer(modifier = Modifier.height(25.dp))
            }
        }
    }
}

@Composable
fun CalculatorButtons(
    modifier: Modifier = Modifier,
    text: String = "",
    isFunction: Boolean = false,
    onClick: (String) -> Unit = {}
) {
    Button(
        modifier = modifier
            .clip(RoundedCornerShape(32.dp))
            .padding(4.dp)
            .height(80.dp),
        onClick = { onClick(text) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isFunction) Color(0xFFE86877) else Color.LightGray
        )
    ) {
        Text(text = text, color = if (isFunction) Color.White else Color.Black, fontSize = 26.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CalculatorPreview() {
    val dummyNavController = rememberNavController()
    Calculator(navController = dummyNavController)
}

