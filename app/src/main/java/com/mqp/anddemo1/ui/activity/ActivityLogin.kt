package com.mqp.anddemo1.ui.activity

import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.mqp.anddemo1.R
import com.mqp.anddemo1.bean.BaseBean
import com.mqp.anddemo1.bean.ResultBean
import com.mqp.anddemo1.data.HttpUtils
import com.mqp.anddemo1.data.OnResultListener
import com.mqp.anddemo1.utils.CommonTool
import com.mqp.anddemo1.utils.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_login.*
import kotlinx.android.synthetic.main.layout_login.btn_login
import java.util.*
import java.util.logging.Handler
import kotlin.concurrent.fixedRateTimer

class ActivityLogin : BaseActivity() {


    lateinit var timer: Timer
    private var code_number: Int = 60;


    override fun initViewId(): Int {
        return R.layout.layout_login;
    }

    override fun init() {
        super.init()
    }

    override fun initAction() {
        super.initAction()

        btn_login.setOnClickListener {

//            CommonTool.toast("this is toast",this);
            requestDataLogin()
        }

        btn_getvcode.setOnClickListener {


            initTimer()
        }

    }

    //-------- reqest --------
    fun requestDataLogin() {
        //            var mobile = et_mobile.text;
//            var code = et_vcode.text;
        var mobile = "1314138443";
        var code = "564892"
        HttpUtils.getInstance().reqLogin(object : OnResultListener<ResultBean<Any>> {
            override fun success(result: ResultBean<Any>) {
                println("----------------------success login----------------------");
            }

            override fun fail(msg: String?) {
                println("----------------------fail login----------------------");
            }
        }, mobile, code);
    }

    fun requestDataSendCode() {
        if (!checkExistPhone()) {
            return;
        }

        val mobile = "13141384483";
        HttpUtils.getInstance().getVcode(object : OnResultListener<ResultBean<Any>> {
            override fun success(result: ResultBean<Any>) {
            }

            override fun fail(msg: String?) {
            }
        }, mobile)
    }

    //-------- other --------

    fun initTimer() {
        /**
         *
         * 设置按钮 点击手势不相应
         * */
        btn_getvcode.isClickable = false;
//        if (::timer.isInitialized){
//            Log.v("tag d"," timer has init");
//            return;
//        }else{
//            Log.v("tag d"," timer has not init");
//        }



        Log.v("tag d"," timer has initing");
        timer = fixedRateTimer("", false, 0, 1000) {
            Log.d("tag d", " time action " + code_number.toString());
            toast("loading" + code_number.toString());

            code_number = code_number - 1;

            runOnUiThread {
                btn_getvcode.text = code_number.toString() + "s";
            }



//            btn_getvcode.text = "123";
            if (code_number == 55) {
                toast("finish")
                timeStop()
                code_number = 60
                btn_getvcode.isClickable = true;
                runOnUiThread {
                    btn_getvcode.text = "获取验证码"
                }
            }
        }


    }

    fun timeStop() {
        timer.cancel()
        timer.purge()

    }

    fun toast(text: String) {
        runOnUiThread {
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }

    fun checkExistPhone(): Boolean {
        return et_mobile.text.length != 0;
    }


}