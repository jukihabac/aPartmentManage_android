package com.example.apartmentmanage_android.di

import com.example.apartmentmanage_android.data.repositories.ApartmentRepository
import com.example.apartmentmanage_android.data.repositories.ApartmentRepositoryImpl
import com.example.apartmentmanage_android.di.scopes.AppScoped
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryLocalModule.RepositoryLocalAbstractModule::class])
class RepositoryLocalModule {
    @Module
    interface RepositoryLocalAbstractModule {
        @AppScoped
        @Binds
        fun bindApartmentRepository(repository: ApartmentRepositoryImpl): ApartmentRepository
    }
}
