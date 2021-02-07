package com.beebrainy.schoolmanagement.server.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.beebrainy.schoolmanagement.server.database.DBConstants
import com.beebrainy.schoolmanagement.server.database.DBConstants.Tables.Companion.TBL_STUDENT
import com.beebrainy.schoolmanagement.server.database.entities.StudentEntity

/**
 * Created by Prajwal Gambhir on 24-05-2020.
 * Copyright (2020) by BeeBrainy
 */
@Dao
interface StudentDao {

    @Insert
    suspend fun insertStudent(studentEntity: StudentEntity)

    @Update
    suspend fun updateStudent(studentEntity: StudentEntity)

    @Delete
    suspend fun deleteStudent(studentEntity: StudentEntity)

    @Query("DELETE FROM $TBL_STUDENT")
    suspend fun deleteAll()

    @Query("SELECT * FROM $TBL_STUDENT ORDER BY ${DBConstants.Tables.COL_ID} DESC")
    fun getAllStudent(): LiveData<List<StudentEntity>>

    @Query("SELECT * FROM $TBL_STUDENT WHERE ${DBConstants.Tables.COL_ID} IN (:id)")
    fun getStudentById(id: Int): LiveData<StudentEntity>
}