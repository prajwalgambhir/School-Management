package com.beebrainy.schoolmanagement.server.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.beebrainy.schoolmanagement.server.database.DBConstants

/**
 * Created by Prajwal Gambhir on 24-05-2020.
 * Copyright (2020) by BeeBrainy
 */
@Entity(tableName = DBConstants.Tables.TBL_STUDENT)
data class StudentEntity(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = DBConstants.Tables.COL_ID)
        val id: Int,
        @ColumnInfo(name = DBConstants.Tables.COL_STUD_ROLL_NO)
        var rollNo: String,
        @ColumnInfo(name = DBConstants.Tables.COL_STUD_FIRST_NAME)
        var firstName: String,
        @ColumnInfo(name = DBConstants.Tables.COL_STUD_MID_NAME)
        var midName: String,
        @ColumnInfo(name = DBConstants.Tables.COL_STUD_LAST_NAME)
        var lastName: String,
        @ColumnInfo(name = DBConstants.Tables.COL_STUD_FATHER_NAME)
        var fatherName: String,
        @ColumnInfo(name = DBConstants.Tables.COL_STUD_MOTHER_NAME)
        var motherName: String,
        @ColumnInfo(name = DBConstants.Tables.COL_STUD_DOB)
        var dob: Long,
        @ColumnInfo(name = DBConstants.Tables.COL_STUD_DOJ)
        var doj: Long

) {
    constructor() : this(0, "","","","","","", 0L, 0L)

    override fun toString(): String {
        return "StudentEntity(id=$id, rollNo='$rollNo', firstName='$firstName', midName='$midName', lastName='$lastName', fatherName='$fatherName', motherName='$motherName', dob=$dob, doj=$doj)"
    }
}