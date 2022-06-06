package com.etoolkit.quoteapi.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.etoolkit.quoteapi.repository.QuoteRepository
import com.etoolkit.quoteapi.room.QuoteDataBase

class ViewModelFactory(private val context : Context) : ViewModelProvider.Factory {


    private val dataBase by lazy(LazyThreadSafetyMode.NONE) {
        QuoteDataBase.getInstance(context.applicationContext)
    }

    private val repository by lazy(LazyThreadSafetyMode.NONE) {
        QuoteRepository(dataBase)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuoteViewModel(repository) as T
    }
}