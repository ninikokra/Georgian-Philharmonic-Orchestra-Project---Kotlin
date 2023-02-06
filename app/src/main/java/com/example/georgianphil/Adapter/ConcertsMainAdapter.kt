package com.example.georgianphil.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.georgianphil.Model.ConcertsMainModel
import com.example.georgianphil.R
import com.example.georgianphil.databinding.ConcertsParentItemBinding

class ConcertsMainAdapter(private val collection :List<ConcertsMainModel>) :RecyclerView.Adapter<ConcertsMainAdapter.CollectionViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.concerts_parent_item,parent,false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
     holder.binding.apply {
         val collection = collection[position]
         concertsGenreTV.text = collection.title
          val concertsAdapter = ConcertsAdapter(collection.concertsModel)
         rvConcertsChild.adapter = concertsAdapter
     }
    }

    override fun getItemCount() = collection.size

    inner class CollectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ConcertsParentItemBinding.bind(itemView)

    }
}