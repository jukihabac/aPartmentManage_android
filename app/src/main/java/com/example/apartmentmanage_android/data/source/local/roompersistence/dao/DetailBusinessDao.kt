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
    fun getBusiness(): Observable<List<DetailBusinessEntity>>

    @Query("SELECT * FROM DetailBusiness WHERE BusinessID =:businessID")
    fun getBusinessByID(businessID: String): Observable<DetailBusinessEntity>

    @Insert
    fun insertBusiness(detailBusinessEntity: DetailBusinessEntity): Completable

    @Query("DELETE FROM DetailBusiness WHERE BusinessID =:businessID")
    fun deleteBusinessByID(businessID: String): Single<Int>

    @Update
    fun updateBusiness(detailBusinessEntity: DetailBusinessEntity): Completable

}
