package com.example.apartmentmanage_android.ui.contract

import com.example.apartmentmanage_android.di.scopes.FragmentScoped
import dagger.Binds
import dagger.Module


@Module(includes = [ContractModule.ContractAbstractModule::class])
class ContractModule {

    @Module
    interface ContractAbstractModule {
        @FragmentScoped
        @Binds
        fun bindContractView(contractFragment: ContractFragment): ContractContract.View

        @FragmentScoped
        @Binds
        fun bindContractPresenter(presenter: ContractPresenter): ContractContract.Presenter

        @FragmentScoped
        @Binds
        fun bindContractNavigator(navigator: ContractNavigatorImpl): ContractNavigator
    }
}
