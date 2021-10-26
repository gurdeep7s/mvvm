package com.strideinfo.assignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.strideinfo.assignment.databinding.AdapterClassesTypeBinding
import com.strideinfo.assignment.ui.model.ClassTypes
import com.strideinfo.assignment.util.ClickInterface

class ClassesTypeAdapter(var list: ArrayList<ClassTypes>, var clickListener:ClickInterface) :
    RecyclerView.Adapter<ClassesTypeAdapter.Holder>() {
    class Holder(var binding: AdapterClassesTypeBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)

        var binding = AdapterClassesTypeBinding.inflate(inflater)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.data = list.get(position)
        holder.binding.executePendingBindings()

        holder.binding.selectedIV.setTag(list.get(position))
        holder.binding.selectedIV.setOnClickListener{
            var data= it.getTag() as ClassTypes
            clickListener.favUnfavPopular(data)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}