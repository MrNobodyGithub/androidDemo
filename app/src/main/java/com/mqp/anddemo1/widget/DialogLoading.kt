package com.mqp.anddemo1.widget

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Dialog
import android.content.ContentUris
import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.flyco.dialog.utils.CornerUtils
import com.flyco.dialog.widget.base.BaseDialog
import com.mqp.anddemo1.R
import kotlinx.android.synthetic.main.z_layout_loading.*


class DialogLoading(context: Context) : BaseDialog<DialogLoading>(context ) {



    private  lateinit var  tv_m :TextView
    private  var  message = "kotlin loading"


    override fun onCreateView(): View {
        widthScale(0.55f)
        var v = View.inflate(context,R.layout.z_layout_loading_k,null)
        tv_m = v.findViewById(R.id.tv_message)



        v.setBackgroundDrawable(
            CornerUtils.cornerDrawable(Color.WHITE,10.0f)
        )


        return v
    }

    override fun setUiBeforShow() {
        tv_m.setText(message)
//        tv_message.text = "kotlin loading"
    }

}




















