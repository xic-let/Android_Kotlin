package com.example.ex02calcs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex02calcs.databinding.ActivityMain3Binding
import android.content.Intent

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val number1 = intent.getIntExtra("number1", 0)
        val number2 = intent.getIntExtra("number2", 0)

        val sum = number1 + number2
        val difference = number1 - number2
        val product = number1 * number2
        val division = number1 / number2

        val result = "$number1 + $number2 = $sum\n" +
                "$number1 - $number2 = $difference\n" +
                "$number1 * $number2 = $product\n" +
                "$number1 / $number2 = $division"

        binding.resultTextView.text = result
    }

}