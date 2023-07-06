package com.example.mob_07_ex3

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ArrayAdapter
import com.example.mob_07_ex3.databinding.ActivityMainBinding
import android.widget.AdapterView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaPessoa = ArrayList<Pessoa>()
        listaPessoa.add(Pessoa("Maria","maria@email.com", "Rua da Liberdade"))
        listaPessoa.add(Pessoa("João","joao@email.com", "Av.25Abril"))
        listaPessoa.add(Pessoa("Ana","ana@email.com", "Rua dos Combatentes"))
        listaPessoa.add(Pessoa("Luis","luis@email.com", "Praceta dos Guerreiros"))
        listaPessoa.add(Pessoa("Mariana","mariana@email.com", "Praça da Républica"))
        listaPessoa.add(Pessoa("Filipe","filipe@email.com", "Rua das Nações"))

        val pessoaNames = listaPessoa.map { it.nome }
        val arrayAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, pessoaNames)
        binding.listViewNomes.adapter = arrayAdapter

        binding.listViewNomes.setOnItemClickListener { _, _, position, _ ->
            val pessoa = listaPessoa[position]
            val intent = Intent(this, DataActivity::class.java).apply {
                putExtra(DataActivity.EXTRA_NOME, pessoa.nome)
                putExtra(DataActivity.EXTRA_EMAIL, pessoa.email)
                putExtra(DataActivity.EXTRA_MORADA, pessoa.morada)
            }
            startActivity(intent)
        }

        binding.buttonConsultar.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val filteredPessoas = listaPessoa.filter { it.nome == nome }
            if (filteredPessoas.isNotEmpty()) {
                val pessoa = filteredPessoas[0]
                val intent = Intent(this, DataActivity::class.java).apply {
                    putExtra(DataActivity.EXTRA_NOME, pessoa.nome)
                    putExtra(DataActivity.EXTRA_EMAIL, pessoa.email)
                    putExtra(DataActivity.EXTRA_MORADA, pessoa.morada)
                }
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Nenhum aluno encontrado com esse nome.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}