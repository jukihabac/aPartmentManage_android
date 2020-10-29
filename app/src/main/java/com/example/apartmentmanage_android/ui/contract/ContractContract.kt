package com.example.apartmentmanage_android.ui.contract

import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ContractEntity
import com.example.apartmentmanage_android.ui.BasePresenter

interface ContractContract {
    interface Presenter : BasePresenter {
        fun getContracts()
        fun addContract(contractEntity: ContractEntity)
        fun deleteContract(contractID: String)
        fun updateContract(contractEntity: ContractEntity)
    }

    interface View {
        fun onSuccessGetContracts(contracts: List<ContractEntity>)
        fun onSuccessAddContract()
        fun onSuccessDeleteContract()
        fun onSuccessUpdateContract()
        fun onError(error: String)
    }
}
