package com.route.islamic41gmonthu.home.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic41gmonthu.chapterDetails.ChapterDetailsActivity
import com.route.islamic41gmonthu.databinding.FragmentQuranBinding
import com.route.islamic41gmonthu.home.adapters.ChaptersAdapter
import com.route.islamic41gmonthu.home.adapters.callback.OnChapterClickListener
import com.route.islamic41gmonthu.home.model.AppConstants

class QuranFragment : Fragment() {
    lateinit var binding: FragmentQuranBinding
    lateinit var adapter: ChaptersAdapter

    // Continue Islamic App
    //          ChapterDetailsActivity
    //
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ChaptersAdapter(AppConstants.getChaptersList())
        adapter.onChapterClickListener = OnChapterClickListener { chapter, position ->
            // Logic
            val intent = Intent(activity, ChapterDetailsActivity::class.java)
            intent.putExtra(AppConstants.CHAPTER_KEY, chapter)
            startActivity(intent)
        }
        binding.chaptersListRecyclerView.adapter = adapter
    }
}