package com.example.apartmentmanage_android.di

import com.example.apartmentmanage_android.data.repositories.local.ApartmentRepository
import com.example.apartmentmanage_android.data.repositories.local.ApartmentRepositoryImpl
import com.example.apartmentmanage_android.data.repositories.local.ContractRepository
import com.example.apartmentmanage_android.data.repositories.local.ContractRepositoryImpl
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

        @AppScoped
        @Binds
        fun bindContractRepository(repository: ContractRepositoryImpl): ContractRepository
    }
}
