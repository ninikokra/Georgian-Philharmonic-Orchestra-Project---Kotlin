package com.example.georgianphil.ConcertsFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.georgianphil.Adapter.MusiciansMainAdapter
import com.example.georgianphil.Utils.MusiciansData
import com.example.georgianphil.databinding.FragmentMusiciansBinding


class MusiciansFragment : Fragment() {

    private lateinit var binding: FragmentMusiciansBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMusiciansBinding.inflate(inflater,container,false)

        binding.mainConcertsRV.adapter = MusiciansMainAdapter(MusiciansData.collections)

















        return binding.root
    }



}