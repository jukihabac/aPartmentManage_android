package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.RegionEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface RegionDao {

    @Query("SELECT * FROM Region")
    fun getRegions(): Observable<List<RegionEntity>>

    @Insert
    fun insertRegion(regionEntity: RegionEntity): Completable

    @Query("DELETE FROM Region WHERE RegionID =:regionID")
    fun deleteRegionByID(regionID: String): Single<Int>

    @Update
    fun updateRegion(regionEntity: RegionEntity): Completable

}
