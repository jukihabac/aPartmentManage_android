package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.rxjava3.core.Observable

@Dao
interface AccountDao {

    @Query("SELECT * FROM Account WHERE ID = :ID AND Password = :password")
    fun signIn(ID: String, password: String): Observable<AccountDao>

}
