package com.beebrainy.schoolmanagement.server.controller.api

import androidx.lifecycle.LiveData
import com.beebrainy.schoolmanagement.server.database.entities.StudentEntity

/**
 * Created by Prajwal Gambhir on 24-05-2020.
 * Copyright (2020) by BeeBrainy
 */
interface IStudentController {

    suspend fun insertStudent(studentEntity: StudentEntity)

    suspend fun updateStudent(studentEntity: StudentEntity)

    suspend fun deleteStudent(studentEntity: StudentEntity)

    suspend fun deleteAll()

    fun getAllStudent(): LiveData<List<StudentEntity>>

    fun getStudentById(id:Int): LiveData<StudentEntity>
}