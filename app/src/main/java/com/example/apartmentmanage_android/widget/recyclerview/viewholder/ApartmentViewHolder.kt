package com.example.apartmentmanage_android.widget.recyclerview.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.widget.recyclerview.CustomRecyclerView
import com.example.apartmentmanage_android.widget.recyclerview.item.ApartmentItem
import kotlinx.android.synthetic.main.item_apartment.view.*

class ApartmentViewHolder(viewGroup: ViewGroup, private val onActionListener: OnActionListener) :
    CustomRecyclerView.ViewHolder<ApartmentItem>(
        newInstance(viewGroup)
    ) {

    override fun bind(item: ApartmentItem) {
        itemView.nameApartmentTextView.text = item.apartmentEntity.name
        itemView.apartmentIDTextView.text = item.apartmentEntity.ID
        handleEvents(item)
    }

    private fun handleEvents(item: ApartmentItem) {
        itemView.popupMenuButton.setOnClickListener {
            val popupMenu = PopupMenu(it.context, it).apply {
                inflate(R.menu.menu_option_recyclerview)
            }
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.edit_menu -> {
                        onActionListener.onEditListener(item)
                        true
                    }
                    R.id.delete_menu -> {
                        onActionListener.onDeleteListener(item.apartmentEntity.ID)
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }
    }

    interface OnActionListener {
        fun onEditListener(item: ApartmentItem)
        fun onDeleteListener(apartmentID: String)
    }

    companion object {
        fun newInstance(viewGroup: ViewGroup): View {
            return LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_apartment, viewGroup, false)
        }
    }
}
