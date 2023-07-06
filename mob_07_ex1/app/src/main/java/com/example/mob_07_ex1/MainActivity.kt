//Crie uma aplicação que apresente uma lista de nomes de pessoas (String) e sempre que clicado num dos elementos deve aparecer um Toast com a mensagem Olá + nome pessoa clicada.

package com.example.mob_07_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mob_07_ex1.databinding.ActivityMainBinding
import android.widget.ArrayAdapter
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var pos = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaNomes = ArrayList<String>()
        listaNomes.add("Maria")
        listaNomes.add("João")
        listaNomes.add("Ana")
        listaNomes.add("Luis")
        listaNomes.add("Mariana")
        listaNomes.add("Filipe")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNomes)
        binding.listViewNomes.adapter = arrayAdapter

        binding.listViewNomes.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(applicationContext, "Olá ${listaNomes[position]}!", Toast.LENGTH_SHORT).show()
            binding.editNome.setText(listaNomes[position])
            pos = position
        }

        binding.listViewNomes.setOnItemLongClickListener { _, _, position, _ ->
            Toast.makeText(applicationContext, position.toString(), Toast.LENGTH_SHORT).show()
            true
        }

        binding.buttonHello.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val posicaoNome = listaNomes.indexOf(nome)
            if (posicaoNome != -1) {
                val nomeClicado = listaNomes[posicaoNome]
                Toast.makeText(applicationContext, "Olá $nomeClicado!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Nome não encontrado na lista.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}