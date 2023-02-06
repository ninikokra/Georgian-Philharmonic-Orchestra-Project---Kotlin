package com.example.georgianphil.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.georgianphil.ConcertsFragments.MusiciansInfoFragment
import com.example.georgianphil.Model.MusiciansItemModel
import com.example.georgianphil.R
import com.example.georgianphil.databinding.MusiciansListItemBinding


class MusiciansItemAdapter( private val musiciansItemModel: List<MusiciansItemModel>) : RecyclerView.Adapter<MusiciansItemAdapter.ViewHolder>(){

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.musicians_list_item,parent,false)
    return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            orchestraMusiciansNameTV.text = musiciansItemModel[position].musiciansItemTitle


        }
    }

    override fun getItemCount() = musiciansItemModel.size

    @SuppressLint("SuspiciousIndentation")
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding = MusiciansListItemBinding.bind(itemView)



        init {
            binding.orchestraMusiciansNameTV.setOnClickListener {
                var position: Int = absoluteAdapterPosition
                val context = itemView.context

                val bundle = Bundle()
                bundle.putString("name", musiciansItemModel[position].musiciansItemTitle)
                bundle.putString("prof", musiciansItemModel[position].musiciansItemProf)
                bundle.putString("desc", musiciansItemModel[position].musiciansItemDesc)
                bundle.putInt("img", musiciansItemModel[position].musiciansItemImgUrl)
                val musiciansInfoFragment = MusiciansInfoFragment()

                musiciansInfoFragment.arguments = bundle
                    (context as FragmentActivity).supportFragmentManager.beginTransaction()
                    .replace(com.example.georgianphil.R.id.mainContainer, musiciansInfoFragment,null).addToBackStack(null).commit()





            }
        }

    }

}