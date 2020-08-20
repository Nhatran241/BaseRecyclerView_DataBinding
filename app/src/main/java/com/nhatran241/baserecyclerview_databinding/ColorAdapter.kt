package com.nhatran241.baserecyclerview_databinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nhatran241.baserecyclerview_databinding.databinding.ItemColorBinding
import com.nhatran241.lib_recyclerview_databinding.adapter.BaseAdapter

@BindingAdapter("setUpColorAdapter")
fun RecyclerView.setUpColorAdapter(listColor : List<ItemColorViewModel>?){
    layoutManager =LinearLayoutManager(context)
    adapter = listColor?.let { ColorAdapter(listColor) }
}
class ColorAdapter( data: List<ItemColorViewModel>) :
    BaseAdapter<ItemColorViewModel>( data) {
    lateinit var binding : ItemColorBinding
    override fun getBindingRoot(parent: ViewGroup, viewType: Int): View {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_color,parent ,false)
        return binding.root
    }
    override fun setBindingViewModel(position: ItemColorViewModel) {
        binding.model =position
    }
}