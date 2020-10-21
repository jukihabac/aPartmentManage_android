package com.example.apartmentmanage_android.data.source.local.roompersistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "DetailBusiness", primaryKeys = ["DetailBusinessID"])
data class DetailBusinessEntity (
    @ColumnInfo(name = "DetailBusinessID") val detailBusinessID: String,
    @ColumnInfo(name = "InvoiceBusinessID") val invoiceBusinessID: String,
    @ColumnInfo(name = "Amount") val amount: String,
    @ColumnInfo(name = "Cost") val cost: Float,
    @ColumnInfo(name = "Note") val note: String,
    @ColumnInfo(name = "BusinessID") val businessID: String
)
