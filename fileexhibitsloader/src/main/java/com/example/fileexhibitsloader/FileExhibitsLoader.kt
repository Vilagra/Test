package com.example.fileexhibitsloader

import android.content.Context
import com.example.model.Exhibit
import com.example.model.ExhibitsLoader
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.lang.reflect.Type


class FileExhibitsLoader(private val context: Context) :  ExhibitsLoader {

    override suspend fun getExhibitList() = withContext(Dispatchers.Default){
        val json: String = context.assets.open("phones.json").bufferedReader().use {it.readText()}
        val mainObject = JSONObject(json).getJSONArray("list").toString()
        val itemsListType: Type = object : TypeToken<List<Exhibit>>() {}.type
        Gson().fromJson(mainObject, itemsListType) as List<Exhibit>
    }
}