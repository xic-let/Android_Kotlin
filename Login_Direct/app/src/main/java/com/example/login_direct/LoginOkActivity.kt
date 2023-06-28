package com.example.login_direct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login_direct.databinding.ActivityLoginOkBinding

class LoginOkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginOkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginOkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent

        val username = i.extras?.getString("username")

        binding.textBemvindo.text = "Bem-vindo, ${username}"
    }
}