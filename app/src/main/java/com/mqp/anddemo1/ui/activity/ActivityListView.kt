package com.mqp.anddemo1.ui.activity

import android.util.Log
import android.view.View
import android.widget.Toast
import com.mqp.anddemo1.R
import com.mqp.anddemo1.adapter.AdapterListView
import com.mqp.anddemo1.utils.CommonTool
import com.mqp.anddemo1.utils.base.BaseActivity
import kotlinx.android.synthetic.main.layout_listview.*

class ActivityListView :BaseActivity(){

    override fun initViewId(): Int {
        return  R.layout.layout_listview;
    }

    override fun initData() {
        super.initData()

 
        val arr = arrayListOf("a","b","c","d","啊","额","的","の")
        val adapter = AdapterListView();
        adapter.data = arr;
        adapter.setOnItemClickListener(object :AdapterListView.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {

                Log.d("tag d",view.id.toString() + "------------id----------" + R.layout.item_layout_listview);





                if (view.id == R.id.textView8){
                    CommonTool.toast(" 当前点击的是textview  "+arr[position],this@ActivityListView);
                }else if(view.id == R.id.button2){
                    CommonTool.toast("当前点击的是btn "+arr[position],this@ActivityListView);
                }else{

                    CommonTool.toast("当前点击的是cell "+arr[position],this@ActivityListView);
                }



            }
        })

        cv_id.adapter = adapter


    }



}