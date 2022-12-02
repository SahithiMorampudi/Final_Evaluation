package com.example.final_evaluation.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "photos")
@Parcelize
data class Photos(

    @PrimaryKey
    val id: String,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) : Parcelable