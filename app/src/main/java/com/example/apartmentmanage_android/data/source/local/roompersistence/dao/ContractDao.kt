package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ContractEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface ContractDao {

    @Query("SELECT * FROM Contract")
    fun getContracts(): Observable<List<ContractEntity>>

    @Insert
    fun insertContract(contractEntity: ContractEntity): Completable

    @Query("DELETE FROM  Contract WHERE ContractID =:contractID")
    fun deleteContractByID(contractID: String): Single<Int>

    @Update
    fun updateContract(contractEntity: ContractEntity): Completable
}
