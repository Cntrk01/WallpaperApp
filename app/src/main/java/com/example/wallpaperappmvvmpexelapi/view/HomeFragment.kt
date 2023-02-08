package com.example.wallpaperappmvvmpexelapi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaperappmvvmpexelapi.R
import com.example.wallpaperappmvvmpexelapi.adapter.WallPaperPagingAdapter
import com.example.wallpaperappmvvmpexelapi.databinding.FragmentDetailBinding
import com.example.wallpaperappmvvmpexelapi.databinding.FragmentHomeBinding
import com.example.wallpaperappmvvmpexelapi.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterWallpaper: WallPaperPagingAdapter

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.imageSearchButton.setOnClickListener {
            val searched=binding.imageName.text.toString()
            viewModel.setName(searched)
        }

        setupRecyclerAdapter()

        viewModel.wallPaperList.observe(viewLifecycleOwner, Observer {
            adapterWallpaper.submitData(lifecycle, it)
        })
    }

    private fun setupRecyclerAdapter() {
        adapterWallpaper = WallPaperPagingAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapterWallpaper
    }


}