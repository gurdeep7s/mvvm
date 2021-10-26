package com.strideinfo.assignment.util

import com.strideinfo.assignment.ui.model.Gym
import com.strideinfo.assignment.ui.model.ClassTypes
import com.strideinfo.assignment.ui.model.PopularcClassesModel

interface ClickInterface {
    fun gymItemLikeUnlike(data: Gym)
    fun manageClassesList(data: Gym)
    fun clickOnParentView(data: Gym)
    fun favUnfavPopular(data: ClassTypes)
    fun favUnfavCategory(data: PopularcClassesModel)
}