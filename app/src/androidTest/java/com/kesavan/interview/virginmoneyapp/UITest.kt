package com.kesavan.interview.virginmoneyapp

import android.view.View
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kesavan.interview.virginmoneyapp.presentation.HomeActivity
import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UITest {
    @Rule
    @JvmField
    public val activityRule: ActivityScenarioRule<HomeActivity> = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun testRecyclerVisible() {
        activityRule.scenario.onActivity { mainActivity ->
            Assert.assertEquals(View.VISIBLE,mainActivity.findViewById<View?>(R.id.items_list).visibility)
        }
    }
}