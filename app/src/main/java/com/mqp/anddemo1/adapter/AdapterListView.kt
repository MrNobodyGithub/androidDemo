package com.mqp.anddemo1.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.mqp.anddemo1.R
import com.mqp.anddemo1.utils.CommonTool
import kotlinx.android.synthetic.main.item_layout_listview.view.*
import java.util.*

class AdapterListView : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var data:List<Any>
    private  lateinit var  onItemClickListener:OnItemClickListener
    fun setOnItemClickListener(listener: OnItemClickListener){
        this.onItemClickListener = listener
    }



    /**
     * 1 设置总数量
     * 2 设置单元view
     * 3 设置单元数据
     * */



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val con_id = R.layout.item_layout_listview

        val inflate = LayoutInflater.from(parent.context).inflate(con_id, parent,false)

        return  HolderListView(inflate);

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is HolderListView){
            holder.bindData(data[position].toString() +  position.toString())


            holder.itemView.button2.setOnClickListener {
                onItemClickListener.onItemClick(holder.itemView.button2,position)
            }
            holder.itemView.textView8.setOnClickListener {
                onItemClickListener.onItemClick(holder.itemView.textView8,position)
            }

            holder.itemView.setOnClickListener {
                onItemClickListener.onItemClick(holder.itemView,position)
            }
        }
    }


    override fun getItemCount(): Int {
        return data.count();
    }


    interface  OnItemClickListener{
        fun onItemClick(view:View, position:Int)
    }



    private class HolderListView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(value: String) {
            itemView.textView8.text = value;
        }
    }



}



























