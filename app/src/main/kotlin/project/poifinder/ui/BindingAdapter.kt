package project.poifinder.ui

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("bind:text")
fun setText(view: TextView, text: String?) {
    view.text = text
}