package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.DetailWaterEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface DetailWaterDao {

    @Query("SELECT * FROM DetailWater")
    fun getDetailWater(): Observable<List<DetailWaterEntity>>

    @Query("SELECT * FROM DetailWater WHERE DetailWaterID =:detailWaterID")
    fun getDetailWaterByID(detailWaterID: String): Observable<DetailWaterEntity>

    @Insert
    fun insertDetailWater(detailWaterEntity: DetailWaterEntity): Completable

    @Query("DELETE FROM DetailWater WHERE DetailWaterID =:detailWaterID")
    fun deleteDetailWaterByID(detailWaterID: String): Single<Int>

    @Update
    fun updateDetailWater(detailWaterEntity: DetailWaterEntity): Completable

}
