package com.etoolkit.quoteapi.main



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etoolkit.quoteapi.api.QuoteRetrofitCreate
import com.etoolkit.quoteapi.model.Quote
import com.etoolkit.quoteapi.repository.QuoteRepository
import kotlinx.coroutines.launch


class QuoteViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    val liveDataQuote = MutableLiveData<Quote>()

    fun getAllQuote() : LiveData<List<Quote>>{

        return quoteRepository.getAllQuote()
    }

    fun insert(quote: Quote){
        viewModelScope.launch() {
            quoteRepository.insertPicture(quote)
        }
    }

    fun fetchRandomQuote() : MutableLiveData<Quote> {
        viewModelScope.launch() {
            var quote = QuoteRetrofitCreate.create().quotesRandomApis()
            liveDataQuote.value = quote
        }
        return liveDataQuote
    }

}