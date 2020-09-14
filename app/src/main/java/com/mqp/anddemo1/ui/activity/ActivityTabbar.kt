package com.mqp.anddemo1.ui.activity

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

import com.google.android.material.bottomnavigation.BottomNavigationView

import com.mqp.anddemo1.R
import com.mqp.anddemo1.utils.base.BaseActivity

class ActivityTabbar:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_tabbar)



        // 底部导航view   BottomNavigationView
        val navView:BottomNavigationView = findViewById(R.id.nav_view)

        // 主要的fragment 容器
        val navController = findNavController(R.id.nav_host_fragment)

        // fragment容器中的 fragment
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,R.id.navigation_me
            )
        )

//        setupActionBarWithNavController(navController,appBarConfiguration)
        navView.setupWithNavController(navController)


    }






}



