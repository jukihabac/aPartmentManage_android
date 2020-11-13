package com.example.apartmentmanage_android.ui.apartment

import com.example.apartmentmanage_android.app.Constants
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ApartmentEntity
import com.example.apartmentmanage_android.ui.apartment.dialog.CRUApartmentActivity
import com.example.apartmentmanage_android.utils.ActivityUtils
import javax.inject.Inject

interface ApartmentNavigator {
    fun navigateToAddApartment()
    fun navigateToUpdateApartment(apartmentEntity: ApartmentEntity)
}

class ApartmentNavigatorImpl @Inject constructor(private val fragment: ApartmentFragment) :
    ApartmentNavigator {

    override fun navigateToAddApartment() {
        ActivityUtils.startActivityForResultSlideByFragment(
            fragment, fragment.context,
            CRUApartmentActivity.newInstance(fragment.context),
            Constants.REQUEST_ADD
        )
    }

    override fun navigateToUpdateApartment(apartmentEntity: ApartmentEntity) {
        ActivityUtils.startActivityForResultSlideByFragment(
            fragment,
            fragment.context,
            CRUApartmentActivity.newInstance(fragment.context, apartmentEntity),
            Constants.REQUEST_UPDATE
        )
    }
}
