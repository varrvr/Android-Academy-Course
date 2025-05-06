package com.example.uicomponents.workshop4

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.uicomponents.R
import com.google.android.material.snackbar.Snackbar

class Task4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_task4)
        findViewById<Button>(R.id.btn_show_alert_dialog)?.apply {
            setOnClickListener {
                AlertDialog.Builder(context)
                    .setTitle("Alert!!")
                    .setPositiveButton("ok") { _, _ ->
                        Toast.makeText(context, "you called ok", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .setNegativeButton("cancel") { _, _ ->
                        Toast.makeText(context, "you called cancel", Toast.LENGTH_SHORT).show()
                    }
                    .setNeutralButton("retry") { _, _ ->
                        Toast.makeText(context, "you called retry", Toast.LENGTH_SHORT).show()
                    }
                    .setOnCancelListener {
                        Toast.makeText(context, "alert dismissed", Toast.LENGTH_SHORT).show()
                    }
                    .show()
            }
        }

        findViewById<Button>(R.id.btn_show_dialog_fragment)?.apply {
            setOnClickListener {
                val dialog = DialogFragments()

                dialog.show(supportFragmentManager, "dialogFragment")
            }
        }

        findViewById<Button>(R.id.btn_show_dialog_fragment)?.apply {
            setOnClickListener {
                val dialog = DialogFragments()

                dialog.show(supportFragmentManager, "dialogFragment")
            }
        }

        findViewById<Button>(R.id.btn_show_time_picker)?.apply {
            setOnClickListener {
                val c = Calendar.getInstance()
                val hour = c.get(Calendar.HOUR_OF_DAY)
                val minute = c.get(Calendar.MINUTE)

                val timePickerDialog = TimePickerDialog(
                    this@Task4Activity,
                    { p0, p1, p2 ->
                        Snackbar.make(
                            rootView,
                            "you choosed $p1:$p2",
                            Snackbar.LENGTH_SHORT
                        )
                            .show()
                    },
                    hour,
                    minute,
                    true
                )

                timePickerDialog.show()
            }
        }

        findViewById<Button>(R.id.btn_show_date_picker)?.apply {
            setOnClickListener {
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

                val datePickerDialog = DatePickerDialog(
                    this@Task4Activity,
                    { p0, p1, p2, p3 ->
                        Snackbar.make(
                            rootView,
                            "you choosed $p3/$p2/$p1",
                            Snackbar.LENGTH_SHORT
                        )
                            .show()
                    },
                    year,
                    month,
                    day
                )

                datePickerDialog.show()
            }
        }

        findViewById<Button>(R.id.btn_show_bottom_sheet_dialog)?.apply {
            setOnClickListener {
                val dialog = SampleBottomSheet()

                dialog.show(supportFragmentManager, "dialogFragment")
            }
        }
    }
}