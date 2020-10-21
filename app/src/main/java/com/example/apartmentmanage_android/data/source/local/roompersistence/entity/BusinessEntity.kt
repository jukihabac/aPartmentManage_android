package com.example.apartmentmanage_android.data.source.local.roompersistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Business", primaryKeys = ["BusinessID"])
data class BusinessEntity (
    @ColumnInfo(name = "BusinessID") val ID: String,
    @ColumnInfo(name = "BusinessName") val name: String,
    @ColumnInfo(name = "BusinessCost") val cost: Float
)
