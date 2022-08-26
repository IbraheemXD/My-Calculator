package com.example.mycalculator.utilities

import android.view.View
import android.widget.Button


class Calculator(var currentValue: String? = "", var previousValue: String? = "", var opp: String? = "") {

    fun allClear() {
        this.currentValue = ""
        this.previousValue = ""
        this.opp = ""
    }
    fun displayDigit(view: View) : String {
        this.currentValue = this.currentValue + (view as Button).text.toString()
        return this.currentValue.toString()
    }

    fun displayDecimalPoint() {
        if (!this.currentValue.toString().contains(".")) {
            this.currentValue = this.currentValue.toString() + "."
        }
    }
    fun clear() {
        this.currentValue = this.currentValue.toString().dropLast(1)
    }


    fun operator() {
        if (this.previousValue == "" || this.opp == "") {
            this.previousValue = this.currentValue
            this.currentValue = ""
        } else {
            this.previousValue = this.onCompute()
            this.currentValue = ""
        }
    }

    fun onEqual() {
        if (this.currentValue != "" && this.previousValue != "" && this.opp != "") {
            this.currentValue = this.onCompute()
            this.previousValue = ""
            this.opp = ""
        }
    }

    private fun onCompute() : String {
        val result = when (this.opp) {
            "+" -> (this.previousValue!!.toDouble() + this.currentValue!!.toDouble()).toString()
            "-" -> (this.previousValue!!.toDouble() - this.currentValue!!.toDouble()).toString()
            "*" -> (this.previousValue!!.toDouble() * this.currentValue!!.toDouble()).toString()
            "/" -> (this.previousValue!!.toDouble() / this.currentValue!!.toDouble()).toString()
            "%" -> (this.previousValue!!.toDouble() % this.currentValue!!.toDouble()).toString()
            else -> "invalid $opp"
        }
        return result
    }

}
