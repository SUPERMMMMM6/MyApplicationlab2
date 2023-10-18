package com.example.myapplication;


import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);


    /**
     * this is a test to find missing uppercase
     */
    @Test
    public void TestFindMissingUpperCase() {
        ViewInteraction appCompatEditText = onView( (withId(R.id.editText)));

        appCompatEditText.perform(replaceText("password123!!"), closeSoftKeyboard());


        ViewInteraction materialButton = onView((withId(R.id.button)));
        materialButton.perform(click());

        ViewInteraction textView = onView( (withId(R.id.textView)));
        textView.check(matches(withText("You shall not pass!")));
    }
    /**
     * this is a test to find missing lower case
     */
    @Test
    public void TestFindMissingLowerCase() {
        ViewInteraction appCompatEditText = onView( (withId(R.id.editText)));

        appCompatEditText.perform(replaceText("PASSWORD123!!"), closeSoftKeyboard());


        ViewInteraction materialButton = onView((withId(R.id.button)));
        materialButton.perform(click());

        ViewInteraction textView = onView( (withId(R.id.textView)));
        textView.check(matches(withText("You shall not pass!")));
    }
    /**
     * this is a test to find missing numbers
     */
    @Test
    public void TestFindMissingNumber() {
        ViewInteraction appCompatEditText = onView( (withId(R.id.editText)));

        appCompatEditText.perform(replaceText("Password!!"), closeSoftKeyboard());


        ViewInteraction materialButton = onView((withId(R.id.button)));
        materialButton.perform(click());

        ViewInteraction textView = onView( (withId(R.id.textView)));
        textView.check(matches(withText("You shall not pass!")));
    }
    /**
     * this is a test to find missing special char
     */
    @Test
    public void TestFindMissingChar() {
        ViewInteraction appCompatEditText = onView( (withId(R.id.editText)));

        appCompatEditText.perform(replaceText("Password123"), closeSoftKeyboard());


        ViewInteraction materialButton = onView((withId(R.id.button)));
        materialButton.perform(click());

        ViewInteraction textView = onView( (withId(R.id.textView)));
        textView.check(matches(withText("You shall not pass!")));
    }
    /**
     * this is a test that meets all requirements
     */
    @Test
    public void TestFindMissing() {
        ViewInteraction appCompatEditText = onView( (withId(R.id.editText)));

        appCompatEditText.perform(replaceText("Password123!"), closeSoftKeyboard());


        ViewInteraction materialButton = onView((withId(R.id.button)));
        materialButton.perform(click());

        ViewInteraction textView = onView( (withId(R.id.textView)));
        textView.check(matches(withText("Your password meets the requirements")));
    }
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    /**
     * Instrumented test, which will execute on an Android device.
     *
     * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
     */
    @RunWith(AndroidJUnit4.class)
    public static class ExampleInstrumentedTest {
        @Test
        public void useAppContext() {
            // Context of the app under test.
            Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            assertEquals("com.example.myapplicationlab", appContext.getPackageName());
        }
    }
}
