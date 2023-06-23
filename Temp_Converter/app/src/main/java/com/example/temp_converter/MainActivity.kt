package com.example.temp_converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.temp_converter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	
	private lateinit var binding: ActivityMainBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		binding = ActivityMainBinding.inflate(layoutInflater)
		
		setContentView(binding.root)
		
		binding.buttonconv.setOnClickListener {
			val celsious: Double = binding.cels.text.toString().toDouble()
			val fahr : Double = String.format("%.2f", celsious * 1.8 + 32).toDouble()
			
			binding.result.setText("${fahr} f" )
			if ( celsious < 18 )
				binding.phrase.setText("It's bit chilly out there! Wear a coat!")
			else
				binding.phrase.setText("It's warm and fuzzy! GO wild!")
		}
		
	}
}