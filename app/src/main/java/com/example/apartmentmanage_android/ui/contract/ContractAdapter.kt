package com.example.apartmentmanage_android.ui.contract

import android.view.ViewGroup
import com.example.apartmentmanage_android.app.Constants
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ContractEntity
import com.example.apartmentmanage_android.widget.recyclerview.CustomRecyclerView
import com.example.apartmentmanage_android.widget.recyclerview.item.ContractItem
import com.example.apartmentmanage_android.widget.recyclerview.viewholder.ContractViewHolder

class ContractAdapter :
    CustomRecyclerView.Adapter<ContractViewHolder>(
        arrayListOf()
    ), ContractViewHolder.OnActionListener {

    private var mOnActionListener: OnActionListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomRecyclerView.ViewHolder<*> {
        return ContractViewHolder(parent, this)
    }

    override fun onEditListener(contractEntity: ContractEntity) {
        mOnActionListener?.onEditListener(contractEntity)
    }

    override fun onDeleteListener(contractID: String) {
        mOnActionListener?.onDeleteListener(contractID)
    }

    fun setOnActionListener(onActionListener: OnActionListener) {
        this.mOnActionListener = onActionListener
    }

    fun addContracts(mContracts: List<ContractEntity>) {
        addItems(mContracts.map { ContractItem(it) })
    }

    fun addContract(contractEntity: ContractEntity) {
        addItem(ContractItem(contractEntity))
    }

    fun removeContract(contractID: String) {
        val index = mItems.indexOfFirst {
            it as ContractItem
            it.contractEntity.ID == contractID
        }
        if (index != Constants.NOT_EXISTS) {
            mItems.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    fun updateContract(contractEntity: ContractEntity) {
        val index = mItems.indexOfFirst {
            it as ContractItem
            it.contractEntity.ID == contractEntity.ID
        }
        if (index != Constants.NOT_EXISTS) {
            replaceItem(ContractItem(contractEntity), index)
        }
    }

    interface OnActionListener {
        fun onEditListener(contractEntity: ContractEntity)
        fun onDeleteListener(contractID: String)
    }
}
