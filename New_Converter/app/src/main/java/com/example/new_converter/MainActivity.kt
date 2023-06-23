package com.example.new_converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.new_converter.databinding.ActivityMainBinding
import kotlin.text.Typography.euro


class MainActivity : AppCompatActivity() {
	
	private lateinit var binding: ActivityMainBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
		binding.buttonDolar.setOnClickListener {
			Converter(1.09, "Dolar")
			//val euros : Double = binding.editValorEuros.text.toString().toDouble()
			//val dolar : Double = String.format("%.2f", euros * 1.09).toDouble()
			
			//binding.textValorDolares.setText("The inserted Value corresponds to ${dolar} $!")
			//Toast.makeText(applicationContext, "The inserted Value corresponds to ${dolar} $!", Toast.LENGTH_SHORT).show()
		}
		
		binding.buttonReal.setOnClickListener {
			Converter(5.23, "Reais")
			/*val euros : Double = binding.editValorEuros.text.toString().toDouble()
			val reais : Double = String.format("%.2f", euros * 5.23).toDouble()
			
			binding.textValorDolares.setText("The inserted Value corresponds to ${reais} $!")
			Toast.makeText(applicationContext, "The inserted Value corresponds to ${reais} $!", Toast.LENGTH_SHORT).show()*/
		}
		
		binding.buttonPeso.setOnClickListener {
			Converter(18.82, "Pesos")
			/*val euros : Double = binding.editValorEuros.text.toString().toDouble()
			val pesos : Double = String.format("%.2f", euros * 18.82).toDouble()
			
			binding.textValorDolares.setText("The inserted Value corresponds to ${pesos} $!")
			Toast.makeText(applicationContext, "The inserted Value corresponds to ${pesos} $!", Toast.LENGTH_SHORT).show()*/
		}
	}
	
	fun Converter(taxa: Double, moeda: String) {
		val euros = binding.editValorEuros.text.toString()
		if (euros.isNotEmpty()) {
			
			val convertido = euros.toDouble() * taxa
			
			binding.textValorDolares.setText("The inserted Value corresponds to ${convertido} $!")
			Toast.makeText(
				applicationContext,
				"The inserted Value corresponds to ${convertido} ${moeda} $!",
				Toast.LENGTH_SHORT
			).show()
	} else {
			Toast.makeText(
				applicationContext,
				"Insert amount in Euros to convert",
				Toast.LENGTH_SHORT
			).show()
		}
		
	}
	
}
