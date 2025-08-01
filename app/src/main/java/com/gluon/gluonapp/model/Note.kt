package com.gluon.gluonapp.model

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val tag: String,
    val checkItems: List<CheckItem>
)
