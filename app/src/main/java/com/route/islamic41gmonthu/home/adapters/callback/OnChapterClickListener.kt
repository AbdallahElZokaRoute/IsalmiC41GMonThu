package com.route.islamic41gmonthu.home.adapters.callback

import com.route.islamic41gmonthu.home.model.Chapter

fun interface OnChapterClickListener {
    fun onChapterClick(chapter: Chapter, position: Int)
}