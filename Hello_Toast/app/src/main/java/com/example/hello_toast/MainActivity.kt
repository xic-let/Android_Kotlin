package com.example.hello_toast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hello_toast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	
	private lateinit var binding: ActivityMainBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
		binding.button2.setOnClickListener {
			val username = binding.editText1.text.toString()
			val password = binding.TextPassword.text.toString()
			
			if (username.isEmpty())
				Toast.makeText(
					applicationContext,
					"Preencha username para validação",
					Toast.LENGTH_SHORT
				).show()
			else if (password.isEmpty()) {
				
				if (username == "user" && password == "pass") {
					Toast.makeText(applicationContext, "Bem-vindo!", Toast.LENGTH_SHORT).show()
				} else {
					Toast.makeText(applicationContext, "Login inválido", Toast.LENGTH_SHORT).show()
				}
				
				binding.editText1.setText("")
			}
		}
	}
}