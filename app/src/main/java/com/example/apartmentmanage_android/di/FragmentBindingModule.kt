package com.example.apartmentmanage_android.di

import com.example.apartmentmanage_android.di.scopes.FragmentScoped
import com.example.apartmentmanage_android.ui.apartment.ApartmentFragment
import com.example.apartmentmanage_android.ui.apartment.ApartmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {
    @FragmentScoped
    @ContributesAndroidInjector(modules = [ApartmentModule::class])
    abstract fun contributeApartmentFragment(): ApartmentFragment

}
