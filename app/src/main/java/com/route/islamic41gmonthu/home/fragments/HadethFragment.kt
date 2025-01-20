package com.route.islamic41gmonthu.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.google.android.material.carousel.HeroCarouselStrategy
import com.route.islamic41gmonthu.databinding.FragmentHadethBinding
import com.route.islamic41gmonthu.databinding.FragmentQuranBinding
import com.route.islamic41gmonthu.home.adapters.HadethAdapter
import com.route.islamic41gmonthu.home.model.Hadeth

class HadethFragment : Fragment() {
    lateinit var binding: FragmentHadethBinding
    lateinit var adapter: HadethAdapter
    lateinit var layoutManager: CarouselLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager =
            CarouselLayoutManager(FullScreenCarouselStrategy(), CarouselLayoutManager.HORIZONTAL)
        layoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
        val carouselSnapHelper = CarouselSnapHelper()
        carouselSnapHelper.attachToRecyclerView(binding.hadethListRecyclerView)
        adapter = HadethAdapter(readHadethFile())
        binding.hadethListRecyclerView.adapter = adapter
        binding.hadethListRecyclerView.layoutManager = layoutManager
    }

    private fun readHadethFile(): List<Hadeth> {
        val fileContent =
            requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        val hadethList = fileContent.trim().split("#")
        return hadethList.map { hadethContent ->
            val singleHadethCotnent = hadethContent.trim().split("\n")
            val title = singleHadethCotnent[0]
            val description =
                singleHadethCotnent.subList(1, singleHadethCotnent.size).joinToString()
            Hadeth(title, description)
        }
    }

}