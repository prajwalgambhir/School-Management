package com.beebrainy.schoolmanagement.server.controller.bo

import android.content.Context
import androidx.lifecycle.LiveData
import com.beebrainy.schoolmanagement.server.controller.api.IStudentController
import com.beebrainy.schoolmanagement.server.database.entities.StudentEntity
import com.beebrainy.schoolmanagement.server.repo.StudentRepo

/**
 * Created by Prajwal Gambhir on 24-05-2020.
 * Copyright (2020) by BeeBrainy
 */
class StudentController(context: Context) : IStudentController {

    private var repo: StudentRepo = StudentRepo(context)

    override suspend fun insertStudent(studentEntity: StudentEntity) {
        repo.insert(studentEntity)
    }

    override suspend fun updateStudent(studentEntity: StudentEntity) {
        repo.update(studentEntity)
    }

    override suspend fun deleteStudent(studentEntity: StudentEntity) {
        repo.delete(studentEntity)
    }

    override suspend fun deleteAll() {
        repo.deleteAll()
    }

    override fun getAllStudent(): LiveData<List<StudentEntity>> {
        return repo.getAllStudents()
    }

    override fun getStudentById(id: Int): LiveData<StudentEntity> {
        return repo.getStudentById(id)
    }
}