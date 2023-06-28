package com.example.ex02calcs
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex02calcs.databinding.ActivityMainBinding
import androidx.activity.result.contract.ActivityResultContracts
import android.app.Activity



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.okButton.setOnClickListener {
            val number = binding.numberEditText.text.toString().toInt()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("number", number)
            startActivity(intent)
        }
    }
}