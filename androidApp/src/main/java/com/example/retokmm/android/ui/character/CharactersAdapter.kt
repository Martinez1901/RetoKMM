package com.example.retokmm.android.ui.character

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.retokmm.android.Character
import com.example.retokmm.android.R
import com.example.retokmm.android.databinding.ItemCharactersBinding
import com.scotiabank.bootcamp.squad3.digitalsbc.core.inflate

class CharactersAdapter(val list: List<Character>, val clickCharcter: ClickCharcter): RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_characters)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = list[position]
        holder.bind(character)
        holder.binding.root.setOnClickListener {
            clickCharcter.onClick(character)
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val binding = ItemCharactersBinding.bind(view)

        fun bind(character: Character) {
            binding.imgCharacter.load(character.thumbnailPath) {
                crossfade(true)
                placeholder(R.drawable.ic_image)
                transformations(CircleCropTransformation())
            }
            binding.tvNameCharacter.text = character.name
        }
    }
}

interface ClickCharcter {
    fun onClick(character: Character)
}