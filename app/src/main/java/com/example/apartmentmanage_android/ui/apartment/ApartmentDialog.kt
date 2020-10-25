package com.example.apartmentmanage_android.ui.apartment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.apartmentmanage_android.R
import kotlinx.android.synthetic.main.dialog_apartment.*

class ApartmentDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_apartment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initAnimation()
        setupViews()
        setupData()
        handleEvents()
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

    private fun setupData() {
        /* val regionIDs = arrayOf("Item 1", "Item 2", "Item 3", "Item 4")
       val adapter = context?.let {
           ArrayAdapter(
               it,
               R.layout.dropdown_menu,
               regionIDs
           )
       }
       regionID_dropdown.setAdapter(adapter)*/
    }

    private fun initAnimation() {
        dialog?.window?.attributes?.windowAnimations = R.style.DialogAnimation
    }

    private fun setupViews() {
        //no-op
    }

    private fun handleEvents() {
        previousButton.setOnClickListener {
            dismiss()
        }
    }

    companion object {
        val TAG = ApartmentDialog::class.java.simpleName
        fun newInstance() = ApartmentDialog()
    }
}
