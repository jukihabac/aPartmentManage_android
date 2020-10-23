package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.DetailElectricEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface DetailElectricDao {

    @Query("SELECT * FROM DetailElectric")
    fun getDetailElectrics(): Observable<List<DetailElectricEntity>>

    @Query("SELECT * FROM DetailElectric WHERE DetailElectricID =:detailElectricID")
    fun getDetailElectricByID(detailElectricID: String): Observable<DetailElectricEntity>

    @Insert
    fun insertDetailElectric(detailElectricEntity: DetailElectricEntity): Completable

    @Query("DELETE FROM DetailElectric WHERE DetailElectricID =:detailElectricID")
    fun deleteDetailElectricByID(detailElectricID: String): Single<Int>

    @Update
    fun updateDetailElectric(detailElectricEntity: DetailElectricEntity): Completable

}
