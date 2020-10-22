package com.example.apartmentmanage_android.ui.apartment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ApartmentEntity
import com.example.apartmentmanage_android.ui.BaseFragment
import javax.inject.Inject

class ApartmentFragment : BaseFragment(), ApartmentContract.View {

    @Inject
    lateinit var mPresenter: ApartmentContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_apartment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        mPresenter.onStart()
        super.onStart()
    }

    override fun onStop() {
        mPresenter.onStop()
        super.onStop()
    }

    override fun onDestroy() {
        mPresenter.onDestroy()
        super.onDestroy()
    }

    override fun onSuccessGetApartment(apartments: List<ApartmentEntity>) {
        //no-op
    }

    override fun onSuccess() {
        //no-op
    }

    override fun onError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance() = ApartmentFragment()
    }
}
