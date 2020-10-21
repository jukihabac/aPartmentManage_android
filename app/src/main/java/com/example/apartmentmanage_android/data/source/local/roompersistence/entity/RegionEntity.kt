package com.example.apartmentmanage_android.data.source.local.roompersistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Region", primaryKeys = ["RegionID"])
data class RegionEntity (
    @ColumnInfo(name = "RegionID") val ID: String,
    @ColumnInfo(name = "RegionName") val name: String,
)
