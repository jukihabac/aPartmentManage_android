package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.InvoiceBusinessEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface InvoiceBusinessDao {

    @Query("SELECT * FROM InvoiceBusiness")
    fun getInvoiceBusiness(): Observable<List<InvoiceBusinessEntity>>

    @Insert
    fun insertInvoiceBusiness(invoiceBusinessEntity: InvoiceBusinessEntity): Completable

    @Query("DELETE FROM InvoiceBusiness WHERE InvoiceBusinessID =:invoiceBusinessID")
    fun deleteInvoiceBusinessByID(invoiceBusinessID: String): Single<Int>

    @Update
    fun updateInvoiceBusiness(invoiceBusinessEntity: InvoiceBusinessEntity): Completable

}
