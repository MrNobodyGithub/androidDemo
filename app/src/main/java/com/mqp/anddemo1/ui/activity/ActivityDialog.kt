package com.mqp.anddemo1.ui.activity

import com.mqp.anddemo1.R
import com.mqp.anddemo1.utils.CommonTool
import com.mqp.anddemo1.utils.base.BaseActivity
import com.mqp.anddemo1.widget.DialogLoading
import com.mqp.anddemo1.widget.DialogLoading_j
import kotlinx.android.synthetic.main.layout_dialog.*

class ActivityDialog : BaseActivity() {


    override fun initViewId(): Int {
        return R.layout.layout_dialog
    }

    override fun initAction() {
        super.initAction()
        button4.setOnClickListener {
            CommonTool.toast("this is toast",this)
        }

        button.setOnClickListener {

            var loading = DialogLoading_j(this);
            loading.setMessage("new loading...")
            loading.show()

        }
        button3.setOnClickListener {
            var loading = DialogLoading(this)
            loading.show()

        }


    }
}