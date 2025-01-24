package com.route.islamic41gmonthu.chapterDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islamic41gmonthu.R
import com.route.islamic41gmonthu.databinding.ActivityChapterDetailsBinding
import com.route.islamic41gmonthu.home.adapters.VersesAdapter
import com.route.islamic41gmonthu.home.model.AppConstants
import com.route.islamic41gmonthu.home.model.Chapter

class ChapterDetailsActivity : AppCompatActivity() {
    var chapter: Chapter? = null
    lateinit var adapter: VersesAdapter
    lateinit var binding: ActivityChapterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        chapter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(AppConstants.CHAPTER_KEY, Chapter::class.java)
        } else {
            intent.getParcelableExtra(AppConstants.CHAPTER_KEY)
        }
        adapter = VersesAdapter(readChapterDetailsFile(chapter?.order))
        binding.versesRecyclerView.adapter = adapter
        binding.chapterTitleEnTextView.text = chapter?.titleEn
        binding.chapterTitleArTextView.text = chapter?.titleAr
        binding.backIcon.setOnClickListener {
            finish()
        }

    }

    private fun readChapterDetailsFile(order: Int?): List<String> {
        val fileContent = assets.open("quran/${order}.txt").bufferedReader().use {
            it.readText()
        }
        return fileContent.split("\n").map {
            it.trim()
        }
    }
}