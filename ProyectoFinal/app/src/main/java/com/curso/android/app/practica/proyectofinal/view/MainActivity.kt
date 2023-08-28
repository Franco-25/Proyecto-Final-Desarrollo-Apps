package com.curso.android.app.practica.proyectofinal.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.proyectofinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.compareButton.setOnClickListener {
            mainViewModel.setText1(binding.editTextText.text.toString())
            mainViewModel.setText2(binding.editTextText2.text.toString())
            mainViewModel.compareTexts()
            binding.textView.text = mainViewModel.getResult()
        }
    }
}