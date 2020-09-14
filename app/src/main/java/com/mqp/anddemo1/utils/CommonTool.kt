package com.mqp.anddemo1.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.mqp.anddemo1.app.Constants
import com.orhanobut.logger.Logger
import com.orhanobut.logger.Logger.d


public class CommonTool {



    /**
     *
     *    fun toast(text: String) {
    runOnUiThread {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
    }
     * */

    companion object{

        fun toast(text: String,context: Context) {
            kotlin.run {
                Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
            }

        }

        /**
         * 打印Log日志
         *
         * @param obj
         */
        fun print(obj: Any?) {
            if (Constants.IS_LOGGER) {
                Logger.d(obj)
            }
        }

        /**
         * 打印JSon
         *
         * @param json
         */
        fun printJson(json: String?) {
            if (Constants.IS_LOGGER) {
                Logger.json(json)
            }
        }


    }



}