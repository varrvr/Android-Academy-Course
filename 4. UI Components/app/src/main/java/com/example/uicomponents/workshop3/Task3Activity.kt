package com.example.uicomponents.workshop3
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uicomponents.R

class Task3Activity : AppCompatActivity(), Task3RootFragment.ClickListener {

    private val rootFragment =
        Task3RootFragment().apply { setListener(this@Task3Activity) }
    private val secondFragment = Task3SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)

        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.persistent_container, rootFragment)
                add(R.id.fragments_container, secondFragment)
                commit()
            }
    }

    override fun increaseValue() {
        secondFragment.increaseValue()
    }

    override fun changeBackground() {
        secondFragment.changeBackground()
    }
}