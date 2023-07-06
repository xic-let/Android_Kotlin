package com.example.mob_07_ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mob_07_ex3.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nome = intent.getStringExtra(EXTRA_NOME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val morada = intent.getStringExtra(EXTRA_MORADA)

        binding.txtNome.text = nome
        binding.txtMorada.text = morada
        binding.txtEmail.text = email
    }

    companion object {
        const val EXTRA_NOME = "nome"
        const val EXTRA_EMAIL = "email"
        const val EXTRA_MORADA = "morada"
    }
}