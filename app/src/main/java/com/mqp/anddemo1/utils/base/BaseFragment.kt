package com.mqp.anddemo1.utils.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mqp.anddemo1.R

abstract class BaseFragment :Fragment(){



    public abstract fun initViewId(): Int;


    //    做一些初始化作业
    protected  open  fun initBefore(){}
    protected  open  fun init(){}
    //    请求数据
    protected  open  fun initData(){}
    //    设置页面相应的自定义交互事件
    protected  open  fun initAction(){}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(initViewId(),container,false)


        initBefore()
        init()
        initData()
        initAction()

        return  root;
    }

}