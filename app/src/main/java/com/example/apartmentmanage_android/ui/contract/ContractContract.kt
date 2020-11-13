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
        fun onSuccessAddContract(contractEntity: ContractEntity)
        fun onSuccessDeleteContract(contractID: String)
        fun onSuccessUpdateContract(contractEntity: ContractEntity)
        fun onError(error: String)
    }
}
