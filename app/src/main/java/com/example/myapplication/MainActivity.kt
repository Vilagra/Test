package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.ExhibitsAdapter
import kotlinx.android.synthetic.main.activity_main.rv_phones

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycler()
        setupViewModel()
    }

    fun setupRecycler(){
        rv_phones.layoutManager = LinearLayoutManager(
                this@MainActivity,
                RecyclerView.VERTICAL, false
            )
    }

    fun setupViewModel(){
        viewModel.exhibits.observe(this, Observer {
             rv_phones.adapter = ExhibitsAdapter(it)
        })
    }
}
