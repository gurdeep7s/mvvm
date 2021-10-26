package com.strideinfo.assignment.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.strideinfo.assignment.R
import com.strideinfo.assignment.databinding.AdapterPopularClasessBinding
import com.strideinfo.assignment.ui.MainActivity
import com.strideinfo.assignment.ui.model.Gym
import com.strideinfo.assignment.ui.model.PopularcClassesModel
import com.strideinfo.assignment.util.ClickInterface

class PopularClassesAdapter(
    var array: ArrayList<PopularcClassesModel>,
    mainActivity: MainActivity,
    var clickListener: ClickInterface
) : RecyclerView.Adapter<PopularClassesAdapter.Holder>() {
    class Holder(var binding: AdapterPopularClasessBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        var binding = AdapterPopularClasessBinding.inflate(inflater)


        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val positionInList: Int = position % array.size
        holder.binding.categoryData = array.get(positionInList)
        holder.binding.executePendingBindings()
        holder.binding.imageIV.setTag(array.get(positionInList))
        holder.binding.imageIV.setOnClickListener {
            var data = it.getTag() as PopularcClassesModel
            clickListener.favUnfavCategory(data)
        }
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    companion object {

        @JvmStatic
        @BindingAdapter("setImage")
        fun setImage(view: ImageView, data: PopularcClassesModel) {
            view.setImageResource(data.image)
        }
    }
}