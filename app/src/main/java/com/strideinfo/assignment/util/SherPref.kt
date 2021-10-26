package com.strideinfo.assignment.util

import android.content.Context
import android.content.SharedPreferences

object SherPref  {
    lateinit var context :Context;
    const val pref_name="test_assignment_pref"
    fun setString(var_name: String?, var_value: String?) {
        val pref = context.getSharedPreferences(
            pref_name,
            Context.MODE_PRIVATE
        )
        val edit = pref.edit()
        edit.putString(var_name, var_value)
        edit.commit()
    }

    fun getString(var_name: String?): String? {
        val pref = context.getSharedPreferences(
            pref_name,
            Context.MODE_PRIVATE
        )
        return pref.getString(var_name, "")
    }

    fun initSherPref(context: Context){
        this.context = context
    }




}
