package com.mqp.anddemo1.ui.activity

import android.view.View
import com.mqp.anddemo1.R
import com.mqp.anddemo1.adapter.AdapterGridView
import com.mqp.anddemo1.utils.CommonTool
import com.mqp.anddemo1.utils.base.BaseActivity
import kotlinx.android.synthetic.main.layout_gridview.*

class ActivityGrid :BaseActivity(){
    override fun initViewId(): Int {
        return R.layout.layout_gridview
    }

    override fun init() {
        super.init()
    }

    override fun initData() {
        super.initData()

        var adapter = AdapterGridView();
        adapter.data = arrayListOf<String>("a","b","c","d","e")
        adapter.setOnItemClickListener(object :AdapterGridView.kOnItemClickListener{
            override fun onItemclick(view: View, index: Int) {
                CommonTool.toast(index.toString(),this@ActivityGrid)
            }
        })

        cv_grid_id.adapter = adapter
    }

}