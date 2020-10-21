package com.example.apartmentmanage_android.data.source.local.roompersistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "DetailElectric", primaryKeys = ["DetailElectricID"])
data class DetailElectricEntity(
    @ColumnInfo(name = "DetailElectricID") val detailElectricID: String,
    @ColumnInfo(name = "InvoiceElectricID") val invoiceElectricID: String,
    @ColumnInfo(name = "Amount") val amount: String,
    @ColumnInfo(name = "Cost") val cost: Float,
    @ColumnInfo(name = "Note") val note: String
)
