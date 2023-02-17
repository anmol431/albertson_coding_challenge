package com.sample.albertson_coding_challenge.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.albertson_coding_challenge.databinding.ItemVariationListBinding
import com.sample.albertson_coding_challenge.model.Variations


class VariationListAdapter(private val lfsList: List<Variations>) :
    RecyclerView.Adapter<VariationListAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return lfsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.variationData = lfsList[position]

        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =
            ItemVariationListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: ItemVariationListBinding) :
        RecyclerView.ViewHolder(binding.root)

}