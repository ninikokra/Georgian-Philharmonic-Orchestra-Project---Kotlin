package com.example.georgianphil.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.georgianphil.Model.ConcertsModel
import com.example.georgianphil.R
import com.example.georgianphil.databinding.ConcertsItmeBinding

class ConcertsAdapter(private val concertsModel: List<ConcertsModel>) :RecyclerView.Adapter<ConcertsAdapter.ConcertsViewHolder>() {




    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConcertsViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.concerts_itme,parent,false)
        return ConcertsViewHolder(view)

    }

    override fun onBindViewHolder(holder: ConcertsViewHolder, position: Int) {
      holder.binding.apply {
         concertsRvIMG.load(concertsModel[position].concertUrl)
      }
    }

    override fun getItemCount() =
        concertsModel.size

        inner class ConcertsViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
                val binding = ConcertsItmeBinding.bind(itemView)
        }

}