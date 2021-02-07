package com.beebrainy.schoolmanagement.client.student.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.beebrainy.schoolmanagement.app.StudentApplication

/**
 * Created by Prajwal Gambhir on 25-05-2020.
 * Copyright (2020) by BeeBrainy
 */
class StudentListViewModelFactory(val context: StudentApplication) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentListViewModel::class.java)) {
            return StudentListViewModel(
                    context
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class. Required " + StudentListViewModel::class.java.simpleName)
    }
}