package com.mytaxi.android_demo;

import android.support.test.espresso.matcher.RootMatchers;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class PageObjects {

    private int userName = (R.id.edt_username);
    private int password= (R.id.edt_password);
    private int loginBtn= (R.id.btn_login);
    private int textSearch= (R.id.textSearch);
    private int driverName = (R.id.textViewDriverName);

    protected void checkLoginPage(){
        onView(withId(userName)).check(matches(isDisplayed()));
        onView(withId(password)).check(matches(isDisplayed()));
        onView(withId(loginBtn)).check(matches(isDisplayed()));
    }

    protected void enterUserName(String name){
        onView(withId(userName))
                .perform(typeText(name), closeSoftKeyboard());
    }

    protected void enterPassword(String pass){
        onView(withId(password))
                .perform(typeText(pass), closeSoftKeyboard());
    }

    protected void clickLoginBtn() throws Exception{
        onView(withId(loginBtn)).perform(click());
        //TODO: Implement Idlingresource
        Thread.sleep(700);
        onView(withId(textSearch)).check(matches(isDisplayed()));
    }

    protected void searchTextSearch(String criteria){
        onView(withId(textSearch))
                .perform(typeText(criteria), closeSoftKeyboard());
    }

    protected void findDriver(String name){
        onView(withText(name))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    protected void checkDriver(String name){
        onView(withId(driverName)).check(matches(withText(name)));
    }

    protected void clickCallDriver(){
        onView(withId(R.id.fab)).perform(click());
    }
}
