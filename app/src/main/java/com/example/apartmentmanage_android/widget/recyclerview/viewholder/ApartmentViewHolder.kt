package com.example.apartmentmanage_android.widget.recyclerview.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.widget.recyclerview.CustomRecyclerView
import com.example.apartmentmanage_android.widget.recyclerview.item.ApartmentItem
import kotlinx.android.synthetic.main.item_apartment.view.*

class ApartmentViewHolder(viewGroup: ViewGroup) : CustomRecyclerView.ViewHolder<ApartmentItem>(
    newInstance(viewGroup)
) {

    override fun bind(item: ApartmentItem) {
        itemView.nameApartment.text = item.apartmentEntity.name
    }

    companion object {
        fun newInstance(viewGroup: ViewGroup): View {
            return LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_apartment, viewGroup, false)
        }
    }
}
