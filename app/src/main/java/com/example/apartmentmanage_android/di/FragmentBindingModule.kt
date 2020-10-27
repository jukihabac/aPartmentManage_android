package com.example.apartmentmanage_android.di

import com.example.apartmentmanage_android.di.scopes.FragmentScoped
import com.example.apartmentmanage_android.ui.apartment.dialog.CURApartment
import com.example.apartmentmanage_android.ui.apartment.dialog.CRUApartmentModule
import com.example.apartmentmanage_android.ui.apartment.ApartmentFragment
import com.example.apartmentmanage_android.ui.apartment.ApartmentModule
import com.example.apartmentmanage_android.ui.contract.ContractFragment
import com.example.apartmentmanage_android.ui.contract.ContractModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {
    @FragmentScoped
    @ContributesAndroidInjector(modules = [ApartmentModule::class])
    abstract fun contributeApartmentFragment(): ApartmentFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = [ContractModule::class])
    abstract fun contributeContractFragment(): ContractFragment
}
