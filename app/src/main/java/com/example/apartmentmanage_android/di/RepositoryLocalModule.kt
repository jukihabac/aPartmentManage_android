package com.example.apartmentmanage_android.di

import com.example.apartmentmanage_android.data.repositories.local.*
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
        fun bindFamilyRepository(repository: FamilyRepositoryImpl): FamilyRepository

        @AppScoped
        @Binds
        fun bindRegionRepository(repository: RegionRepositoryImpl): RegionRepository
    }
}
