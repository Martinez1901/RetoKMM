package com.example.retokmm.android.ui.comic

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.retokmm.android.R
import com.example.retokmm.android.databinding.ItemComicBinding
import com.example.retokmm.android.core.inflate
import com.example.retokmm.model.ComicShared

class ComicAdapter(private val clickComic: ClickComic) :
    ListAdapter<ComicShared, ComicAdapter.ViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_comic)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comic = getItem(position)
        holder.bind(comic)
        holder.binding.root.setOnClickListener {
            clickComic.onClick(comic)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemComicBinding.bind(view)

        fun bind(comic: ComicShared) {
            binding.imgComic.load(comic.thumbnailPath) {
                crossfade(true)
                placeholder(R.drawable.ic_image)
            }

            binding.tvComics.text = comic.title
        }

    }
}

interface ClickComic {
    fun onClick(comic: ComicShared)
}

private object DiffUtilCallback : DiffUtil.ItemCallback<ComicShared>() {
    override fun areItemsTheSame(oldItem: ComicShared, newItem: ComicShared): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ComicShared, newItem: ComicShared): Boolean =
        oldItem == newItem

}