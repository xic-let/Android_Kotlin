package com.example.hello

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
	
	private lateinit var binding: ActivityMainBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
		binding.imageButton.setOnClickListener {
			val fNome : String = binding.fNome.text.toString()
			
			val lNome : String = binding.lNome.text.toString()
			val nomeT : String = String.format( "${fNome} ${lNome}"
			
			binding.result.setText("Hello ${nomeT} ! Have a great Day!")
	}
}