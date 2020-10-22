package com.example.apartmentmanage_android.ui.apartment

import com.example.apartmentmanage_android.di.scopes.FragmentScoped
import dagger.Binds
import dagger.Module

@Module(includes = [ApartmentModule.ApartmentAbstractModule::class])
class ApartmentModule {

    @Module
    interface ApartmentAbstractModule {
        @FragmentScoped
        @Binds
        fun bindApartmentView(apartmentFragment: ApartmentFragment): ApartmentContract.View

        @FragmentScoped
        @Binds
        fun bindApartmentPresenter(presenter: ApartmentPresenter): ApartmentContract.Presenter
    }
}
