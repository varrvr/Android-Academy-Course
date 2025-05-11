package com.example.lists

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lists.workshop1.WS1ActorsFragment
import com.example.lists.workshop2.WS2ActorsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WS2ActorsFragment.newInstance())
                .commit()
        }
    }
}