package com.example.apartmentmanage_android.data.source.local.roompersistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.util.*

@Entity(tableName = "DetailContract", primaryKeys = ["DetailContractID"])
data class DetailContractEntity (
    @ColumnInfo(name = "DetailContractID") val detailContractID: String,
    @ColumnInfo(name = "ContractID") val contractID: String,
    @ColumnInfo(name = "DateResister") val dateRegister: String,
    @ColumnInfo(name = "LimitDate") val limitDate: String,
    @ColumnInfo(name = "Value") val value: Float,
    @ColumnInfo(name = "Content") val Content: String
)
