package com.example.apartmentmanage_android.data.source.local.roompersistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Employee", primaryKeys = ["EmployeeID"])
data class EmployeeEntity (
    @ColumnInfo(name = "EmployeeID") val ID: String,
    @ColumnInfo(name = "FullName") val name: String,
    @ColumnInfo(name = "Sex") val kind: String,
    @ColumnInfo(name = "Address") val cost: Float,
    @ColumnInfo(name = "PhoneNumber") val state: String,
    @ColumnInfo(name = "BirthDay") val note: String,
    @ColumnInfo(name = "Email") val regionID: String,
    @ColumnInfo(name = "CardID") val cardID: String,
    @ColumnInfo(name = "Image") val image: String
)
