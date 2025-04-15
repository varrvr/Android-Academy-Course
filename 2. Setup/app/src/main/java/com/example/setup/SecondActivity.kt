package com.example.setup

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val transmittedInt : Int = intent.getIntExtra(TRANSMITTED_INT, -1)
        val textView : TextView = findViewById(R.id.second_activity_text_view)
        textView.text = "These values were passed from previous screen: $transmittedInt"
    }

        companion object {
            const val TRANSMITTED_INT = "transmittedint"
        }

}