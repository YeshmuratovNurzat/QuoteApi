package com.etoolkit.quoteapi.repository

import androidx.lifecycle.LiveData
import com.etoolkit.quoteapi.model.Quote
import com.etoolkit.quoteapi.room.QuoteDao
import com.etoolkit.quoteapi.room.QuoteDataBase

class QuoteRepository(private val quoteDataBase: QuoteDataBase) {

    suspend fun insertPicture(quote : Quote) {
        quoteDataBase.getQuoteDao().insertQuote(quote)
    }

    suspend fun delete(quote : Quote) {
        quoteDataBase.getQuoteDao().deleteQuote(quote)
    }

    fun getAllQuote(): LiveData<List<Quote>>{
        return quoteDataBase.getQuoteDao().getAllQuote()
    }
}