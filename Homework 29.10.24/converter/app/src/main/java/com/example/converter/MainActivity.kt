package com.example.converter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.converter.R

class MainActivity : AppCompatActivity() {

    private lateinit var editTextSourceAmount: EditText
    private lateinit var editTextTargetAmount: EditText
    private lateinit var spinnerSourceCurrency: Spinner
    private lateinit var spinnerTargetCurrency: Spinner

    // Tỷ giá hối đoái mẫu
    private val exchangeRates = mapOf(
        "USD_VND" to 24000.0,
        "VND_USD" to 0.000042,
        "USD_EUR" to 0.85,
        "EUR_USD" to 1.18,
        "USD_JPY" to 110.0,
        "JPY_USD" to 0.0091,
        "USD_GBP" to 0.73,
        "GBP_USD" to 1.37,
        "VND_EUR" to 0.000035,
        "EUR_VND" to 28500.0,
        "VND_JPY" to 0.0045,
        "JPY_VND" to 220.0,
        "VND_GBP" to 0.00003,
        "GBP_VND" to 33000.0,
        "EUR_JPY" to 130.0,
        "JPY_EUR" to 0.0077,
        "EUR_GBP" to 0.86,
        "GBP_EUR" to 1.17,
        "JPY_GBP" to 0.0067,
        "GBP_JPY" to 149.0
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextSourceAmount = findViewById(R.id.editTextSourceAmount)
        editTextTargetAmount = findViewById(R.id.editTextTargetAmount)
        spinnerSourceCurrency = findViewById(R.id.spinnerSourceCurrency)
        spinnerTargetCurrency = findViewById(R.id.spinnerTargetCurrency)

        setupSpinners()
        setupConversionListener()
    }

    private fun setupSpinners() {
        val currencies = arrayOf("USD", "VND", "EUR", "JPY", "GBP")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, currencies)
        spinnerSourceCurrency.adapter = adapter
        spinnerTargetCurrency.adapter = adapter
    }

    private fun setupConversionListener() {
        editTextSourceAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                convertCurrency()
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        spinnerSourceCurrency.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                convertCurrency()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinnerTargetCurrency.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                convertCurrency()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun convertCurrency() {
        val sourceCurrency = spinnerSourceCurrency.selectedItem.toString()
        val targetCurrency = spinnerTargetCurrency.selectedItem.toString()
        val sourceAmountStr = editTextSourceAmount.text.toString()

        if (sourceAmountStr.isNotEmpty()) {
            val sourceAmount = sourceAmountStr.toDouble()
            val conversionKey = "${sourceCurrency}_${targetCurrency}"
            val exchangeRate = exchangeRates[conversionKey] ?: 1.0 // Nếu không tìm thấy tỷ giá, giữ nguyên giá trị

            val convertedAmount = sourceAmount * exchangeRate
            editTextTargetAmount.setText(convertedAmount.toString())
        } else {
            editTextTargetAmount.setText("")
        }
    }
}
