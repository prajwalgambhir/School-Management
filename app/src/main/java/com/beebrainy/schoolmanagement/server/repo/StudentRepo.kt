package com.beebrainy.schoolmanagement.server.repo

import android.content.Context
import androidx.lifecycle.LiveData
import com.beebrainy.schoolmanagement.server.database.SchoolDatabase
import com.beebrainy.schoolmanagement.server.database.dao.StudentDao
import com.beebrainy.schoolmanagement.server.database.entities.StudentEntity

/**
 * Created by Prajwal Gambhir on 24-05-2020.
 * Copyright (2020) by BeeBrainy
 */
class StudentRepo(private val context: Context) {

    private val dao: StudentDao by lazy { SchoolDatabase.getInstance(context).studentDao }

    fun getStudentById(id:Int): LiveData<StudentEntity> {
        return dao.getStudentById(id)
    }

    fun getAllStudents(): LiveData<List<StudentEntity>> {
        return dao.getAllStudent()
    }

    suspend fun insert(studentEntity: StudentEntity) {
        SchoolDatabase.getInstance(context).studentDao.insertStudent(studentEntity)
    }

    suspend fun update(studentEntity: StudentEntity) {
        dao.updateStudent(studentEntity)
    }

    suspend fun delete(studentEntity: StudentEntity) {
        dao.deleteStudent(studentEntity)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}