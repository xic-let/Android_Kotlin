package com.example.ex03login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.EditText
import com.example.ex03login.databinding.ActivityLoginBinding




class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val username = binding.editTextUsername.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()


            if (username == "User" && password == "Pass") {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Credenciais inválidas. Tente novamente.", Toast.LENGTH_SHORT).show()
                findViewById<EditText>(R.id.editTextUsername).text.clear()
                findViewById<EditText>(R.id.editTextPassword).text.clear()
            }
        }
    }
}