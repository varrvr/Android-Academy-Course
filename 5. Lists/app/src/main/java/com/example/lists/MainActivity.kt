package com.example.lists

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lists.workshop1.WS1ActorsFragment
import com.example.lists.workshop2.WS2ActorsFragment
import com.example.lists.workshop3.WS3ActorsFragment
import com.example.lists.workshop4.WS4DiffUtilsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WS4DiffUtilsFragment.newInstance())
                .commit()
        }
    }
}