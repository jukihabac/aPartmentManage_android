package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.DetailBusinessEntity
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.DetailContractEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface DetailContractDao {

    @Query("SELECT * FROM DetailContract")
    fun getDetailContracts(): Observable<List<DetailContractEntity>>

    @Query("SELECT * FROM DetailContract WHERE ContractID =:contractID")
    fun getDetailContractByID(contractID: String): Observable<DetailContractEntity>

    @Insert
    fun insertDetailContract(detailContractEntity: DetailContractEntity): Completable

    @Query("DELETE FROM DetailContract WHERE ContractID =:contractID")
    fun deleteDetailContractByID(contractID: String): Single<Int>

    @Update
    fun updateDetailContract(detailContractEntity: DetailContractEntity): Completable

}
