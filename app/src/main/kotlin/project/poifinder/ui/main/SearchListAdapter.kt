package project.poifinder.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import project.poifinder.R
import project.poifinder.data.model.Item
import project.poifinder.databinding.ItemSearchResultListBinding

class SearchListAdapter : RecyclerView.Adapter<SearchListAdapter.ItemViewHolder>() {

    private var itemList = listOf<Item>()

    private var clickListener: ListItemClickListener? = null

    override fun getItemCount() = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListAdapter.ItemViewHolder =
        DataBindingUtil.inflate<ItemSearchResultListBinding>(
            LayoutInflater.from(parent.context), R.layout.item_search_result_list, parent, false).let {
                ItemViewHolder(it)
        }

    override fun onBindViewHolder(holder: SearchListAdapter.ItemViewHolder, position: Int)  = holder.bind(itemList[position])

    inner class ItemViewHolder(private val binding: ItemSearchResultListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.apply {
                data = item
                executePendingBindings()
                root.setOnClickListener {
                    clickListener?.onItemClick(it, item)
                }
            }
        }
    }

    fun setListItems(list: List<Item>) {
        itemList = list
    }

    fun setItemClickListener(listener: ListItemClickListener?) {
        clickListener = listener
    }

    interface ListItemClickListener {
        fun onItemClick(view: View, item: Item)
    }

}