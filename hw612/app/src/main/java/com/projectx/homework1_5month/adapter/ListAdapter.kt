package com.projectx.homework1_5month.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.projectx.homework1_5month.databinding.CharacterItemBinding
import com.projectx.homework1_5month.models.Character

class CharacterListAdapter(

) : ListAdapter<Character, CharacterViewHolder>(
    diffItemCallBack
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

class CharacterViewHolder(val binding: ViewBinding) : ViewHolder(binding.root) {
    fun onBind(character: Character) {

    }
}

private val diffItemCallBack = object : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }

}