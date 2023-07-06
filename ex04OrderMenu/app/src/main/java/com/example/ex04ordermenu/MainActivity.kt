package com.example.ex04ordermenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.ex04ordermenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var pos = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaNomes = ArrayList<String>()
        listaNomes.add("Pao")
        listaNomes.add("Agua")
        listaNomes.add("Cafe")
        listaNomes.add("Bolo")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNomes)
        binding.listViewNomes.adapter = arrayAdapter

        binding.listViewNomes.setOnItemClickListener{ parent, view, position, id ->
            Toast.makeText(applicationContext, listaNomes.get(position), Toast.LENGTH_SHORT).show()
            binding.editNome.setText(listaNomes[position])
            pos = position

        binding.listViewNomes.setOnItemLongClickListener{ _, _, position, _ ->
            Toast.makeText(applicationContext, position.toString(), Toast.LENGTH_SHORT).show()
        true
        }

       binding.buttonAdicionar.setOnClickListener{
           val nome = binding.editNome.text.toString()
           listaNomes.add(nome)
           arrayAdapter.notifyDataSetChanged()

       }
       binding.buttonEditar.setOnClickListener{
           if (pos >= 0 && pos < listaNomes.size) {
               listaNomes[pos] = binding.editNome.text.toString()
               pos = -1
               arrayAdapter.notifyDataSetChanged()
           }

       }
       binding.buttonELiminar.setOnClickListener {
           if (pos >= 0 && pos < listaNomes.size) {
               listaNomes.removeAt(pos)
               pos = -1
               arrayAdapter.notifyDataSetChanged()
           }
       }

       }
    }
}