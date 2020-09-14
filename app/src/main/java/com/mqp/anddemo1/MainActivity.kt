package com.mqp.anddemo1

import android.content.Intent
import com.mqp.anddemo1.ui.activity.*
import com.mqp.anddemo1.utils.base.BaseActivity
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger.addLogAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_login.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.Logger


class MainActivity : BaseActivity() {


    override fun initBefore() {
        super.initBefore()

//        Logger.addLogAdapter(AndroidLogAdapter);
        //Logger.addLogAdapter(new AndroidLogAdapter());
//        Logger.addLogAdapter(AndroidLogAdapter());
    }

    override fun initViewId(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        super.init()

        textView2.text = System.currentTimeMillis().toString()
        textView2.text = getNow()


    }

    override fun initAction() {
        super.initAction()

        btn_dialog.setOnClickListener { 
            var intent = Intent(this, ActivityDialog::class.java)
            this.startActivity(intent)
        }

        btn_gridview.setOnClickListener {
            var intent = Intent(this, ActivityGrid::class.java)
            this.startActivity(intent)
        }


        btn_listview.setOnClickListener {

            var intent = Intent(this, ActivityListView::class.java)
            this.startActivity(intent)

        }

        btn_tabbar.setOnClickListener {

        var intent = Intent(this, ActivityTabbar::class.java)

        this.startActivity(intent)
        }
        button_welcome.setOnClickListener {
            var intent = Intent(this, ActivityWelcome::class.java)
            this.startActivity(intent)
        }
        btn_req.setOnClickListener {
            var intent = Intent(this, ActivityRequest::class.java)
            this.startActivity(intent)
        }
        btn_login2.setOnClickListener {
            var intent = Intent(this, ActivityLogin::class.java)
            this.startActivity(intent)
        }
    }


    fun getNow(): String {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Date())
        } else {
            var tms = Calendar.getInstance()
            return tms.get(Calendar.YEAR).toString() + "-" + tms.get(Calendar.MONTH)
                .toString() + "-" + tms.get(Calendar.DAY_OF_MONTH).toString() + " " + tms.get(
                Calendar.HOUR_OF_DAY
            ).toString() + ":" + tms.get(Calendar.MINUTE)
                .toString() + ":" + tms.get(Calendar.SECOND)
                .toString() + "." + tms.get(Calendar.MILLISECOND).toString()
        }

    }


}
