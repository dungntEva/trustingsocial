package com.example.myapplication.data.models

data class Articles(
    val min_amount: Integer,
    val max_amount: Integer,
    val min_tenor: Integer,
    val max_tenor: Integer,
    val interest_rate: Float,
    val bank: Bank)