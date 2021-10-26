package com.strideinfo.assignment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.strideinfo.assignment.ui.model.Gym
import com.strideinfo.assignment.ui.model.GymDataModel
import com.strideinfo.assignment.ui.model.ClassTypes
import com.strideinfo.assignment.ui.model.PopularcClassesModel
import kotlinx.coroutines.launch

class MainActivityViewModel() : ViewModel() {

    private var gymList = MutableLiveData<GymDataModel>();
    private var setupdateList = MutableLiveData<Boolean>();
    var updateList: LiveData<Boolean> = setupdateList

    private var setselectedCategory = MutableLiveData<Boolean>();
    var refreshCategory: LiveData<Boolean> = setselectedCategory

    private var setupdateclassTypeList = MutableLiveData<Boolean>();
    var updateClasstypeList: LiveData<Boolean> = setupdateclassTypeList

    private var setcategoriesList = MutableLiveData<ArrayList<PopularcClassesModel>>();
    var updatecategoryList: LiveData<ArrayList<PopularcClassesModel>> = setcategoriesList


    var getGymList: LiveData<GymDataModel> = gymList;

    init {
        getGymListData()
        getPopularClassesCategory()
    }

    private fun getPopularClassesCategory() {

        viewModelScope.launch {
            setcategoriesList.value = MainRepository.getDummyCategoryList().value
        }
    }


    fun getGymListData() {

        viewModelScope.launch {
            gymList.value = MainRepository.getDummyData().value
        }
    }


    fun likeUnlike(item: Gym) {

        viewModelScope.launch {
            setupdateList.value = MainRepository.likeUnlike(item, gymList.value).value
        }
    }


    fun likeunLikePopularClass(data: ClassTypes) {
        viewModelScope.launch {
            setupdateclassTypeList.value = MainRepository.likeUnlikePopularClass(data, gymList.value).value
        }
    }

    fun selectUnselectCategory(data: PopularcClassesModel) {
        viewModelScope.launch {
            setselectedCategory.value = MainRepository.selectUnselectCategory(data, updatecategoryList.value).value


        }

    }


}