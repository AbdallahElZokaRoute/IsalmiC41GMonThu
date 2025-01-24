package com.route.islamic41gmonthu.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamic41gmonthu.databinding.ItemVerseBinding

class VersesAdapter(val verses: List<String>) : Adapter<VersesAdapter.VerseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemVerseBinding.inflate(inflater, parent, false)
        return VerseViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return verses.size
    }

    override fun onBindViewHolder(holder: VerseViewHolder, position: Int) {
        val item = verses[position]
        holder.bind(item, position)
    }

    class VerseViewHolder(val binding: ItemVerseBinding) : ViewHolder(binding.root) {
        fun bind(verse: String, position: Int) {
            binding.verse.text = "$verse [${position + 1}]"
        }
    }

}
