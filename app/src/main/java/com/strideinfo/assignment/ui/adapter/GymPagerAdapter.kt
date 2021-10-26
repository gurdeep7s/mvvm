package com.strideinfo.assignment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.strideinfo.assignment.databinding.AdapterGymListItemBinding
import com.strideinfo.assignment.ui.model.Gym
import com.strideinfo.assignment.util.ClickInterface
import com.strideinfo.assignment.util.Constants
import java.util.*


class GymPagerAdapter(
    var list: ArrayList<Gym>,
    var context: Context,
    var clickListener: ClickInterface
) : PagerAdapter() {
    override fun getCount(): Int {
        return Int.MAX_VALUE
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as CardView

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val positionInList: Int = position % list!!.size

        val inflater = LayoutInflater.from(container.context)
        var binding = AdapterGymListItemBinding.inflate(inflater)
        binding.mydata = list!!.get(positionInList)
        binding.executePendingBindings()

        binding.selectedIV.setTag(list!!.get(positionInList))
        binding.selectedIV.setOnClickListener {
            var data = it.getTag() as Gym

            clickListener.gymItemLikeUnlike(data)

        }

        binding.cardCV.setTag(list!!.get(positionInList))
        binding.cardCV.setOnClickListener {
            var data = it.getTag() as Gym
            clickListener.clickOnParentView(data)
        }

        Objects.requireNonNull(container).addView(binding.root);

        return binding.root;
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as CardView?)
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun getPageWidth(position: Int): Float {
        return 0.7f
    }



    //loc is not in the data so i kept static location
    companion object {
        @JvmStatic
        @BindingAdapter("mapimage")
        fun mapimage(view: ImageView, data: Gym) {
            var lat = "30.7046";
            var longi = "76.7179";
            var url =
                Constants.GOOGLE_STATIC_MAP_BASE_URL + lat + "," + longi + "&zoom=12&size=400x200&sensor=false&markers=color:red%7Clabel:" + data.title + "%7C" + lat + "," + longi + "&key=" + Constants.GOOGLE_MAP_KEY
            Glide
                .with(view)
                .load(url)
                .into(view);

        }
    }


}



