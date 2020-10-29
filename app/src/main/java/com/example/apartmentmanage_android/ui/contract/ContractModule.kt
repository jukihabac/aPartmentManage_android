package com.example.apartmentmanage_android.ui.contract

import com.example.apartmentmanage_android.di.scopes.FragmentScoped
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [ContractModule.ContractAbstractModule::class])
class ContractModule {

    @FragmentScoped
    @Provides
    fun bindContractAdapter(): ContractAdapter {
        return ContractAdapter()
    }

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
