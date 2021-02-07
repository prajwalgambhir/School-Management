package com.beebrainy.schoolmanagement.client.student.list

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.beebrainy.schoolmanagement.app.StudentApplication
import com.beebrainy.schoolmanagement.server.controller.bo.StudentController
import com.beebrainy.schoolmanagement.server.database.entities.StudentEntity
import com.beebrainy.schoolmanagement.server.util.Utils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created by Prajwal Gambhir on 25-05-2020.
 * Copyright (2020) by BeeBrainy
 */
class StudentListViewModel(application: StudentApplication) : AndroidViewModel(application) {

    private var con = StudentController(application)
    private var studentListObservable: LiveData<List<StudentEntity>>

    init {
        studentListObservable = con.getAllStudent()
    }

    fun getStudentObservable(): LiveData<List<StudentEntity>> {
        return studentListObservable
    }

    fun addStudent(fName: String, mName: String, lName: String, fatName: String, motName: String) {
        val se = StudentEntity().apply {
            rollNo = "" + System.currentTimeMillis()
            firstName = fName
            midName = mName
            lastName = lName
            fatherName = fatName
            motherName = motName
            dob = Utils.getCurrDateOnly()
            doj = Utils.getCurrDateOnly()

        }
        GlobalScope.launch {
            con.insertStudent(se)
        }

    }
}
