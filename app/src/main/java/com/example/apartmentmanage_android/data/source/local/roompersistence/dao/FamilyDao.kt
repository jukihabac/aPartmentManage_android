package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.FamilyEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface FamilyDao {

    @Query("SELECT * FROM Family")
    fun getFamily(): Observable<List<FamilyEntity>>

    @Insert
    fun insertFamily(familyEntity: FamilyEntity): Completable

    @Query("DELETE FROM Family WHERE FamilyID =:familyID")
    fun deleteFamilyByID(familyID: String): Single<Int>

    @Update
    fun updateFamily(familyEntity: FamilyEntity): Completable

}
