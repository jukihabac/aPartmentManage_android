package com.example.apartmentmanage_android.ui.contract

import com.example.apartmentmanage_android.ui.BasePresenter

interface ContractContract {
    interface Presenter : BasePresenter {
        fun getContracts()
    }

    interface View {
        fun onSuccess()
        fun onError(error: String)
    }
}
