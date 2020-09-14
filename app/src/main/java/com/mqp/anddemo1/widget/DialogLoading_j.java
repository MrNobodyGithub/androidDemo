package com.mqp.anddemo1.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.TextView;

import com.flyco.dialog.utils.CornerUtils;
import com.flyco.dialog.widget.base.BaseDialog;
import com.mqp.anddemo1.R;

public class DialogLoading_j extends BaseDialog<DialogLoading_j> {

    private TextView tv_message;
    //设置是否隐藏  当点击阴影是 默认点击自动一次那个
    private  boolean z_mCancel;
    private String message = "loading...";


    public  DialogLoading_j(Context context){
        super(context);
    }


//    mDisplayMetrics

    @Override
    public View onCreateView() {
        widthScale(0.55f);

        View view = View.inflate(getContext(), R.layout.z_layout_loading,null);
        tv_message = view.findViewById(R.id.tv_message);
        view.setBackgroundDrawable(CornerUtils.cornerDrawable(Color.parseColor("#ffffff"),dp2px(5)));
        return  view;
    }

    @Override
    public void setUiBeforShow() {
        tv_message.setText(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setZ_mCancel(boolean z_mCancel) {
        this.z_mCancel = z_mCancel;
        mCancel = z_mCancel;
    }
}


























