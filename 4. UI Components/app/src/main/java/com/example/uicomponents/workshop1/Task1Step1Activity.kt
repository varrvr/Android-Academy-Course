package com.example.uicomponents.workshop1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.uicomponents.R
import com.example.uicomponents.databinding.ActivityTask1Step1Binding

class Task1Step1Activity : AppCompatActivity() {

    private var counter = 0

    private var tvValue: AppCompatTextView? = null
    private var btnIncrementer: AppCompatButton? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "$LOG_PREFIX::onCreate")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_task1_step1)

        setupUI()
        if (savedInstanceState == null) {
            updateData(counter)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "$LOG_PREFIX::onSaveInstanceState")
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT_ARGUMENT, counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "$LOG_PREFIX::onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt(KEY_COUNT_ARGUMENT)
        updateData(counter)
    }

    override fun onDestroy() {
        Log.d(TAG, "$LOG_PREFIX::onDestroy")
        super.onDestroy()
    }

    private fun updateData(value: Int) {
        tvValue?.text = getString(R.string.value, counter)
    }

    private fun setupUI() {
        tvValue = findViewById(R.id.tvCounter)
        btnIncrementer = findViewById<AppCompatButton>(R.id.btnClicker).apply {
            setOnClickListener {
                counter++
                updateData(counter)
            }
        }
    }

    companion object {
        private const val KEY_COUNT_ARGUMENT = "KEY_COUNT_ARGUMENT"
        private const val TAG = "WS1Step1Activity"
        private const val LOG_PREFIX = "WS1ST1"
    }
}