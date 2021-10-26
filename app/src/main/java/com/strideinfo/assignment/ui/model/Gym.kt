package com.strideinfo.assignment.ui.model

data class Gym(
    val date: String,
    var favorite: Boolean,
    val id: Int,
    val popular_clasess: List<ClassTypes>,
    val price: Int,
    val rating: Double,
    val title: String
)