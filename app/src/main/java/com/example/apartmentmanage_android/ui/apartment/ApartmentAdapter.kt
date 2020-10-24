package com.example.apartmentmanage_android.ui.apartment

import android.view.ViewGroup
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ApartmentEntity
import com.example.apartmentmanage_android.widget.recyclerview.CustomRecyclerView
import com.example.apartmentmanage_android.widget.recyclerview.item.ApartmentItem
import com.example.apartmentmanage_android.widget.recyclerview.viewholder.ApartmentViewHolder

class ApartmentAdapter() :
    CustomRecyclerView.Adapter<ApartmentViewHolder>(
        arrayListOf()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomRecyclerView.ViewHolder<*> {
        return ApartmentViewHolder(parent)
    }

    fun addApartment(mApartments: List<ApartmentEntity>) {
        addItems(mApartments.map { ApartmentItem(it)})
    }
}
