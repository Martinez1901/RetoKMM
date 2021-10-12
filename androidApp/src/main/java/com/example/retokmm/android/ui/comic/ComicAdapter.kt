package com.example.retokmm.android.ui.comic

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.retokmm.android.R
import com.example.retokmm.android.databinding.ItemComicBinding
import com.example.retokmm.android.core.inflate
import com.example.retokmm.model.ComicShared

class ComicAdapter(var list: List<ComicShared>, val clickComic: ClickComic): RecyclerView.Adapter<ComicAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_comic)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comic = list[position]
        holder.bind(comic)
        holder.binding.root.setOnClickListener {
            clickComic.onClick(comic)
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val binding = ItemComicBinding.bind(view)

        fun bind(comic: ComicShared) {
            binding.imgComic.load(comic.thumbnailPath) {
                crossfade(true)
                placeholder(R.drawable.ic_image)
                transformations(CircleCropTransformation())
            }

            binding.tvComics.text = comic.title
        }

    }
}

interface ClickComic {
    fun onClick(comic: ComicShared)
}