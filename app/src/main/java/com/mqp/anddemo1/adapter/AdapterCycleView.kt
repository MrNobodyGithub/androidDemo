package com.mqp.anddemo1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mqp.anddemo1.R

class AdapterCycleView :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    lateinit var data:List<Any>
    private  lateinit var  onItemClickListener: kOnItemClickListener
    fun setOnItemClickListener(listener: kOnItemClickListener){
        this.onItemClickListener = listener;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HolderCycleView(LayoutInflater.from(parent.context).inflate(R.layout.item_layout_cycleview,parent,false))
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HolderCycleView){
            holder.bindData(data[position])

            holder.itemView.setOnClickListener {
                onItemClickListener.onItemclick(holder.itemView,position)
            }
        }
    }


    interface kOnItemClickListener{
        fun onItemclick(view: View, index:Int)
    }

    private class HolderCycleView(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bindData(m:Any){
//            itemView.cell_gridview.text = m.toString()
        }
    }


}


