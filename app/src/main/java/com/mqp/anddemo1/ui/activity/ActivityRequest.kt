package com.mqp.anddemo1.ui.activity

import android.view.View
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager
import com.gigamole.infinitecycleviewpager.OnInfiniteCyclePageTransformListener
import com.mqp.anddemo1.R
import com.mqp.anddemo1.adapter.AdapterCycleView
import com.mqp.anddemo1.utils.base.BaseActivity

class ActivityRequest : BaseActivity() {


    override fun initViewId(): Int {
        return R.layout.layout_request
    }

    override fun init() {
        super.init()



//        val view = View.inflate(this,R.layout.layout_request,null)
//        var  cycleView : HorizontalInfiniteCycleViewPager = view.findViewById(R.id.cycle_view)
//
//         var adapterView = AdapterCycleView()
//        adapterView.data = arrayListOf("a","b","c")
//
//        cycleView.adapter = PagerAdapter
//
////        cycleView.interpolator =
//        cycleView.scrollDuration = 500
//        cycleView.isMediumScaled = true;
//        cycleView.maxPageScale = 0.8f;
//        cycleView.minPageScale = 0.4f;
//        cycleView.centerPageScaleOffset = 30.0f
//        cycleView.minPageScaleOffset = 10.0f
////        cycleView.onInfiniteCyclePageTransformListener =


    }

    override fun initAction() {
        super.initAction()



    }
    /**
     *
     *   final HorizontalInfiniteCycleViewPager infiniteCycleViewPager =
    (HorizontalInfiniteCycleViewPager) view.findViewById(R.id.hicvp);
    infiniteCycleViewPager.setAdapter(...);
    infiniteCycleViewPager.setScrollDuration(500);
    infiniteCycleViewPager.setInterpolator(...);
    infiniteCycleViewPager.setMediumScaled(true);
    infiniteCycleViewPager.setMaxPageScale(0.8F);
    infiniteCycleViewPager.setMinPageScale(0.5F);
    infiniteCycleViewPager.setCenterPageScaleOffset(30.0F);
    infiniteCycleViewPager.setMinPageScaleOffset(5.0F);
    infiniteCycleViewPager.setOnInfiniteCyclePageTransformListener(...);
     * */

}




























