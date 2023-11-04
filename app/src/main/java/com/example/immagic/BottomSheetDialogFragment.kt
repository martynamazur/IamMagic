package com.example.immagic
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class YourBottomSheetDialogFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.your_bottom_sheet_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tutaj możesz obsługiwać elementy interfejsu użytkownika w Twoim BottomSheetDialogFragment

        val bottomSheetButton = view.findViewById<Button>(R.id.bottomSheetButton)

        bottomSheetButton.setOnClickListener {

            dismiss()
        }
    }
}
