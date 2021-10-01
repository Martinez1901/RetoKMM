package com.example.retokmm.android.ui.comic

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.retokmm.android.Character
import com.example.retokmm.android.R
import com.example.retokmm.android.databinding.ItemComicBinding
import com.scotiabank.bootcamp.squad3.digitalsbc.core.inflate

class ComicAdapter(var list: List<Character>, val clickComic: ClickComic): RecyclerView.Adapter<ComicAdapter.ViewHolder>(){

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

        fun bind(comic: Character) {
            binding.imgComic.load(comic.thumbnailPath)
            binding.tvComics.text = comic.name
        }

    }
}

interface ClickComic {
    fun onClick(character: Character)
}