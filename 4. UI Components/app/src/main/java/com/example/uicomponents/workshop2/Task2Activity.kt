package com.example.uicomponents.workshop2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.uicomponents.R

class Task2Activity : AppCompatActivity(), Task2RootFragment.TransactionsFragmentClicks {

    private val rootFragment =
        Task2RootFragment().apply { setClickListener(this@Task2Activity) }
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2 )

        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.persistent_container, rootFragment)
                commit()
            }
    }

    override fun addRedFragment() {
        count++
        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.fragments_container, WS02SecondFragment.newInstance(count, R.color.red))
                commit()
            }
    }

    override fun addBlueFragment() {
        count++
        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.fragments_container, WS02SecondFragment.newInstance(count, R.color.blue))
                commit()
            }
    }

    override fun removeLast() {
        if (supportFragmentManager.fragments.size > 1) {
            count--
            val lastFragment = supportFragmentManager.fragments.last()
            supportFragmentManager.beginTransaction()
                .apply {
                    remove(lastFragment)
                    commit()
                }
        }
    }

    override fun replaceFragment() {
        count = 1
        supportFragmentManager.beginTransaction()
            .apply {
                replace(
                    R.id.fragments_container,
                    WS02SecondFragment.newInstance(count, R.color.green)
                )
                commit()
            }
    }

}