package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.DetailBusinessEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface DetailBusinessDao {

    @Query("SELECT * FROM DetailBusiness")
    fun getDetailBusiness(): Observable<List<DetailBusinessEntity>>

    @Query("SELECT * FROM DetailBusiness WHERE BusinessID =:businessID")
    fun getDetailBusinessByID(businessID: String): Observable<DetailBusinessEntity>

    @Insert
    fun insertDetailBusiness(detailBusinessEntity: DetailBusinessEntity): Completable

    @Query("DELETE FROM DetailBusiness WHERE BusinessID =:businessID")
    fun deleteDetailBusinessByID(businessID: String): Single<Int>

    @Update
    fun updateDetailBusiness(detailBusinessEntity: DetailBusinessEntity): Completable
}
