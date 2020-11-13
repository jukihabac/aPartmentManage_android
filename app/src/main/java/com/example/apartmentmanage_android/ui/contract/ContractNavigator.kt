package com.example.apartmentmanage_android.ui.contract

import android.content.Intent
import com.example.apartmentmanage_android.app.Constants
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ContractEntity
import com.example.apartmentmanage_android.ui.contract.dialog.CRUContractActivity
import com.example.apartmentmanage_android.utils.ActivityUtils
import javax.inject.Inject

interface ContractNavigator {
    fun navigateToAddContract()
    fun navigateToUpdateContract(contractEntity: ContractEntity)
}

class ContractNavigatorImpl @Inject constructor(private val fragment: ContractFragment) :
    ContractNavigator {
    override fun navigateToAddContract() {
        ActivityUtils.startActivityForResultSlideByFragment(
            fragment,
            fragment.context,
            CRUContractActivity.newInstance(fragment.context),
            Constants.REQUEST_ADD
        )
    }

    override fun navigateToUpdateContract(contractEntity: ContractEntity) {
        ActivityUtils.startActivityForResultSlideByFragment(
            fragment,
            fragment.context,
            CRUContractActivity.newInstance(fragment.context, contractEntity),
            Constants.REQUEST_UPDATE
        )
    }
}
