package com.example.apartmentmanage_android.widget.recyclerview.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.widget.recyclerview.CustomRecyclerView
import com.example.apartmentmanage_android.widget.recyclerview.item.NoneItem

class NoneViewHolder(viewGroup: ViewGroup) :
    CustomRecyclerView.ViewHolder<NoneItem>(newInstance(viewGroup)) {
    override fun bind(item: NoneItem) = Unit

    companion object {
        fun newInstance(viewGroup: ViewGroup): View {
            return LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_none, viewGroup, false)
        }
    }
}
