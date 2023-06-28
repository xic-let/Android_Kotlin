package com.example.login_direct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.login_direct.databinding.ActivityLoginNotOk2Binding

class LoginErradoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginNotOk2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginNotOk2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(applicationContext, "Login errado", Toast.LENGTH_SHORT).show()

        binding.buttonVoltar.setOnClickListener {
            finish()
        }
    }
}