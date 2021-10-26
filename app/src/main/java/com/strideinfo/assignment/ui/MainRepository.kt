package com.strideinfo.assignment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.strideinfo.assignment.ui.model.ClassTypes
import com.strideinfo.assignment.ui.model.Gym
import com.strideinfo.assignment.ui.model.GymDataModel
import com.strideinfo.assignment.ui.model.PopularcClassesModel
import com.strideinfo.assignment.util.Constants
import com.strideinfo.assignment.util.DummyData
import com.strideinfo.assignment.util.SherPref
import java.lang.reflect.Type


object MainRepository {

     fun getDummyData(): LiveData<GymDataModel> {

        var gymList = MutableLiveData<GymDataModel>()
        gymList.value = Gson().fromJson(
            (if (SherPref.getString(Constants.DATA)
                    .isNullOrEmpty()
            ) DummyData.TEST_JSON else SherPref.getString(
                Constants.DATA
            )), GymDataModel::class.java
        )
        return gymList
    }

     fun likeUnlike(item: Gym, value: GymDataModel?): LiveData<Boolean> {
        var notifyListSuccessReceived = MutableLiveData<Boolean>()
        item.favorite = !item.favorite

        //assuming saving at server side using api
        SherPref.setString(Constants.DATA, Gson().toJson(value))
        notifyListSuccessReceived.value = true
        return notifyListSuccessReceived
    }

    fun likeUnlikePopularClass(data: ClassTypes, value: GymDataModel?): LiveData<Boolean> {
        var notifyListSuccessReceived = MutableLiveData<Boolean>()
        data.favorite = !data.favorite

        //assuming saving at server side using api
        SherPref.setString(Constants.DATA, Gson().toJson(value))
        notifyListSuccessReceived.value = true
        return notifyListSuccessReceived
    }

    //assumimg getting category list from server
    fun getDummyCategoryList(): LiveData<ArrayList<PopularcClassesModel>> {
        var categories = MutableLiveData<ArrayList<PopularcClassesModel>>()

        var list = ArrayList<PopularcClassesModel>()
        if (SherPref.getString(Constants.CATEGORY_LIST).isNullOrEmpty()) {
            DummyData.category.map {
                PopularcClassesModel(it, false)
                list.add(PopularcClassesModel(it, false))
            }
            SherPref.setString(Constants.CATEGORY_LIST, Gson().toJson(list))

        } else {
            //getting saved data from server (once user make the category selected)
            val type: Type = object : TypeToken<List<PopularcClassesModel?>?>() {}.type

            list.addAll(
                Gson().fromJson(
                    SherPref.getString(Constants.CATEGORY_LIST),
                    type
                )
            )
        }
        categories.value = list
        return categories
    }

    fun selectUnselectCategory(
        data: PopularcClassesModel,
        value: ArrayList<PopularcClassesModel>?
    ): LiveData<Boolean> {

        var notifyListSuccessReceived = MutableLiveData<Boolean>()
        data.isSelected = !data.isSelected

        //assuming saving at server side using api
        SherPref.setString(Constants.CATEGORY_LIST, Gson().toJson(value))
        notifyListSuccessReceived.value = true
        return notifyListSuccessReceived
    }
}