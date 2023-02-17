package com.sample.albertson_coding_challenge.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.albertson_coding_challenge.databinding.ItemLfsListBinding
import com.sample.albertson_coding_challenge.model.Lfs


class LfsListAdapter(private val lfsList: List<Lfs>) :
    RecyclerView.Adapter<LfsListAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return lfsList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.lfsData = lfsList[position]

        holder.binding.rcvVarList.adapter =
            lfsList[position].vars?.let { VariationListAdapter(it.asList()) }

        holder.binding.tvView.setOnClickListener {
            holder.binding.isShown = holder.binding.rcvVarList.visibility != View.VISIBLE
        }

        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemLfsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: ItemLfsListBinding) : RecyclerView.ViewHolder(binding.root)

}