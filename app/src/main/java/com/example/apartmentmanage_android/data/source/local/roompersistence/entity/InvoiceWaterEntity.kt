package com.example.apartmentmanage_android.data.source.local.roompersistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "InvoiceWater", primaryKeys = ["InvoiceWaterID"])
data class InvoiceWaterEntity (
    @ColumnInfo(name = "InvoiceWaterID") val ID: String,
    @ColumnInfo(name = "InvoiceWaterName") val name: String,
    @ColumnInfo(name = "EmployeeID") val employeeID: String,
    @ColumnInfo(name = "FamilyID") val familyID: String,
    @ColumnInfo(name = "ApartmentID") val apartmentID: Float,
    @ColumnInfo(name = "Date") val date: String,
    @ColumnInfo(name = "SumCost") val sumCost: String,
    @ColumnInfo(name = "Note") val note: String
)
