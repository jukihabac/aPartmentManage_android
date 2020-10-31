package com.example.apartmentmanage_android.ui.apartment.dialog

import com.example.apartmentmanage_android.di.scopes.ActivityScoped
import dagger.Binds
import dagger.Module

@Module(includes = [CRUApartmentModule.CRUApartmentAbstractModule::class])
class CRUApartmentModule {

    @Module
    interface CRUApartmentAbstractModule {
        @ActivityScoped
        @Binds
        fun bindCRUApartmentView(CRUApartmentActivity: CRUApartmentActivity): CRUApartmentContract.View

        @ActivityScoped
        @Binds
        fun bindCRUApartmentPresenter(presenterCRU: CRUApartmentPresenter): CRUApartmentContract.Presenter
    }
}
