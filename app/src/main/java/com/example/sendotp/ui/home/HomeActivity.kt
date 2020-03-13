package com.example.sendotp.ui.home

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.example.sendotp.R
import com.example.sendotp.SendOTPApp
import com.example.sendotp.base.BaseActivity
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var homeComponent: HomeComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        homeComponent = (application as SendOTPApp).appComponent.homeComponent().create()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val homeAdapter = HomeAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = homeAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }
}