package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Exhibit
import com.example.myapplication.R
import kotlinx.android.synthetic.main.phones_item.view.*

class ExhibitsAdapter(private val exhibits: List<Exhibit>) :
    RecyclerView.Adapter<ExhibitsAdapter.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.phones_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return exhibits.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val exhibit = exhibits[position]
        holder.textView.text = exhibit.title
        val childLayoutManager =
            LinearLayoutManager(holder.recyclerView.context, RecyclerView.HORIZONTAL, false).apply {
                initialPrefetchItemCount = 4
            }
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = ImagesAdapter(exhibit.images ?: emptyList())
            setRecycledViewPool(viewPool)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.rv_images
        val textView: TextView = itemView.textView
    }
}