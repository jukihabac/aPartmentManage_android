package com.example.apartmentmanage_android.ui.apartment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apartmentmanage_android.R

class ApartmentFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_apartment, container, false)
    }

    companion object {
        fun newInstance() = ApartmentFragment()
    }
}
