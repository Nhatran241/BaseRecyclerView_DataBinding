package com.nhatran241.lib_recyclerview_databinding.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>( private val data: List<T>) : RecyclerView.Adapter<BaseAdapter.AdapterViewHolder>() {

    class AdapterViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(
            getBindingRoot(parent, viewType)
        )
    }
    abstract fun getBindingRoot(parent: ViewGroup, viewType: Int): View

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        setBindingViewModel(data[position])
    }

    abstract fun setBindingViewModel(position: T)

}
