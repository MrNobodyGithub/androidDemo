package com.mqp.anddemo1.app

import android.app.Application
import android.util.Log
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

class App : Application() {


    companion object {
        private lateinit var instance:App;

        fun getInstance():App{
            return instance;
        }
    }


    override fun onCreate() {
        super.onCreate()

        Log.v("tag d", "-------temp---");
        initLog();
    }

    fun initLog() {
        var format: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)
            .methodCount(1)
            .methodOffset(3)
            .tag("anddemo1-log")
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(format));

    }

}