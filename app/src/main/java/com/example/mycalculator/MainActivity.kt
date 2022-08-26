package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.mycalculator.databinding.ActivityMainBinding
import com.example.mycalculator.utilities.Calculator

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var calculator: Calculator
    private var previousValue : String? = null
    private var currentValue: String? = null
    private var operator : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentValue = binding.tvInput.text.toString()
        previousValue = binding.tvPreviousInput.text.toString()

        calculator = Calculator(currentValue, previousValue, operator)
    }

    fun onOperator(view: View) {
        operator = (view as Button).text.toString()
        if (operator == null) {
            calculator.opp = operator
            calculator.operator()
        } else {
            if (calculator.currentValue != "") calculator.operator()
            calculator.opp = operator
        }
        updateDisplay()
    }

    fun onAllClear(view: View) {
        calculator.allClear()
        updateDisplay()
    }
    fun onClear(view: View) {
        calculator.clear()
        updateDisplay()
    }
    fun onDigit(view: View) {
        binding.tvInput.text = calculator.displayDigit(view)
        updateDisplay()
    }
    fun onDecimalPoint(view: View) {
        calculator.displayDecimalPoint()
        updateDisplay()
    }

    fun onEqual(view: View) {
        calculator.onEqual()
        updateDisplay()
    }
    private fun updateDisplay() {
        binding.tvInput.text = calculator.currentValue
        binding.tvPreviousInput.text = calculator.previousValue
        operator = calculator.opp
    }

}


