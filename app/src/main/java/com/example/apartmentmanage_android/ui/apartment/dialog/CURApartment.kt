package com.example.apartmentmanage_android.ui.apartment.dialog

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.FamilyEntity
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.RegionEntity
import com.example.apartmentmanage_android.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_cru_apartment.*
import javax.inject.Inject

class CURApartment : BaseActivity(), CRUApartmentContract.View {

    @Inject
    lateinit var mPresenter: CRUApartmentContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cru_apartment)
        setupViews()
        setupData()
        handleEvents()
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

    override fun onSuccessRegionIDs(region: List<RegionEntity>) {
        val regionIDs = arrayOf(region.map { it.ID })
        val adapter = ArrayAdapter(
            this,
            R.layout.dropdown_menu,
            regionIDs
        )
        regionID_dropdown.setAdapter(adapter)
    }

    override fun onSuccessFamilyIDs(family: List<FamilyEntity>) {
        val familyIDs = arrayOf(family.map { it.ID })
        val adapter = ArrayAdapter(
            this,
            R.layout.dropdown_menu,
            familyIDs
        )
        familyID_dropdown.setAdapter(adapter)
    }

    override fun onError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    private fun setupData() {
        mPresenter.getFamilyIDs()
        mPresenter.getRegionIDs()
    }

    private fun setupViews() {
        //no-op
    }

    private fun handleEvents() {
        previousButton.setOnClickListener {
        }
        submitButton.setOnClickListener {
        }
    }

    companion object {
        val TAG = CURApartment::class.java.simpleName
        fun newInstance() = CURApartment()
    }
}
