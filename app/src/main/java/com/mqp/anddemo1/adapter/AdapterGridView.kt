package com.mqp.anddemo1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.mqp.anddemo1.R
import kotlinx.android.synthetic.main.item_layout_grid.view.*

class AdapterGridView :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    lateinit var data:List<Any>
    private  lateinit var  onItemClickListener: kOnItemClickListener
    fun setOnItemClickListener(listener: kOnItemClickListener){
        this.onItemClickListener = listener;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HolderGridView(LayoutInflater.from(parent.context).inflate(R.layout.item_layout_grid,parent,false))
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HolderGridView){
            holder.bindData(data[position])

            holder.itemView.setOnClickListener {
                onItemClickListener.onItemclick(holder.itemView,position)
            }
        }
    }


    interface kOnItemClickListener{
        fun onItemclick(view: View, index:Int)
    }

    private class HolderGridView(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bindData(m:Any){
            itemView.cell_gridview.text = m.toString()
        }
    }




}