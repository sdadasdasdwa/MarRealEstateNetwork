package com.example.marsrealestatenetwork.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marsrealestatenetwork.databinding.GridviewItemBinding
import com.example.marsrealestatenetwork.network.MarsProperty

class PhotoGridAdapter(private val onClickListener: OnClickListener ) : ListAdapter<MarsProperty,PhotoGridAdapter.MarsPropertyViewHolder>(DiffCallback) {


    class MarsPropertyViewHolder(private var binding : GridviewItemBinding) : RecyclerView.ViewHolder(binding.root){


        fun bind(marsProperty: MarsProperty){
            binding.property = marsProperty
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPropertyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = GridviewItemBinding.inflate(layoutInflater,parent,false)
        return MarsPropertyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarsPropertyViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(marsProperty)
        }
        holder.bind(marsProperty)

    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsProperty>() {
        override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class OnClickListener(val clickListener : (marsProperty:MarsProperty)-> Unit){
        fun onClick(marsProperty:MarsProperty) = clickListener(marsProperty)
    }

}




