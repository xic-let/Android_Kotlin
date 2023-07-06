// Crie uma aplicação que servirá de bloco de notas.
//
// Esta aplicação deve conter apenas uma EditText e um botão para gravar as notas.
//• Sempre que o utilizador clica no botão “Gravar” o valor da
// EditText é guardado nas Shared Preferences.

package com.example.mob09_ex02

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mob09_ex02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = com.example.mob09_ex02.databinding.ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("ficheiro", Context.MODE_PRIVATE)

        val savedNotes = sharedPreferences.getString("NOTAS", "").toString()

        binding.editNotas.setText(savedNotes)

        binding.buttonGravar.setOnClickListener {
            val nota = binding.editNotas.text.toString()
            binding.editNotas.setText(nota)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NOTAS", nota)
            editor.apply()
        }

        binding.editNotas.setOnClickListener{
            binding.editNotas.setText(binding.editNotas.text.toString())
        }


    }
}