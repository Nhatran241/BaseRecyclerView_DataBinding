package io.vimai.stb.modules.common.controls.ribbonverticalpager

import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pawegio.kandroid.layoutInflater
import io.vimai.stb.databinding.ItemRibbonBinding
import io.vimai.stb.modules.common.controls.layoutmanager.CustomLinearLayoutManager
import io.vimai.stb.modules.common.controls.ribbon.RibbonEpisodeBinding
import java.util.concurrent.Executors

class RibbonBindingAdapter : ListAdapter<RibbonViewModel, RibbonBindingAdapter.ViewHolder>(
    AsyncDifferConfig.Builder(RibbonItemDiffCallback())
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
) {
    class RibbonItemDiffCallback : DiffUtil.ItemCallback<RibbonViewModel>() {
        override fun areItemsTheSame(oldItem: RibbonViewModel, newItem: RibbonViewModel): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: RibbonViewModel,
            newItem: RibbonViewModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("ribbonViewModels")
        fun setRibbonViewModels(recyclerView: RecyclerView, ribbonList: List<RibbonViewModel>?) {
            if (ribbonList == null) {
                return
            }

            var adapter = recyclerView.adapter as? RibbonBindingAdapter
            if (adapter == null) {
                adapter = RibbonBindingAdapter()
                recyclerView.adapter = adapter
            }

            adapter.submitList(ribbonList)
        }
    }

    inner class ViewHolder(val binding: ItemRibbonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RibbonViewModel) {
            binding.item = item
            val adapter = RibbonEpisodeBinding.Adapter().apply {
                submitList(item.episodeModelList)
            }
          