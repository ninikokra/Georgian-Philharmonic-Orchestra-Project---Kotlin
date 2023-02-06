package com.example.georgianphil.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.georgianphil.Model.MusiciansItemModel
import com.example.georgianphil.Model.MusiciansMainModel
import com.example.georgianphil.R
import com.example.georgianphil.databinding.MusicianParentItemBinding

class MusiciansMainAdapter(val collections: List<MusiciansMainModel>) :RecyclerView.Adapter<MusiciansMainAdapter.ViewHolder>(){


    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.musician_parent_item,parent,false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            val collection = collections[position]
            titleMusiciansParentTV.text = collection.title
            val musiciansItemAdapter = MusiciansItemAdapter(collection.musiciansItemModel)
            musiciansListItemRV.adapter = musiciansItemAdapter
            musiciansListItemRV.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

           titleMusiciansParentTV.setOnClickListener {
                musiciansListItemRV.visibility =
                    if (musiciansListItemRV.isShown)
                        View.GONE
                    else View.VISIBLE
            }


        }

    }

    override fun getItemCount()=collections.size

    inner class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
        val binding = MusicianParentItemBinding.bind(itemView)
    }

}