package com.example.apartmentmanage_android.ui.apartment.dialog

import com.example.apartmentmanage_android.di.scopes.ActivityScoped
import com.example.apartmentmanage_android.di.scopes.FragmentScoped
import dagger.Binds
import dagger.Module

@Module(includes = [CRUApartmentModule.CRUApartmentAbstractModule::class])
class CRUApartmentModule {

    @Module
    interface CRUApartmentAbstractModule {
        @ActivityScoped
        @Binds
        fun bindCRUApartmentView(CURApartment: CURApartment): CRUApartmentContract.View

        @ActivityScoped
        @Binds
        fun bindCRUApartmentPresenter(presenterCRU: CRUApartmentPresenter): CRUApartmentContract.Presenter
    }
}
