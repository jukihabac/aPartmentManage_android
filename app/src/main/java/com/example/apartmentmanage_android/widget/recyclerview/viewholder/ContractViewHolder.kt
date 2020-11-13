package com.example.apartmentmanage_android.widget.recyclerview.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ContractEntity
import com.example.apartmentmanage_android.widget.recyclerview.CustomRecyclerView
import com.example.apartmentmanage_android.widget.recyclerview.item.ContractItem
import kotlinx.android.synthetic.main.item_contract.view.*
import kotlinx.android.synthetic.main.item_contract.view.popupMenuButton

class ContractViewHolder(viewGroup: ViewGroup, private val onActionListener: OnActionListener) :
    CustomRecyclerView.ViewHolder<ContractItem>(
        newInstance(viewGroup)
    ) {

    override fun bind(item: ContractItem) {
        itemView.nameContractTextView.text = item.contractEntity.name
        itemView.idContractTextView.text = item.contractEntity.ID
        handleEvents(item)
    }

    private fun handleEvents(item: ContractItem) {
        itemView.popupMenuButton.setOnClickListener {
            val popupMenu = PopupMenu(it.context, it).apply {
                inflate(R.menu.menu_option_recyclerview)
            }
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.edit_menu -> {
                        onActionListener.onEditListener(item.contractEntity)
                        true
                    }
                    R.id.delete_menu -> {
                        onActionListener.onDeleteListener(item.contractEntity.ID)
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }
    }

    interface OnActionListener {
        fun onEditListener(contractEntity: ContractEntity)
        fun onDeleteListener(contractID: String)
    }

    companion object {
        fun newInstance(viewGroup: ViewGroup): View {
            return LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_contract, viewGroup, false)
        }
    }
}
