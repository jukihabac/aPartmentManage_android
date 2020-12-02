package com.example.apartmentmanage_android.data.source.local.roompersistence.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Account", primaryKeys = ["EmployeeID"])
data class AccountEntity(
    @ColumnInfo(name = "EmployeeID") val employeeID: String,
    @ColumnInfo(name = "ID") val ID: String,
    @ColumnInfo(name = "Password") val Password: String,
) : Parcelable
