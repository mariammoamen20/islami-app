package com.example.islami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islami.hadeath.HadeathFragment
import com.example.islami.quran.suraname.QuranFragment
import com.example.islami.radio.RadioFragment
import com.example.islami.sebha.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottom_navigation_view:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation_view =findViewById(R.id.bottom_navigation_view)
        bottom_navigation_view.setOnItemSelectedListener {
            if (it.itemId == R.id.quran_screen){
                pushFragment(QuranFragment())
            }else if(it.itemId == R.id.hadeath_screen){
                pushFragment(HadeathFragment())
            }else if(it.itemId==R.id.sebha_screen){
               pushFragment(SebhaFragment())
            }else if(it.itemId==R.id.radio_screen){
                pushFragment(RadioFragment())
            }
            return@setOnItemSelectedListener true
        }
        bottom_navigation_view.selectedItemId = R.id.quran_screen

    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout_container, fragment)
            .commit()
    }
}