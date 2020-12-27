package project.poifinder.ui

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import project.poifinder.data.model.Item
import project.poifinder.ui.main.SearchListAdapter

@BindingAdapter("bind:text")
fun setText(view: TextView, text: String?) {
    view.text = text
}

@BindingAdapter("bind:items")
fun setItems(view: RecyclerView, items: List<Item>?) {
    (view.adapter as SearchListAdapter).apply {
        setListItems(items ?: emptyList())
        notifyDataSetChanged()
    }
}