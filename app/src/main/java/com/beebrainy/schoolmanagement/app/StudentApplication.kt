package com.beebrainy.schoolmanagement.app

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by Prajwal Gambhir on 25-05-2020.
 * Copyright (2020) by BeeBrainy
 */
class StudentApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}