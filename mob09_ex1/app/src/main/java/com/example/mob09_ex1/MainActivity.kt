//Crie uma aplicação que peça ao utilizador um username e uma password de acesso. Cada vez que o
// utilizador insere como username “user” e password “pass” deve aparecer um
// Toast com a mensagem “Login válido”.
//• Pretende-se que ao entrar novamente na aplicação o
// username esteja pré-preenchido através de uma Shared Preference

package com.example.mob09_ex1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mob09_ex1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("ficheiro", Context.MODE_PRIVATE)

        //ler valor de NOME gravado no ficheiro, caso não exista fica vazio
        val nomeGravado = sharedPreferences.getString("NOME", "").toString()

        //mostra o valor de NOME no layout
        binding.textNome.text = nomeGravado

        binding.buttonEditar.setOnClickListener {
            val valor = binding.textValor.text.toString()
            val valor2 = binding.textValor2.text.toString()
            binding.textNome.text = valor + "\n" + valor2

            if (valor == "user" && valor2 == "password") {
                Toast.makeText(this, "Login válido", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login ERRADO", Toast.LENGTH_SHORT).show()
            }

            val editor= sharedPreferences.edit()
            editor.putString("login", valor)
            editor.putString("password", valor2)
            editor.apply()
        }

            binding.buttonLimpar.setOnClickListener{
                binding.textValor.setText("")
                binding.textValor2.setText("")
                val editor = sharedPreferences.edit()
                editor.putString("username", "")
                editor.apply()
            }

        }

    }