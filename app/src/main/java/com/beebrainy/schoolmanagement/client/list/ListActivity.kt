package com.beebrainy.schoolmanagement.client.list

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.beebrainy.schoolmanagement.client.student.list.StudentListFragment
import com.beebrainy.schoolmanagement.server.controller.bo.StudentController
import com.beebrainy.schoolmanagement.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private lateinit var fragList: StudentListFragment
    private lateinit var con: StudentController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        con = StudentController(this)
        initViews()
    }

    private fun initViews() {
        fragList = StudentListFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.frameList, fragList, "LIST")
                .addToBackStack(null).commit()
        edtSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                fragList.onQuery(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }

}
