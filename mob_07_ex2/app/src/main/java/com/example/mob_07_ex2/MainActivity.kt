//Crie uma aplicação que contenha na mesma Activity um EditText para
// inserir valores inteiros, um botão de
// Adicionar e que sempre que o botão é clicado o valor da
// EditText passa para a lista de valores e consequentemente
// a ListView é atualizada.

package com.example.mob_07_ex2

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.mob_07_ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var pos = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaNbrs = ArrayList<Int>()
        listaNbrs.add(0)
        listaNbrs.add(1)
        listaNbrs.add(2)
        listaNbrs.add(3)
        listaNbrs.add(4)
        listaNbrs.add(5)

        val arrayAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, listaNbrs)
        binding.listViewNbr.adapter = arrayAdapter

        binding.listViewNbr.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(applicationContext, listaNbrs[position], Toast.LENGTH_SHORT).show()
            binding.editNbr.setText(listaNbrs[position])
            pos = position
        }

        binding.listViewNbr.setOnItemLongClickListener { _, _, position, _ ->
            Toast.makeText(applicationContext, position.toString(), Toast.LENGTH_SHORT).show()
            true
        }

        binding.buttonAdicionar.setOnClickListener {
            //vai buscar o texto ao edittext como uma string
            val nbrText = binding.editNbr.text.toString()
            if (nbrText.isNotEmpty()) {
                //verifica se a string nao está vazia
                val nbr = nbrText.toInt()
                //converte a string para int
                listaNbrs.add(nbr)
                //faz a adição à lista
                arrayAdapter.notifyDataSetChanged()
                //notifica o arrayadptaer
                binding.editNbr.text.clear()
                //apaga o texto no edit text
            } else {
                Toast.makeText(applicationContext, "Digite um valor inteiro", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}