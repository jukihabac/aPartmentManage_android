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
        fun bindContractRepository(repository: ContractRepositoryImpl): ContractRepository

        @AppScoped
        @Binds
        fun bindFamilyRepository(repository: FamilyRepositoryImpl): FamilyRepository

        @AppScoped
        @Binds
        fun bindRegionRepository(repository: RegionRepositoryImpl): RegionRepository

        @AppScoped
        @Binds
        fun bindEmployeeRepository(repository: EmployeeRepositoryImpl): EmployeeRepository

        @AppScoped
        @Binds
        fun bindMemberRepository(repository: MemberRepositoryImpl): MemberRepository

        @AppScoped
        @Binds
        fun bindAccountRepository(repository: AccountRepositoryImpl): AccountRepository
    }
}
