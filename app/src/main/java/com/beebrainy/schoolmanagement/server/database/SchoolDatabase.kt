package com.beebrainy.schoolmanagement.server.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.beebrainy.schoolmanagement.server.database.dao.StudentDao
import com.beebrainy.schoolmanagement.server.database.entities.StudentEntity

/**
 * Created by Prajwal Gambhir on 24-05-2020.
 * Copyright (2020) by BeeBrainy
 */
@Database(entities = [StudentEntity::class], version = DBConstants.DB_VERSION)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val studentDao: StudentDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null
        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            SchoolDatabase::class.java,
                            DBConstants.DB_NAME
                    ).build()
                }
                return INSTANCE as SchoolDatabase
            }
        }
    }

}