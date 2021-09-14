package com.garcia.recyclerviewvsgroupie.fragments.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.garcia.recyclerviewvsgroupie.databinding.MockedDataItemViewBinding
import com.garcia.recyclerviewvsgroupie.domain.models.Ohlc

class RVAdapter(val callback: (Long) -> Unit): RecyclerView.Adapter<RVAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: MockedDataItemViewBinding): RecyclerView.ViewHolder(binding.root)
    var data = listOf<Ohlc>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MockedDataItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        with(holder.binding){
            textViewPosition.text = position.toString()
            textViewTimestamp.text = item.timestamp
        }
        if(position == 23)
            callback(System.currentTimeMillis())
    }

    override fun getItemCount() = data.size
}
