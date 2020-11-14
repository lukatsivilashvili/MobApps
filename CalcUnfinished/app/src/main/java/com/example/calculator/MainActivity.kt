package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""

    var lastNumeric:Boolean = false
    var lastDot:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberClick(view: View) {

        if (view is TextView) {

            var result: String = resultTextView.text.toString()
            val number: String = view.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = result + number

            lastNumeric = true
        }

    }

    fun operationClick(view: View) {

        lastDot = false
        lastNumeric = false

        if (view is TextView) {

            if (!TextUtils.isEmpty(resultTextView.text)) {
                operand = resultTextView.text.toString().toDouble()
            }

            operation = view.text.toString()

            resultTextView.text = ""

        }

    }

    fun equalsClick(view: View) {

        val secOperandText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        lastNumeric = false
        lastDot = false

        if (!TextUtils.isEmpty(secOperandText)) {
            secOperand = secOperandText.toDouble()
        }

        when(operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
        }

    }

    fun clearClick(view: View) {
        if(!TextUtils.isEmpty(resultTextView.text)) {
            resultTextView.text = ""
            lastDot = false
            lastNumeric = false
        }
    }

    fun delClick (view: View) {
        val num1 = resultTextView.text.toString()
        if(!TextUtils.isEmpty(resultTextView.text)) {
            resultTextView.text = num1.substring(0, num1.length-1)
        }
    }

    fun dotClick(view: View) {
        if (lastNumeric && !lastDot) {
            resultTextView.append(".")
            lastNumeric = false
            lastDot = true
        }

    }

}