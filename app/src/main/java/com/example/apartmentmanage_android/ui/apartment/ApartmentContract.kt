package com.example.apartmentmanage_android.ui.apartment

import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ApartmentEntity
import com.example.apartmentmanage_android.ui.BasePresenter

interface ApartmentContract {
    interface Presenter : BasePresenter {
        fun deleteApartment(apartmentID: String)
        fun updateApartment(apartmentEntity: ApartmentEntity)
        fun addApartment(apartmentEntity: ApartmentEntity)
        fun getApartments()
    }

    interface View {
        fun onSuccessGetApartment(apartments: List<ApartmentEntity>)
        fun onSuccess()
        fun onError(error: String)
    }
}
