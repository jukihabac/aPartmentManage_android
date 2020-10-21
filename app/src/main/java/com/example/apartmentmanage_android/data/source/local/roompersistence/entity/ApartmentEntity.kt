package com.example.apartmentmanage_android.data.source.local.roompersistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Apartment", primaryKeys = ["ApartmentID"])
data class ApartmentEntity (
    @ColumnInfo(name = "ApartmentID") val ID: String,
    @ColumnInfo(name = "ApartmentName") val name: String,
    @ColumnInfo(name = "ApartmentKind") val kind: String,
    @ColumnInfo(name = "ApartmentCost") val cost: Float,
    @ColumnInfo(name = "State") val state: String,
    @ColumnInfo(name = "Note") val note: String,
    @ColumnInfo(name = "RegionID") val regionID: String,
    @ColumnInfo(name = "FamilyID") val familyID: String,
)
