package com.example.uicomponents.workshop4

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.uicomponents.R

class DialogFragments : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_fragments, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_ok)?.apply {
            setOnClickListener {
                Toast.makeText(context, "you tapped ok", Toast.LENGTH_SHORT).show()
                dismiss()
            }
        }

        view.findViewById<Button>(R.id.btn_cancel)?.apply {
            setOnClickListener {
                Toast.makeText(context, "you tapped cancel", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)

        Toast.makeText(context, "you dismissed dialog", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog?.window?.setLayout(width, height)
    }
}