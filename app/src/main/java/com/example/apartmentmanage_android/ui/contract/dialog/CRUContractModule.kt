package com.example.apartmentmanage_android.ui.contract.dialog

import dagger.Module

@Module(includes = [CRUContractModule.CRUContractAbstractModule::class])
class CRUContractModule {

    @Module
    interface CRUContractAbstractModule
}
