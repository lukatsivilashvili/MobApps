package com.example.recyclerview

import androidx.annotation.DrawableRes

data class Product(
        val id:Int,
        val title:String,
        val description:String,
        @DrawableRes
        val image:Int,
        val isImportant:Boolean
)