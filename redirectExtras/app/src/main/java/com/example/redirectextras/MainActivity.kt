package com.example.redirectextras

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.redirectextras.databinding.ActivityMain2Binding
import com.example.redirectextras.databinding.ActivityMainBinding
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var result: ActivityResultLauncher<Intent>
    private var nome = "teste"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMudarNome.setOnClickListener{
            val i = Intent(this, MainActivity2::class.java)
            i.putExtra("nome" ,nome)
            result.launch(i)
        }
        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            if(it.resultCode == 1 && it.data != null)
            {
                nome = it.data!!.extras?.getString("nome").toString()
                binding.textNome.text = "Olá ${nome}!"
            }
        }
    }
}