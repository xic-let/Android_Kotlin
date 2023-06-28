package com.example.redirectextras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.redirectextras.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val i= intent
        val nome = i.extras?.getString("nome")

        binding.editNome.setText(nome)

        binding.buttonOk.setOnClickListener{

            val novoNome = binding.editNome.text.toString()
            i.putExtra("nome", novoNome)
            setResult(1, i)
            finish()
        }
    }
}