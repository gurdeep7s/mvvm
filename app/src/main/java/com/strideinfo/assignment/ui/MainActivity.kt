package com.strideinfo.assignment.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.strideinfo.assignment.BR
import com.strideinfo.assignment.R
import com.strideinfo.assignment.databinding.ActivityMainBinding
import com.strideinfo.assignment.ui.adapter.ClassesTypeAdapter
import com.strideinfo.assignment.ui.adapter.GymPagerAdapter
import com.strideinfo.assignment.ui.adapter.PopularClassesAdapter
import com.strideinfo.assignment.ui.model.Gym
import com.strideinfo.assignment.ui.model.ClassTypes
import com.strideinfo.assignment.ui.model.PopularcClassesModel
import com.strideinfo.assignment.util.ClickInterface


class MainActivity : AppCompatActivity(), ClickInterface {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mViewPagerAdapter: GymPagerAdapter
    private lateinit var classTypeAdapter: ClassesTypeAdapter
    private lateinit var categoryListAdapter: PopularClassesAdapter


    var gymList = ArrayList<Gym>()
    var popularClases = ArrayList<ClassTypes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main);
        var viewModel = MainActivityViewModel();
        mainBinding.viewmodel = viewModel;

        managerObserver()
    }

    private fun managerObserver() {

        mainBinding.viewmodel!!.getGymList.observe(this, {
            gymList.addAll(it.gyms)
            mViewPagerAdapter = GymPagerAdapter(gymList, this, this)
            mainBinding.setVariable(BR.adapter, mViewPagerAdapter)
            manageClassesList(gymList.get(0))


        })

        mainBinding.viewmodel!!.updatecategoryList.observe(this, {

            categoryListAdapter = PopularClassesAdapter(it, this, this)
            mainBinding.popularClassesRV.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            mainBinding.setVariable(BR.categoryAdapter, categoryListAdapter)


        })

        mainBinding.viewmodel!!.updateList.observe(this, {

            mViewPagerAdapter.notifyDataSetChanged()
        })

        mainBinding.viewmodel!!.updateClasstypeList.observe(this, {

            classTypeAdapter.notifyDataSetChanged()
        })

        mainBinding.viewmodel!!.refreshCategory.observe(this, {

            categoryListAdapter.notifyDataSetChanged()
        })

    }



    override fun manageClassesList(data: Gym) {
        if (data.popular_clasess.isEmpty()) {
            Toast.makeText(this, getString(R.string.no_class_found), Toast.LENGTH_SHORT).show()
        }
        popularClases.clear()
        popularClases.addAll(data.popular_clasess)
        mainBinding.classesTypeRV!!.layoutManager = LinearLayoutManager(this)
        classTypeAdapter = ClassesTypeAdapter(popularClases, this)
        mainBinding.setVariable(BR.classesTypeAdapter, classTypeAdapter)
    }

    override fun clickOnParentView(data: Gym) {
        manageClassesList(data)

    }

    override fun favUnfavPopular(data: ClassTypes) {
        mainBinding.viewmodel?.likeunLikePopularClass(data)

    }

    override fun favUnfavCategory(data: PopularcClassesModel) {
        mainBinding.viewmodel?.selectUnselectCategory(data)

    }
    override fun gymItemLikeUnlike(data: Gym) {
        mainBinding.viewmodel?.likeUnlike(data)
    }

}