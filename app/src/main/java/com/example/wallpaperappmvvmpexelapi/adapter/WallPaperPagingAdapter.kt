package com.example.wallpaperappmvvmpexelapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.paging.PagingDataAdapter
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperappmvvmpexelapi.api.Api
import com.example.wallpaperappmvvmpexelapi.databinding.ItemWallpaperBinding
import com.example.wallpaperappmvvmpexelapi.view.HomeFragmentDirections
import com.example.wallpaperapppexelapi.model.Photo

class WallPaperPagingAdapter : PagingDataAdapter<Photo,WallPaperPagingAdapter.MyViewHolder>(diffUtil) {


    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<Photo>(){
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return  oldItem.id==newItem.id
            }
            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return  oldItem==newItem
            }
        }
    }



    class MyViewHolder(val binding : ItemWallpaperBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item=getItem(position)
        Glide.with(holder.itemView).load(item?.src?.portrait).into(holder.binding.imageView)

        holder.itemView.setOnClickListener {
            val intent=HomeFragmentDirections.actionHomeFragmentToDetailFragment(item?.src?.portrait!!)
            Navigation.findNavController(holder.itemView).navigate(intent)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemWallpaperBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}