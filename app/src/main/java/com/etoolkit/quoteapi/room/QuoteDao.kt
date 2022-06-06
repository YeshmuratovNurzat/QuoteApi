package com.etoolkit.quoteapi.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.etoolkit.quoteapi.model.Quote

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote")
    fun getAllQuote() : LiveData<List<Quote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quote : Quote)

    @Delete
    suspend fun deleteQuote(quote : Quote)

}