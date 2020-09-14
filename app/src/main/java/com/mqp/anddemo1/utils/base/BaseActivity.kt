package com.mqp.anddemo1.utils.base

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {



    public abstract fun initViewId(): Int;

//    做一些初始化作业
    protected  open  fun initBefore(){}
    protected  open  fun init(){}
//    请求数据
    protected  open  fun initData(){}
//    设置页面相应的自定义交互事件
    protected  open  fun initAction(){}

    protected open fun delayAction(what: Int) {}


    protected open fun isFullScreen(): Boolean {
        return true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        hiddenStatusBar()
        setContentView(initViewId())

        initBefore()
        init()
        initData()
        initAction()

    }


    fun hiddenStatusBar(){

        //无title
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        //全屏
        //全屏
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

    }


}