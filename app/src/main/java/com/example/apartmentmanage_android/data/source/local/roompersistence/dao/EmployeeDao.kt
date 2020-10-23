package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.EmployeeEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM Employee")
    fun getEmployees(): Observable<List<EmployeeEntity>>

    @Query("SELECT * FROM Employee WHERE EmployeeID =:employeeID")
    fun getEmployeesByID(employeeID: String): Observable<EmployeeEntity>

    @Insert
    fun insertEmployee(employeeEntity: EmployeeEntity): Completable

    @Query("DELETE FROM Employee WHERE EmployeeID =:employeeID")
    fun deleteEmployeeByID(employeeID: String): Single<Int>

    @Update
    fun updateEmployee(employeeEntity: EmployeeEntity): Completable

}
