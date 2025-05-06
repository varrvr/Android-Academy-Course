package com.example.uicomponents.workshop4

import android.annotation.SuppressLint
import android.app.Dialog
import android.view.View
import androidx.core.content.ContextCompat
import com.example.uicomponents.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SampleBottomSheet : BottomSheetDialogFragment() {

    @SuppressLint("RestrictedApi")
    override fun setupDialog(
        dialog: Dialog,
        style: Int
    ) {
        val contentView =
            View.inflate(context, R.layout.fragment_dialog_fragments, null)
        dialog.setContentView(contentView)
        (contentView.parent as View).setBackgroundColor(
            ContextCompat.getColor(
                contentView.context,
                android.R.color.transparent
            )
        )
    }
}