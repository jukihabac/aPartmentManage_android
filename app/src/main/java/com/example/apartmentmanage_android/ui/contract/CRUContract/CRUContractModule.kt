package com.example.apartmentmanage_android.ui.contract.CRUContract

import dagger.Module

@Module(includes = [CRUContractModule.CRUContractAbstractModule::class])
class CRUContractModule {

    @Module
    interface CRUContractAbstractModule
}