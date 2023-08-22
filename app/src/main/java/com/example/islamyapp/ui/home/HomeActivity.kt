package com.example.islamyapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islamyapp.R
import com.example.islamyapp.databinding.ActivityHomeBinding
import com.example.islamyapp.ui.home.tabs.hadeath.HadeathFragment
import com.example.islamyapp.ui.home.tabs.quran.QuranFragment
import com.example.islamyapp.ui.home.tabs.radio.RadioFragment
import com.example.islamyapp.ui.home.tabs.sebha.SebhaFragment
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        viewBinding.content.bottomNavView.setOnItemSelectedListener(object :NavigationBarView.OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.navigation_quran->{
                        showTabFragment(QuranFragment())
                    }
                    R.id.navigation_hadeath->{
                        showTabFragment(HadeathFragment())
                    }
                    R.id.navigation_radio->{
                        showTabFragment(RadioFragment())
                    }
                    R.id.navigation_sebha->{
                        showTabFragment(SebhaFragment())
                    }
                }
                return true
            }
        })
        viewBinding.content.bottomNavView.selectedItemId =R.id.navigation_quran

    }


    private fun showTabFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()
    }
}