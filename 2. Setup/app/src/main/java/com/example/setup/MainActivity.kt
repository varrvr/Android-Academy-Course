package com.example.setup

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textView : TextView = findViewById(R.id.textHello)
        textView.setOnClickListener{moveToNextScreen()}

    }

    private fun moveToNextScreen() {
        val intent = Intent(this, SecondActivity::class.java)

        val transmittedInt = 13
        intent.putExtra(SecondActivity.TRANSMITTED_INT, transmittedInt)


        startActivity(intent)

    }
}