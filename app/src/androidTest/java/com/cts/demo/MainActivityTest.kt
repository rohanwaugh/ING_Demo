package com.cts.demo

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import com.cts.demo.CustomAssertions.Companion.hasItemCount
import com.cts.demo.CustomMatchers.Companion.withItemCount
import org.junit.Rule
import org.junit.Test

class MainActivityTest{

    // This activityRule is used to launch the activity under test(In this case it is MainActivity)
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun countHeros(){
        onView(withId(R.id.recyclerview))
            .check(matches(withItemCount(5)))
    }

    @Test
    fun countHerosWithViewAssertion() {
        onView(withId(R.id.recyclerview))
            .check(hasItemCount(5))
    }
}