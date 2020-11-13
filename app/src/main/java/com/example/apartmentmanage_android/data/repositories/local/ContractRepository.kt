package com.example.apartmentmanage_android.data.repositories.local

import android.content.Context
import com.example.apartmentmanage_android.data.source.local.roompersistence.DatabaseLocal
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ContractEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface ContractRepository {
    fun getContracts(): Single<List<ContractEntity>>

    fun insertContract(contractEntity: ContractEntity): Completable

    fun deleteContractByID(contractID: String): Single<Int>

    fun updateContract(contractEntity: ContractEntity): Completable
}

class ContractRepositoryImpl @Inject constructor(private val context: Context) :
    ContractRepository {

    private var mContractDao = DatabaseLocal.getDatabase(context).getContractDao()

    override fun getContracts(): Single<List<ContractEntity>> = mContractDao.getContracts()

    override fun insertContract(contractEntity: ContractEntity): Completable =
        mContractDao.insertContract(contractEntity)

    override fun deleteContractByID(contractID: String): Single<Int> =
        mContractDao.deleteContractByID(contractID)

    override fun updateContract(contractEntity: ContractEntity): Completable =
        mContractDao.updateContract(contractEntity)
}
