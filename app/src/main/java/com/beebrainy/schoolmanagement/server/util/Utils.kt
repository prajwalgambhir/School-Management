package com.beebrainy.schoolmanagement.server.util

import java.util.*
import java.util.concurrent.ThreadLocalRandom

/**
 * Created by Prajwal Gambhir on 25-05-2020.
 * Copyright (2020) by BeeBrainy
 */
class Utils {

    companion object {
        fun remTimeFromDate(date: Date): Long {
            val c = Calendar.getInstance()
            c.timeInMillis = date.time
            c.set(Calendar.HOUR_OF_DAY, 0)
            c.set(Calendar.MINUTE, 0)
            c.set(Calendar.SECOND, 0)
            return c.timeInMillis
        }

        fun getCurrDateOnly(): Long {
            return remTimeFromDate(Date())
        }

        fun generateRandomString(len: Int): String {
            // chose a Character random from this String
            val alphaNumericString = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "abcdefghijklmnopqrstuvxyz")

            // create StringBuffer size of AlphaNumericString

            // create StringBuffer size of AlphaNumericString
            val sb: StringBuilder = StringBuilder(len)

            for (i in 0 until len) {

                // generate a random number between
                // 0 to AlphaNumericString variable length
                val index = (alphaNumericString.length
                        * Math.random()).toInt()

                // add Character one by one in end of sb
                sb.append(alphaNumericString[index])
            }

            return sb.toString().toLowerCase(Locale.ENGLISH).capitalize(Locale.ENGLISH)
        }

        fun generateRandomNum(min: Int, max: Int): Int {
            return ThreadLocalRandom.current().nextInt(min, max + 1)
        }
    }

}