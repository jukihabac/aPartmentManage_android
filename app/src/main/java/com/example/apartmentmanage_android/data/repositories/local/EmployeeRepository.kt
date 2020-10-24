package com.example.apartmentmanage_android.data.repositories.local

import android.content.Context
import com.example.apartmentmanage_android.data.source.local.roompersistence.DatabaseLocal
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.EmployeeEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface EmployeeRepository {
    fun getEmployees(): Observable<List<EmployeeEntity>>

    fun getEmployeesByID(employeeID: String): Observable<EmployeeEntity>

    fun insertEmployee(employeeEntity: EmployeeEntity): Completable

    fun deleteEmployeeByID(employeeID: String): Single<Int>

    fun updateEmployee(employeeEntity: EmployeeEntity): Completable
}

class EmployeeRepositoryImpl @Inject constructor(private val context: Context) :
    EmployeeRepository {

    private var mEmployeeDao = DatabaseLocal.getDatabase(context).getEmployeeDao()

    override fun getEmployees(): Observable<List<EmployeeEntity>> = mEmployeeDao.getEmployees()

    override fun getEmployeesByID(employeeID: String): Observable<EmployeeEntity> =
        mEmployeeDao.getEmployeesByID(employeeID)

    override fun insertEmployee(employeeEntity: EmployeeEntity): Completable =
        mEmployeeDao.insertEmployee(employeeEntity)

    override fun deleteEmployeeByID(employeeID: String): Single<Int> =
        mEmployeeDao.deleteEmployeeByID(employeeID)

    override fun updateEmployee(employeeEntity: EmployeeEntity): Completable =
        mEmployeeDao.updateEmployee(employeeEntity)
}
