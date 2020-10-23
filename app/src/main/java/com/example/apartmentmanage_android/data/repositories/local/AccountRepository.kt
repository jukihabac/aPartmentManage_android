package com.example.apartmentmanage_android.data.repositories.local

import android.content.Context
import com.example.apartmentmanage_android.data.source.local.roompersistence.DatabaseLocal
import com.example.apartmentmanage_android.data.source.local.roompersistence.dao.AccountDao
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.AccountEntity
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

interface AccountRepository {
    fun signIn(ID: String, password: String): Observable<AccountEntity>
}

class AccountRepositoryImpl @Inject constructor(private val context: Context) :
    AccountRepository {

    private var mAccountDao = DatabaseLocal.getDatabase(context).getAccountDao()

    override fun signIn(ID: String, password: String): Observable<AccountEntity> =
        mAccountDao.signIn(ID, password)
}
