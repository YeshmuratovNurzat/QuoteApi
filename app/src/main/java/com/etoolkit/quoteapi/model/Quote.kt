package com.etoolkit.quoteapi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "quote")
class Quote(

    @PrimaryKey(autoGenerate = true)
    var id :Int,

    @ColumnInfo(name = "content")
    var content : String,

    @ColumnInfo(name = "author")
    var author : String

) : Serializable {}