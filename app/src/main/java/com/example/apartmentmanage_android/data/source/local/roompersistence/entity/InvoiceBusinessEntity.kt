package com.example.apartmentmanage_android.data.source.local.roompersistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "InvoiceBusiness", primaryKeys = ["InvoiceBusinessID"])
data class InvoiceBusinessEntity (
    @ColumnInfo(name = "InvoiceBusinessID") val ID: String,
    @ColumnInfo(name = "InvoiceBusinessName") val name: String,
    @ColumnInfo(name = "EmployeeID") val employeeID: String,
    @ColumnInfo(name = "FamilyID") val familyID: String,
    @ColumnInfo(name = "ApartmentID") val apartmentID: Float,
    @ColumnInfo(name = "Date") val date: String,
    @ColumnInfo(name = "SumCost") val sumCost: String,
    @ColumnInfo(name = "Note") val note: String
)
