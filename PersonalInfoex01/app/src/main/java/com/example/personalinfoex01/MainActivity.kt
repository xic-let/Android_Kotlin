package com.example.personalinfoex01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.personalinfoex01.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val address = binding.addressEditText.text.toString()
            val phone = binding.phoneEditText.text.toString()
            val email = binding.emailEditText.text.toString()


            val i = Intent(this, MainActivity2::class.java)
            i.putExtra("name", name)
            i.putExtra("address", address)
            i.putExtra("phone", phone)
            i.putExtra("email", email)
            setResult(1, i)
            finish()

            startActivity(intent)
        }
    }
}