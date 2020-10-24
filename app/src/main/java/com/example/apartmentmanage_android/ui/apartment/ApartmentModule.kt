package com.example.apartmentmanage_android.ui.apartment

import com.example.apartmentmanage_android.di.scopes.FragmentScoped
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [ApartmentModule.ApartmentAbstractModule::class])
class ApartmentModule {

    @FragmentScoped
    @Provides
    fun bindApartmentAdapter(): ApartmentAdapter {
        return ApartmentAdapter()
    }

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
