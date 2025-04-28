package com.example.qqclone2

import android.os.Bundle
import android.os.WorkSource
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

//        loadFragment(MessageFragment())

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_message -> loadFragment(MessageFragment())
                R.id.navigation_contacts -> loadFragment(ContactsFragment())
                R.id.navigation_world -> loadFragment(WorldFragment())
                R.id.navigation_moments -> loadFragment(MomentsFragment())
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
