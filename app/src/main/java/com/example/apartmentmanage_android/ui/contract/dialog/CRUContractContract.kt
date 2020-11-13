package com.example.apartmentmanage_android.ui.contract.dialog

import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ApartmentEntity
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.EmployeeEntity
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.FamilyEntity
import com.example.apartmentmanage_android.ui.BasePresenter

interface CRUContractContract {
    interface Presenter : BasePresenter {
        fun getEmployeeIDs()
        fun getApartmentIDs()
        fun getFamilyIDs()
        fun sumCost()
    }
    interface View{
        fun onSuccessEmployeeIDs(employee : List<EmployeeEntity>)
        fun onSuccessApartmentIDs(Apartment : List<ApartmentEntity>)
        fun onSuccessFamilyIDs(family : List<FamilyEntity>)
        fun onError(error: String)
    }
}
