package com.example.apartmentmanage_android.ui.apartment

import android.view.ViewGroup
import com.example.apartmentmanage_android.app.Constants
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ApartmentEntity
import com.example.apartmentmanage_android.widget.recyclerview.CustomRecyclerView
import com.example.apartmentmanage_android.widget.recyclerview.item.ApartmentItem
import com.example.apartmentmanage_android.widget.recyclerview.viewholder.ApartmentViewHolder

class ApartmentAdapter() :
    CustomRecyclerView.Adapter<ApartmentViewHolder>(
        arrayListOf()
    ), ApartmentViewHolder.OnActionListener {

    private var onActionListener: OnActionListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomRecyclerView.ViewHolder<*> {
        return ApartmentViewHolder(parent, this)
    }

    override fun onEditListener(item: ApartmentItem) {
        onActionListener?.onEditListener(item)
    }

    override fun onDeleteListener(apartmentID: String) {
        onActionListener?.onDeleteListener(apartmentID)
    }

    fun setOnActionListener(onActionListener: OnActionListener) {
        this.onActionListener = onActionListener
    }

    fun addApartments(mApartments: List<ApartmentEntity>) {
        addItems(mApartments.map { ApartmentItem(it) })
    }

    fun addApartment(apartmentEntity: ApartmentEntity) {
        addItem(ApartmentItem(apartmentEntity))
    }

    fun removeApartment(apartmentID: String) {
        val index = mItems.indexOfFirst {
            it as ApartmentItem
            it.apartmentEntity.ID == apartmentID
        }
        if (index != Constants.NOT_EXISTS) {
            mItems.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    fun updateApartment(apartmentEntity: ApartmentEntity) {
        val index = mItems.indexOfFirst {
            it as ApartmentItem
            it.apartmentEntity.ID == apartmentEntity.ID
        }
        if (index != Constants.NOT_EXISTS) {
            replaceItem(ApartmentItem(apartmentEntity), index)
        }
    }

    interface OnActionListener {
        fun onEditListener(item: ApartmentItem)
        fun onDeleteListener(apartmentID: String)
    }
}
