package com.route.islamic41gmonthu.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamic41gmonthu.databinding.ItemChapterBinding
import com.route.islamic41gmonthu.home.adapters.callback.OnChapterClickListener
import com.route.islamic41gmonthu.home.model.Chapter

// List -> Parent
// ArrayList -> Child
// Outer Class
class ChaptersAdapter(val chaptersList: List<Chapter>) :
    Adapter<ChaptersAdapter.ChapterViewHolder>() {
    var onChapterClickListener: OnChapterClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemChapterBinding.inflate(inflater, parent, false)
        return ChapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return chaptersList.size
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val chapter = chaptersList[position]
        holder.bind(chapter, position)
    }

    // Inner Class
    inner class ChapterViewHolder(val binding: ItemChapterBinding) : ViewHolder(binding.root) {
        fun bind(chapter: Chapter, position: Int) {
            binding.chapterOrderTextView.text = "${chapter.order}"
            binding.chapterLengthTextView.text = "${chapter.length} Verses"
            binding.chapterTitleArTextView.text = chapter.titleAr
            binding.chapterTitleEnTextView.text = chapter.titleEn
            binding.root.setOnClickListener {
                onChapterClickListener?.onChapterClick(chapter, position)
            }
        }
    }

}