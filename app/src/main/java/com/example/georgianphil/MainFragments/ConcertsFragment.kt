package com.example.georgianphil.MainFragments

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.georgianphil.Adapter.ConcertsMainAdapter
import com.example.georgianphil.ConcertsFragments.ComposersFragment
import com.example.georgianphil.ConcertsFragments.MusiciansFragment

import com.example.georgianphil.R
import com.example.georgianphil.Utils.SimpleData
import com.example.georgianphil.databinding.FragmentConcertsBinding


class ConcertsFragment : Fragment() {

    private lateinit var binding: FragmentConcertsBinding
    //private lateinit var videoView: VideoView
    private lateinit var vMediaPlayer: MediaPlayer
    private var currentVideoPosition: Int = 0
    //private var packageName:String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding = FragmentConcertsBinding.inflate(inflater,container,false)

        binding.apply {
            mainConcertsRV.adapter = ConcertsMainAdapter(SimpleData.collections)
        }

        binding.orchestraMusiciansTV.setOnClickListener {

            val musicians = MusiciansFragment()
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.replace(R.id.mainContainer,musicians,"concertsFragment",)?.addToBackStack(null)
                ?.commit()
        }

        binding.composersTV.setOnClickListener {
            val composers = ComposersFragment()
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.replace(R.id.mainContainer,composers,"concertsFragment")?.addToBackStack(null)
                ?.commit()
        }


/*

        val videoUri = Uri.parse("android.resource://" + requireContext().packageName + "/" + R.raw.videohd );
        binding.videoViewMain.setVideoURI(videoUri);
        binding.videoViewMain.start();
        binding.videoViewMain.setOnCompletionListener {
            binding.videoViewMain.start();
            it.release()
        }
*/


        val uri = Uri.parse("android.resource://"
                                + requireContext().packageName
                                + "/"
                                + R.raw.violinvideo)

        binding.videoViewMain.setVideoURI(uri)
        binding.videoViewMain.start()


        binding.videoViewMain.setOnPreparedListener { mp->
            vMediaPlayer = mp
            vMediaPlayer.isLooping = true

            if (currentVideoPosition!=0){
                vMediaPlayer.seekTo(currentVideoPosition)
                vMediaPlayer.start()
            }
        }


        return binding.root
    }


    override fun onPause() {
        binding.videoViewMain.suspend()
        super.onPause()
    }

/*
    override fun onPause() {
        super.onPause()
        currentVideoPosition = vMediaPlayer.currentPosition
        binding.videoViewMain.pause()
    }*/

    override fun onStart() {
        binding.videoViewMain.start()
        super.onStart()
    }

    override fun onResume() {
        binding.videoViewMain.resume()
        super.onResume()

    }

       override fun onDestroy() {
           binding.videoViewMain.stopPlayback()
           super.onDestroy()
       }
}