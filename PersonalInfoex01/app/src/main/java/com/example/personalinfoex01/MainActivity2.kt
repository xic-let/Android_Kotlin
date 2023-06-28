package com.example.personalinfoex01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.personalinfoex01.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_main2)

        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val phone = intent.getStringExtra("phone")
        val email = intent.getStringExtra("email")

        val message = "O $name mora em $address, tem o telefone $phone e o email $email."
        binding.messageTextView.text = message
    }
}