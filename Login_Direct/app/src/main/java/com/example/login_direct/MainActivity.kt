package com.example.login_direct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login_direct.databinding.ActivityMainBinding
import com.example.login_direct.databinding.ActivityLoginNotOk2Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEntrar.setOnClickListener {
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            if (username == "user" && password == "pass") {
                val i = Intent(this, LoginOkActivity::class.java)
                i.putExtra("username", username)
                startActivity(i)
            } else {
                val i = Intent(this, ActivityLoginNotOk2Binding::class.java)
                startActivity(i)
            }
        }
    }
}