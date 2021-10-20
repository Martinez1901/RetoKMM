package com.example.retokmm.android.ui.character

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.retokmm.android.R
import com.example.retokmm.android.core.inflate
import com.example.retokmm.android.databinding.ItemCharactersBinding
import com.example.retokmm.model.CharacterShared

class CharactersAdapter(private val clickCharacter: ClickCharacter) :
    ListAdapter<CharacterShared, CharactersAdapter.ViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_characters)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
        holder.binding.root.setOnClickListener {
            clickCharacter.onClick(character)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemCharactersBinding.bind(view)

        fun bind(character: CharacterShared) {
            /*binding.imgCharacter.load("${character.thumbnailPath}/standard_fantastic.jpg") {
                crossfade(true)
                placeholder(R.drawable.ic_image)
                transformations(CircleCropTransformation())
            }*/
            binding.imgCharacter.load(character.thumbnailPath) {
                crossfade(true)
                placeholder(R.drawable.ic_image)
                transformations(CircleCropTransformation())
            }

            binding.tvNameCharacter.text = character.name
        }
    }
}

interface ClickCharacter {
    fun onClick(character: CharacterShared)
}


private object DiffUtilCallback : DiffUtil.ItemCallback<CharacterShared>() {
    override fun areItemsTheSame(oldItem: CharacterShared, newItem: CharacterShared): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CharacterShared, newItem: CharacterShared): Boolean =
        oldItem == newItem
}