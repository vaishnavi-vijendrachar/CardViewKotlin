package com.example.vaishnavi.cardviewkotlin

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    lateinit var fragment : CardViewFragment

   @Rule @JvmField
   val activityTestRule = ActivityTestRule(CardViewActivity::class.java)

    @Before
    fun setUp(){
        activityTestRule.activity.supportFragmentManager.beginTransaction()
        fragment = activityTestRule.activity.supportFragmentManager.findFragmentById(R.id.container)  as CardViewFragment
    }

    @Test
    fun preConditions(){
        assertNotNull(activityTestRule.activity)
        assertNotNull(fragment)
        assertNotNull(fragment.radiusSeekBar)
        assertNotNull(fragment.elevationSeekBar)
    }

    @Test
    fun testRadiusSeekBarChangesCardView(){

        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            val radius = 50.0f
            fragment.radiusSeekBar.progress = radius.toInt()
            assertEquals(radius,fragment.cardView.radius)
        }
    }

    @Test
    fun testElevationSeekbarChangesElevationOfCardView() {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            val elevation = 40.0f
            fragment.elevationSeekBar.progress = elevation.toInt()
            assertEquals(elevation, fragment.cardView.elevation)
        }
    }
}
