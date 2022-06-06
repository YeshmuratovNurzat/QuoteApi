package com.etoolkit.quoteapi.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.etoolkit.quoteapi.databinding.ActivityMainBinding
import com.etoolkit.quoteapi.repository.QuoteRepository
import com.etoolkit.quoteapi.room.QuoteDataBase

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel : QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory(this)
        viewModel =  ViewModelProvider(this,factory).get(QuoteViewModel::class.java)

        binding.nextButton.setOnClickListener {
            viewModel.fetchRandomQuote()
            Toast.makeText(this, "Сохранено",Toast.LENGTH_SHORT).show()
        }

        getDataViewModel()

    }

    private fun getDataViewModel(){

        viewModel.fetchRandomQuote().observe(this,{
            binding.textQuote.text = it.content
            binding.author.text = it.author
            viewModel.insert(it)
            Log.e("MyLog", "insert = ${it.author}")
        })

        viewModel.getAllQuote().observe(this,{
            Log.e("MyLog","dataSave = " + it.toString())
        })

    }
}