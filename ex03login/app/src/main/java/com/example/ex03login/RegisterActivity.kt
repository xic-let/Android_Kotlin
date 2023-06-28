package com.example.ex03login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ex03login.databinding.ActivityRegisterBinding
import android.content.Intent

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegister.setOnClickListener {
                val username = binding.editTextUsername.text.toString().trim()
                val password = binding.editTextPassword.text.toString().trim()

                if (username == "user" && password == "pass") {
                    val i = Intent(this, AboutActivity::class.java)
                    i.putExtra("username", username.toString())
                    startActivity(i)
                } else {

                    Toast.makeText(this, "Campos inválidos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


