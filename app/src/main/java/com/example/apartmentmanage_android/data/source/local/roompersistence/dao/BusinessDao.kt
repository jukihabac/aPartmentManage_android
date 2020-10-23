package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.BusinessEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface BusinessDao {

    @Query("SELECT * FROM Business")
    fun getBusiness(): Observable<List<BusinessEntity>>

    @Insert
    fun insertBusiness(businessEntity: BusinessEntity): Completable

    @Query("DELETE FROM Business WHERE BusinessID =:businessID")
    fun deleteBusinessByID(businessID: String): Single<Int>

    @Update
    fun updateBusiness(businessEntity: BusinessEntity): Completable

}
