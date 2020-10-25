package com.example.apartmentmanage_android.ui.contract

import javax.inject.Inject

interface ContractNavigator {
    fun navigateToAddContract()
}

class ContractNavigatorImpl @Inject constructor(private val fragment: ContractFragment) :
    ContractNavigator {
    override fun navigateToAddContract() {
    }
}
