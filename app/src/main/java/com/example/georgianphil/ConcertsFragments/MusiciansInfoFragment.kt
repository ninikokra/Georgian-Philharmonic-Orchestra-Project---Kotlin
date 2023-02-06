package com.example.georgianphil.ConcertsFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.georgianphil.Model.MusiciansItemModel
import com.example.georgianphil.databinding.FragmentMusiciansInfoBinding
import kotlinx.android.synthetic.main.fragment_musicians_info.view.*


class MusiciansInfoFragment : Fragment() {

    private lateinit var binding : FragmentMusiciansInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMusiciansInfoBinding.inflate(inflater,container,false)


        val name = requireArguments().getString("name")
        val prof = requireArguments().getString("prof")
        val img = requireArguments().getInt("img")
        val desc = requireArguments().getString("desc")

        binding.musiciansInfoNameTV.text = name
        binding.musiciansInfoProfTV.text = prof
        binding.musiciansInfoCVTV.text = desc
        binding.musiciansInfoImg.load(img)










        return binding.root


    }


}