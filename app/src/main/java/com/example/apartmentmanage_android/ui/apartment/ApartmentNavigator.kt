package com.example.apartmentmanage_android.ui.apartment

import android.content.Intent
import com.example.apartmentmanage_android.app.Constants
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ApartmentEntity
import com.example.apartmentmanage_android.ui.apartment.dialog.CRUApartmentActivity
import com.example.apartmentmanage_android.ui.contract.dialog.CRUContractActivity
import com.example.apartmentmanage_android.utils.ActivityUtils
import javax.inject.Inject

interface ApartmentNavigator {
    fun navigateToAddApartment()
    fun navigateToUpdateApartment(apartmentEntity: ApartmentEntity)
}

class ApartmentNavigatorImpl @Inject constructor(private val fragment: ApartmentFragment) :
    ApartmentNavigator {

    override fun navigateToAddApartment() {
        val intent = Intent(fragment.context, CRUApartmentActivity::class.java).apply {
            putExtra("REQUEST_ADD", Constants.REQUEST_ADD)
        }
        ActivityUtils.startActivityForResultSlideByFragment(
            fragment, fragment.context,
            intent,
            Constants.REQUEST_ADD
        )
    }

    override fun navigateToUpdateApartment(apartmentEntity: ApartmentEntity) {
        val intent = Intent(fragment.context, CRUContractActivity::class.java).apply {
            putExtra("REQUEST_UPDATE", Constants.REQUEST_UPDATE)
            putExtra("apartmentEntity", apartmentEntity)
        }
        ActivityUtils.startActivityForResultSlideByFragment(
            fragment,
            fragment.context,
            intent,
            Constants.REQUEST_UPDATE
        )
    }
}
