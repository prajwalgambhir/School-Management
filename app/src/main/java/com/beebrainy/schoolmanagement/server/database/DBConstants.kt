package com.beebrainy.schoolmanagement.server.database

/**
 * Created by Prajwal Gambhir on 24-05-2020.
 * Copyright (2020) by BeeBrainy
 */
interface DBConstants {

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "school_management_database"
    }

    interface Tables {
        companion object {
            //--COMMON CONSTANTS STARTS--//
            const val COL_TIMESTAMP = "timestamp"
            const val COL_ID = "id"
            //--COMMON CONSTANTS ENDS--//

            //-- STUDENT STARTS--//
            const val TBL_STUDENT = "TBL_STUDENT"
            const val COL_STUD_ROLL_NO = "roll_no"
            const val COL_STUD_FIRST_NAME = "first_name"
            const val COL_STUD_MID_NAME = "mid_name"
            const val COL_STUD_LAST_NAME = "last_name"
            const val COL_STUD_FATHER_NAME = "father_name"
            const val COL_STUD_MOTHER_NAME = "mother_name"
            const val COL_STUD_DOB = "dob"
            const val COL_STUD_DOJ = "doj"
            //-- STUDENT STARTS--//
        }
    }

}