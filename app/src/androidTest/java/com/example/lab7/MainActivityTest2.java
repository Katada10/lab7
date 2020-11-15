package com.example.lab7;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.Espresso.*;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest2 {
    //Espresso UI Tests
    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void firstNameInvalid(){

        onView(withId(R.id.username)).perform(typeText("wrongname"), closeSoftKeyboard());
        onView(withId(R.id.Lastname)).perform(typeText("test"), closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("email@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.loginBtn)).perform(click());
        onView(withText("Invalid First Name")).check(matches(isDisplayed()));
    }


    @Test
    public void lastNameInvalid(){
        onView(withId(R.id.username)).perform(typeText("user"), closeSoftKeyboard());
        onView(withId(R.id.Lastname)).perform(typeText("wrongname"), closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("email@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.loginBtn)).perform(click());
        onView(withText("Invalid Last Name")).check(matches(isDisplayed()));
    }
}
