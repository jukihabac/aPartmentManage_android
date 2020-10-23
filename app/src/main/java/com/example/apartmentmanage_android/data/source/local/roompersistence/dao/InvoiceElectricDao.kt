package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.InvoiceElectricEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface InvoiceElectricDao {

    @Query("SELECT * FROM InvoiceElectric")
    fun getInvoiceElectric(): Observable<List<InvoiceElectricEntity>>

    @Insert
    fun insertInvoiceElectric(invoiceElectricEntity: InvoiceElectricEntity): Completable

    @Query("DELETE FROM InvoiceElectric WHERE InvoiceElectricID =:invoiceElectricID")
    fun deleteInvoiceElectricByID(invoiceElectricID: String): Single<Int>

    @Update
    fun updateInvoiceElectric(invoiceElectricEntity: InvoiceElectricEntity): Completable

}
