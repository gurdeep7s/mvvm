package com.strideinfo.assignment

import android.app.Application
import com.strideinfo.assignment.util.SherPref

class ApplicationClass :Application() {

    override fun onCreate() {
        super.onCreate()
        SherPref.initSherPref(this)
    }
}