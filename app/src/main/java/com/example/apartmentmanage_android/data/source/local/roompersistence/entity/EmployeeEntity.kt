package com.example.apartmentmanage_android.data.source.local.roompersistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Employee", primaryKeys = ["EmployeeID"])
data class EmployeeEntity (
    @ColumnInfo(name = "EmployeeID") val ID: String,
    @ColumnInfo(name = "FullName") val name: String,
    @ColumnInfo(name = "Sex") val sex: String,
    @ColumnInfo(name = "Address") val address: String,
    @ColumnInfo(name = "PhoneNumber") val phone: String,
    @ColumnInfo(name = "BirthDay") val birthday: String,
    @ColumnInfo(name = "Email") val email: String,
    @ColumnInfo(name = "CardID") val cardID: String,
    @ColumnInfo(name = "Image") val image: String
)
