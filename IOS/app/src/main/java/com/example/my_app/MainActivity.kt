package com.example.my_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.my_app.databinding.ActivityMainBinding

//funcao oncreate é a função main
// activity_main xmle o kt estão interligados
class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // alterar sempre em todas as activities
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        // isto permite que o layoutinflater vai estar associado ao binding
        setContentView(binding.root)
        
        //o codigo vai ser inserido aqui
        //manipular do lado da programacao os elementos do layout
        //implementar o viewbinding
        
       binding.buttonConverter.setOnClickListener {
           val euros : Double = binding.editValorEuros.text.toString().toDouble()
           val dolar : Double = String.format("%.2f", euros * 0.915).toDouble()
           
           binding.textValorDolares.setText("The inserted Value corresponds to ${dolar} $!")
       }
    }
}