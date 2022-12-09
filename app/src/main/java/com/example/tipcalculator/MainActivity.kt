package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculate.setOnClickListener{

            calculateTip()
        }
    }

    fun calculateTip(){

        val cost=binding.costOfService.text.toString().toDouble()

        val selected = binding.tipOptions.checkedRadioButtonId

        val tipPercentage = when (selected) {
            R.id.amazing -> 0.20
            R.id.good -> 0.18
            else -> 0.15
        }

        var final = tipPercentage*cost

        val roundup = binding.roundUp.isChecked

        if(roundup){

            final = ceil(final)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(final)

        binding.displayAmount.text=getString(R.string.tip_amount,formattedTip)
    }
}