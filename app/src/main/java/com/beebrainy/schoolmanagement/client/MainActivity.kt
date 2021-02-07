package com.beebrainy.schoolmanagement.client

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.beebrainy.schoolmanagement.client.list.ListActivity
import com.beebrainy.schoolmanagement.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStudent.setOnClickListener {
            gotoStudent()
        }
    }

    private fun gotoStudent() {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }
}
