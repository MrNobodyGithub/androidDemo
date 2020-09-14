package com.mqp.anddemo1.ui.activity.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mqp.anddemo1.R
import com.mqp.anddemo1.utils.base.BaseFragment

class FragmentHome:BaseFragment(){

    override fun initViewId(): Int {
        return  R.layout.fragment_home;
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//
//        val root = inflater.inflate(R.layout.fragment_home,container,false)
//        return  root;
//
////        return super.onCreateView(inflater, container, savedInstanceState)
//    }

}