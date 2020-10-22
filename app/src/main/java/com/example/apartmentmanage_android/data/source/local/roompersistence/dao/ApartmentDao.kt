package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ApartmentEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface ApartmentDao {

    @Query("SELECT * FROM Apartment")
    fun getApartments(): Observable<List<ApartmentEntity>>

    @Insert
    fun insertApartment(apartmentEntity: ApartmentEntity): Completable

    @Query("DELETE FROM Apartment WHERE ApartmentID =:apartmentID")
    fun deleteApartmentByID(apartmentID: String): Single<Int>

    @Update
    fun updateApartment(apartmentEntity: ApartmentEntity): Completable

}
