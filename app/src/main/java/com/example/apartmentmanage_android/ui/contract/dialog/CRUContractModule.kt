package com.example.apartmentmanage_android.ui.contract.dialog

import com.example.apartmentmanage_android.di.scopes.ActivityScoped
import dagger.Binds
import dagger.Module

@Module(includes = [CRUContractModule.CRUContractAbstractModule::class])
class CRUContractModule {

    @Module
    interface CRUContractAbstractModule {
        @ActivityScoped
        @Binds
        fun bindCRUContractView(cRUContractActivity: CRUContractActivity): CRUContractContract.View

        @ActivityScoped
        @Binds
        fun bindCRUContractPresenter(presenter: CRUContractPresenter): CRUContractContract.Presenter
    }
}
