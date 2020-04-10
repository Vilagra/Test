package com.example.model

interface ExhibitsLoader {

    suspend fun getExhibitList() : List<Exhibit>
}