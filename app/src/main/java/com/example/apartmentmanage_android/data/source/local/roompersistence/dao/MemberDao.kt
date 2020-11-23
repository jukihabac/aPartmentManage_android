package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.MemberEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface MemberDao {

    @Query("SELECT * FROM Member")
    fun getMembers(): Single<List<MemberEntity>>

    @Query("SELECT * FROM Member WHERE MemberID =:memberID")
    fun getMemberByID(memberID: String): Single<MemberEntity>

    @Insert
    fun insertMembers(memberEntity: MemberEntity): Completable

    @Query("DELETE FROM Member WHERE MemberID =:membersID")
    fun deleteMembersByID(membersID: String): Single<Int>

    @Update
    fun updateMembers(memberEntityEntity: MemberEntity): Completable

    @Query("SELECT * FROM Member WHERE FamilyID =:familyID")
    fun getMembersByFamilyID(familyID: String): Single<List<MemberEntity>>

}
