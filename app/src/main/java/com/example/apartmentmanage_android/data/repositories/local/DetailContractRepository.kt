package com.example.apartmentmanage_android.data.repositories.local

import android.content.Context
import com.example.apartmentmanage_android.data.source.local.roompersistence.DatabaseLocal
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.DetailBusinessEntity
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.DetailContractEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface DetailContractRepository {
    fun getDetailContracts(): Observable<List<DetailContractEntity>>

    fun getDetailContractByID(contractID: String): Observable<DetailContractEntity>

    fun insertDetailContract(detailContractEntity: DetailContractEntity): Completable

    fun deleteDetailContractByID(contractID: String): Single<Int>

    fun updateDetailContract(detailContractEntity: DetailContractEntity): Completable
}

class DetailContractRepositoryImpl @Inject constructor(private val context: Context) :
    DetailContractRepository {

    private var mDetailContractDao = DatabaseLocal.getDatabase(context).getDetailContractDao()

    override fun getDetailContracts(): Observable<List<DetailContractEntity>> =
        mDetailContractDao.getDetailContracts()

    override fun getDetailContractByID(contractID: String): Observable<DetailContractEntity> =
        mDetailContractDao.getDetailContractByID(contractID)

    override fun insertDetailContract(detailContractEntity: DetailContractEntity): Completable =
        mDetailContractDao.insertDetailContract(detailContractEntity)

    override fun deleteDetailContractByID(contractID: String): Single<Int> =
        mDetailContractDao.deleteDetailContractByID(contractID)

    override fun updateDetailContract(detailContractEntity: DetailContractEntity): Completable =
        mDetailContractDao.updateDetailContract(detailContractEntity)
}
