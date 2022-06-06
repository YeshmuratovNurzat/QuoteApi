package com.etoolkit.quoteapi.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.etoolkit.quoteapi.model.Quote

@Database(entities = [Quote::class],version = 1)
abstract class QuoteDataBase : RoomDatabase(){

    abstract fun getQuoteDao() : QuoteDao

    companion object {

        private var instance: QuoteDataBase? = null

        @Synchronized
        fun getInstance(context: Context): QuoteDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext, QuoteDataBase::class.java,
                    "quote_database")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }
}