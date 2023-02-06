package com.example.georgianphil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.example.georgianphil.MainFragments.ConcertsFragment
import com.example.georgianphil.MainFragments.*
import com.example.georgianphil.databinding.ActivityMain2Binding
import kotlinx.android.synthetic.main.my_toolbar.*

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

      /*  setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.main_activity)*/

       replaceFragment(ConcertsFragment())
/*
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        navController = navHostFragment.navController

        setupWithNavController(binding.bottomNavView,navController)*/

   binding.bottomNavView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.concertsFragment ->replaceFragment(ConcertsFragment())
                R.id.videosFragment ->replaceFragment(VideosFragment())
                R.id.ticketsFragment ->replaceFragment(TicketsFragment())
                R.id.searchFragment ->replaceFragment(SearchFragment())
                R.id.loginFragment ->replaceFragment(LoginFragment())

                else ->{

                }
            }
            true
        }

    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager= supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainContainer,fragment)
        fragmentTransaction.commit()
    }
}