package com.example.ex02calcs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.ex02calcs.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val number1 = intent.getIntExtra("number", 0)

        binding.okButton.setOnClickListener {
            val number2 = binding.numberEditText.text.toString().toInt()

            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("number1", number1)
            intent.putExtra("number2", number2)
            startActivity(intent)
        }
    }
}