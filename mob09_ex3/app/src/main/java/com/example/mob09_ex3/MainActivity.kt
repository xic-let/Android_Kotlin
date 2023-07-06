//Crie uma aplicação que apresente ao utilizador um conjunto de botões e permita ao utilizador
// ao clicar num determinado botão tocar um áudio distinto.
//
// Nota: pode descarregar áudios em https://www.zapsplat.com/

package com.example.mob09_ex3

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mob09_ex3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_main)

        binding.buttonBird.setOnClickListener {
            val mediaPlayer = MediaPlayer.create (applicationContext, R.raw.bird)
            mediaPlayer.start()
        }
        binding.buttonCat.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.cat)
            mediaPlayer.start()
        }
        binding.buttonPig.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.pig)
            mediaPlayer.start()
        }
    }
}