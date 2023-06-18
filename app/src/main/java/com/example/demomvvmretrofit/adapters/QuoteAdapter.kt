package com.example.demomvvmretrofit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvvmretrofit.databinding.ItemRowBinding
import com.example.demomvvmretrofit.models.Result
import javax.inject.Inject


class QuoteAdapter @Inject constructor() :
    ListAdapter<Result, QuoteAdapter.QuoteViewHolder>(QuoteListDifUtil()) {

    lateinit var binding: ItemRowBinding

    inner class QuoteViewHolder(val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(quote: Result) {
            binding.quote = quote
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        this.binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuoteViewHolder(this.binding)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val rowData = getItem(position)
        holder.bind(rowData)
    }

    class QuoteListDifUtil : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

    }
}