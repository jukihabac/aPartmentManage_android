package com.example.apartmentmanage_android.data.repositories.local

import android.content.Context
import com.example.apartmentmanage_android.data.source.local.roompersistence.DatabaseLocal
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.MemberEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface MemberRepository {
    fun getMembers(): Single<List<MemberEntity>>

    fun getMembersByFamilyID(familyID: String): Single<List<MemberEntity>>

    fun getMemberByID(memberID: String): Single<MemberEntity>

    fun insertMember(memberEntity: MemberEntity): Completable

    fun deleteMemberByID(memberID: String): Single<Int>

    fun updateMember(memberEntity: MemberEntity): Completable
}

class MemberRepositoryImpl @Inject constructor(private val context: Context) : MemberRepository {

    private val mMemberDao = DatabaseLocal.getDatabase(context).getMemberDao()

    override fun getMembers(): Single<List<MemberEntity>> = mMemberDao.getMembers()

    override fun getMembersByFamilyID(familyID: String): Single<List<MemberEntity>> =
        mMemberDao.getMembersByFamilyID(familyID)

    override fun getMemberByID(memberID: String): Single<MemberEntity> =
        mMemberDao.getMemberByID(memberID)

    override fun insertMember(memberEntity: MemberEntity): Completable =
        mMemberDao.insertMembers(memberEntity)

    override fun deleteMemberByID(memberID: String): Single<Int> =
        mMemberDao.deleteMembersByID(memberID)

    override fun updateMember(memberEntity: MemberEntity): Completable =
        mMemberDao.updateMembers(memberEntity)
}
