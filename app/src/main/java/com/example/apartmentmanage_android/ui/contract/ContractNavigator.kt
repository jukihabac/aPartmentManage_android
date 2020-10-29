package com.example.apartmentmanage_android.ui.contract

import android.content.Intent
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ContractEntity
import com.example.apartmentmanage_android.ui.contract.CRUContract.CRUContractActivity
import javax.inject.Inject

interface ContractNavigator {
    fun navigateToAddContract()
    fun navigateToUpdateContract(contractEntity: ContractEntity)
}

class ContractNavigatorImpl @Inject constructor(private val fragment: ContractFragment) :
    ContractNavigator {
    override fun navigateToAddContract() {
        val intent = Intent(fragment.context, CRUContractActivity::class.java).apply {
            putExtra("REQUEST_ADD", ContractFragment.REQUEST_ADD)
        }
        fragment.startActivityForResult(intent, ContractFragment.REQUEST_ADD)
    }

    override fun navigateToUpdateContract(contractEntity: ContractEntity) {
        val intent = Intent(fragment.context, CRUContractActivity::class.java).apply {
            putExtra("REQUEST_UPDATE", ContractFragment.REQUEST_UPDATE)
            putExtra("contractEntity", contractEntity)
        }
        fragment.startActivityForResult(intent, ContractFragment.REQUEST_UPDATE)
    }
}
