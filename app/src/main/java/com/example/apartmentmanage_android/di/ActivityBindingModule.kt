package com.example.apartmentmanage_android.di

import com.example.apartmentmanage_android.di.scopes.ActivityScoped
import com.example.apartmentmanage_android.ui.apartment.dialog.CRUApartmentModule
import com.example.apartmentmanage_android.ui.apartment.dialog.CRUApartmentActivity
import com.example.apartmentmanage_android.ui.contract.dialog.CRUContractActivity
import com.example.apartmentmanage_android.ui.contract.dialog.CRUContractModule
import com.example.apartmentmanage_android.ui.main.MainActivity
import com.example.apartmentmanage_android.ui.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [CRUContractModule::class])
    abstract fun contributeCRUContractActivity(): CRUContractActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [CRUApartmentModule::class])
    abstract fun contributeCRUApartment(): CRUApartmentActivity
}
