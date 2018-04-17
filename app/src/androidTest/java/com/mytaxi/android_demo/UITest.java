package com.mytaxi.android_demo;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class UITest extends PageObjects{


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Test
    public void callDriver() throws Exception{
        checkLoginPage();
        enterUserName("whiteelephant261");
        enterPassword("video1");
        clickLoginBtn();
        searchTextSearch("sa");
        findDriver("Sarah Friedrich");
        checkDriver("Sarah Friedrich");
        clickCallDriver();

    }


}
