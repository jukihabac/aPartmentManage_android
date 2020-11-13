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
        fun onGetApartmentSuccess(apartments: List<ApartmentEntity>)
        fun onAddApartmentSuccess(apartmentEntity: ApartmentEntity)
        fun onUpdateApartmentSuccess(apartmentEntity: ApartmentEntity)
        fun onDeleteApartmentSuccess(apartmentID: String)
        fun onError(error: String)
    }
}
