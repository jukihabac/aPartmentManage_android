package com.example.apartmentmanage_android.data.repositories.local

import android.content.Context
import com.example.apartmentmanage_android.data.source.local.roompersistence.DatabaseLocal
import com.example.apartmentmanage_android.data.source.local.roompersistence.dao.AccountDao
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.AccountEntity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface AccountRepository {
    fun signIn(ID: String, password: String): Single<AccountEntity>
}

class AccountRepositoryImpl @Inject constructor(private val context: Context) :
    AccountRepository {

    private var mAccountDao = DatabaseLocal.getDatabase(context).getAccountDao()

    override fun signIn(ID: String, password: String): Single<AccountEntity> =
        mAccountDao.signIn(ID, password)
}
