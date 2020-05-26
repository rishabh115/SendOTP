package com.example.sendotp.ui.home

import androidx.test.rule.ActivityTestRule
import com.example.sendotp.R
import com.google.android.material.tabs.TabLayout
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class HomeActivityRuleTest {
    private lateinit var tabs: TabLayout
    @get:Rule val main = ActivityTestRule(HomeActivity::class.java, true)

    @Before
    fun init(){
      tabs = main.activity.findViewById(R.id.tabs)
    }

    @Test
    fun numberOfTabs_equalToTwo(){
        Assert.assertEquals("Tab counts don't match!",2, tabs.tabCount)
    }
}