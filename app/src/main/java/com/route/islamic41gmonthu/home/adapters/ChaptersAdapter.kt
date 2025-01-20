package com.route.islamic41gmonthu.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamic41gmonthu.databinding.ItemChapterBinding
import com.route.islamic41gmonthu.home.model.Chapter

// List -> Parent
// ArrayList -> Child
class ChaptersAdapter(val chaptersList: List<Chapter>) :
    Adapter<ChaptersAdapter.ChapterViewHolder>() {

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
        holder.bind(chapter)
    }

    class ChapterViewHolder(val binding: ItemChapterBinding) : ViewHolder(binding.root) {
        fun bind(chapter: Chapter) {
            binding.chapterOrderTextView.text = "${chapter.order}"
            binding.chapterLengthTextView.text = "${chapter.length} Verses"
            binding.chapterTitleArTextView.text = chapter.titleAr
            binding.chapterTitleEnTextView.text = chapter.titleEn
        }
    }

}