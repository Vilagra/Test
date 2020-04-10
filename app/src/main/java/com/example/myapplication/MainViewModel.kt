package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.fileexhibitsloader.FileExhibitsLoader
import com.example.model.Exhibit
import com.example.model.ExhibitsLoader
import kotlinx.coroutines.launch

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val loader: ExhibitsLoader = FileExhibitsLoader(getApplication())

    private val _exhibits = MutableLiveData<List<Exhibit>>()
    val exhibits : LiveData<List<Exhibit>> = _exhibits

    init {
        viewModelScope.launch {
            val result = loader.getExhibitList()
            _exhibits.value = result
        }
    }
}