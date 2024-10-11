package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.caculator.R

class MainActivity : AppCompatActivity() {

    private lateinit var textViewResult: TextView
    private var currentInput: String = ""
    private var operator: String? = null
    private var firstOperand: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)

//        textViewResult = findViewById(R.id.textViewResult)
//
//        val button0: Button = findViewById(R.id.button0)
//        val button1: Button = findViewById(R.id.button1)
//        val button2: Button = findViewById(R.id.button2)
//        val button3: Button = findViewById(R.id.button3)
//        val button4: Button = findViewById(R.id.button4)
//        val button5: Button = findViewById(R.id.button5)
//        val button6: Button = findViewById(R.id.button6)
//        val button7: Button = findViewById(R.id.button7)
//        val button8: Button = findViewById(R.id.button8)
//        val button9: Button = findViewById(R.id.button9)
//
//        val buttonAdd: Button = findViewById(R.id.buttonAdd)
//        val buttonSub: Button = findViewById(R.id.buttonSub)
//        val buttonMul: Button = findViewById(R.id.buttonMul)
//        val buttonDiv: Button = findViewById(R.id.buttonDiv)
//
//        val buttonCE: Button = findViewById(R.id.buttonCE)
//        val buttonC: Button = findViewById(R.id.buttonC)
//        val buttonBS: Button = findViewById(R.id.buttonBS)
//        val buttonEq: Button = findViewById(R.id.buttonEq)
//        val buttonPlusMinus: Button = findViewById(R.id.buttonPlusMinus)
//
//        // Xử lý sự kiện cho các nút số
//        val numberButtons = listOf(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9)
//        for (button in numberButtons) {
//            button.setOnClickListener {
//                onNumberClick(button.text.toString())
//            }
//        }
//
//        // Xử lý sự kiện cho các nút phép tính
//        buttonAdd.setOnClickListener { onOperatorClick("+") }
//        buttonSub.setOnClickListener { onOperatorClick("-") }
//        buttonMul.setOnClickListener { onOperatorClick("*") }
//        buttonDiv.setOnClickListener { onOperatorClick("/") }
//
//        // Nút CE - xóa toàn bộ
//        buttonCE.setOnClickListener { clearAll() }
//
//        // Nút C - xóa kết quả hiện tại
//        buttonC.setOnClickListener { clearCurrent() }
//
//        // Nút BS - xóa ký tự cuối cùng
//        buttonBS.setOnClickListener { backspace() }
//
//        // Nút +/- - đổi dấu
//        buttonPlusMinus.setOnClickListener { toggleSign() }
//
//        // Nút kết quả (=)
//        buttonEq.setOnClickListener { calculateResult() }
//    }
//
//    // Xử lý sự kiện khi nhấn các nút số
//    private fun onNumberClick(number: String) {
//        currentInput += number
//        textViewResult.text = currentInput
//    }
//
//    // Xử lý sự kiện khi nhấn các nút phép tính
//    private fun onOperatorClick(selectedOperator: String) {
//        if (currentInput.isNotEmpty()) {
//            firstOperand = currentInput.toInt()
//            currentInput = ""
//            operator = selectedOperator
//        }
//    }
//
//    // Tính toán kết quả
//    private fun calculateResult() {
//        if (firstOperand != null && operator != null && currentInput.isNotEmpty()) {
//            val secondOperand = currentInput.toInt()
//            var result: Int? = null
//
//            when (operator) {
//                "+" -> result = firstOperand!! + secondOperand
//                "-" -> result = firstOperand!! - secondOperand
//                "*" -> result = firstOperand!! * secondOperand
//                "/" -> if (secondOperand != 0) result = firstOperand!! / secondOperand
//            }
//
//            if (result != null) {
//                textViewResult.text = result.toString()
//                currentInput = result.toString()
//                firstOperand = null
//                operator = null
//            }
//        }
//    }
//
//    // Xóa toàn bộ
//    @SuppressLint("SetTextI18n")
//    private fun clearAll() {
//        currentInput = ""
//        firstOperand = null
//        operator = null
//        textViewResult.text = "0"
//    }
//
//    // Xóa kết quả hiện tại
//    @SuppressLint("SetTextI18n")
//    private fun clearCurrent() {
//        currentInput = ""
//        textViewResult.text = "0"
//    }
//
//    private fun backspace() {
//        if (currentInput.isNotEmpty()) {
//            currentInput = currentInput.dropLast(1)
//            textViewResult.text = currentInput.ifEmpty { "0" }
//        }
//    }
//
//    // Đổi dấu
//    private fun toggleSign() {
//        if (currentInput.isNotEmpty()) {
//            val value = currentInput.toInt()
//            currentInput = (-value).toString()
//            textViewResult.text = currentInput
//        }
//    }
    }
}