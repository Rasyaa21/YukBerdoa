package com.example.kumpulandoadoa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kumpulandoadoa.databinding.DataLayoutBinding
import kotlin.math.sign

class PostAdapter(private val list: ArrayList<DoaAPIItem>):
    RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

        inner class PostViewHolder(private val binding: DataLayoutBinding) :
            RecyclerView.ViewHolder(binding.root){

                fun bind(doaAPIItem: DoaAPIItem){
                    binding.apply {
                        val namaDoa = "${doaAPIItem.doa}\n"
                        val ayat = "${doaAPIItem.ayat}"

                        tvNamaDoa.text = namaDoa
                        tvAyatDoa.text = ayat

                    }
                }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding : DataLayoutBinding = DataLayoutBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }
}