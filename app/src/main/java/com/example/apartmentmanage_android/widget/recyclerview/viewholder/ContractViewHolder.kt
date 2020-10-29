package com.example.apartmentmanage_android.widget.recyclerview.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.widget.recyclerview.CustomRecyclerView
import com.example.apartmentmanage_android.widget.recyclerview.item.ContractItem
import kotlinx.android.synthetic.main.item_contract.view.*

class ContractViewHolder(viewGroup: ViewGroup) : CustomRecyclerView.ViewHolder<ContractItem>(
    newInstance(viewGroup)
) {

    override fun bind(item: ContractItem) {
        itemView.nameContract.text = item.contractEntity.name
    }

    companion object {
        fun newInstance(viewGroup: ViewGroup): View {
            return LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_contract, viewGroup, false)
        }
    }
}
