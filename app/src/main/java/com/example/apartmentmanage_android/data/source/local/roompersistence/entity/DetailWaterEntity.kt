package com.example.apartmentmanage_android.data.source.local.roompersistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "DetailWater", primaryKeys = ["DetailWaterID"])
data class DetailWaterEntity (
    @ColumnInfo(name = "DetailWaterID") val detailWaterID: String,
    @ColumnInfo(name = "InvoiceWaterID") val invoiceWaterID: String,
    @ColumnInfo(name = "Amount") val amount: String,
    @ColumnInfo(name = "Cost") val cost: Float,
    @ColumnInfo(name = "Note") val note: String
)
