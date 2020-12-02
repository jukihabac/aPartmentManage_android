package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.AccountEntity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface AccountDao {

    @Query("SELECT * FROM Account WHERE ID = :ID AND Password = :password")
    fun signIn(ID: String, password: String): Single<AccountEntity>
}
