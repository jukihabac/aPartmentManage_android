package com.example.apartmentmanage_android.ui.contract

import android.view.ViewGroup
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ContractEntity
import com.example.apartmentmanage_android.widget.recyclerview.CustomRecyclerView
import com.example.apartmentmanage_android.widget.recyclerview.item.ContractItem
import com.example.apartmentmanage_android.widget.recyclerview.viewholder.ContractViewHolder

class ContractAdapter :
    CustomRecyclerView.Adapter<ContractViewHolder>(
        arrayListOf()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomRecyclerView.ViewHolder<*> {
        return ContractViewHolder(parent)
    }

    fun addContracts(mContracts: List<ContractEntity>) {
        addItems(mContracts.map { ContractItem(it) })
    }

    fun addContract(mContract : ContractEntity){
        addItem(ContractItem(mContract))
    }
}
