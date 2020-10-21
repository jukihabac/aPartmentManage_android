package com.example.apartmentmanage_android.data.source.local.roompersistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Family", primaryKeys = ["FamilyID"])
data class FamilyEntity (
    @ColumnInfo(name = "FamilyID") val ID: String,
    @ColumnInfo(name = "NameOwner") val name: String,
    @ColumnInfo(name = "OwnerID") val ownerID: String,
    @ColumnInfo(name = "AmountMember") val amountMember: Int
)
