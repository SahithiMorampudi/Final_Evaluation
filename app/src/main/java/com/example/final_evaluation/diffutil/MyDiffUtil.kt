package com.example.final_evaluation.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.final_evaluation.model.Photos

class MyDiffUtil(private val oldList: List<Photos>, private val newList: List<Photos>) :
    DiffUtil.Callback(


    ) {


    override fun getOldListSize(): Int {
        return oldList.size
    }


    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].id != newList[newItemPosition].id -> {
                false
            }
            oldList[oldItemPosition].title != newList[newItemPosition].title -> {
                false
            }
            else -> true

        }

    }
}