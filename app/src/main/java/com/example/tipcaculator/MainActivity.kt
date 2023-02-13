package com.example.tipcaculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import com.example.tipcaculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCal.setOnClickListener{ calculateTip() }

    }
    private fun calculateTip(){
        val stringInTextField = binding.numberCost.text.toString()
        val cost = stringInTextField.toDouble()
        val selectedId = binding.radioGroup.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.option_amaze -> 0.20
            R.id.option_good -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundUp = binding.roundSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.result.text = getString(R.string.tip_amount, formattedTip)
    }



}