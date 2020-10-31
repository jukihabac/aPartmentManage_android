package com.example.apartmentmanage_android.ui.apartment.dialog

import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.FamilyEntity
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.RegionEntity
import com.example.apartmentmanage_android.ui.BasePresenter

interface CRUApartmentContract {
    interface Presenter : BasePresenter {
        fun getRegionIDs()
        fun getFamilyIDs()
    }

    interface View {
        fun onSuccessRegionIDs(region: List<RegionEntity>)
        fun onSuccessFamilyIDs(family: List<FamilyEntity>)
        fun onError(error: String)
    }
}
