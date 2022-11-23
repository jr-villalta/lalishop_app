package com.example.lalishop.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyLeftOf;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.lalishop.LoginActivity;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule
            = new ActivityScenarioRule<LoginActivity>(LoginActivity.class);

    @Test
    public void useAppContext() {
        onView(withText("Text")).check(matches(isDisplayed()));
        onView(withText("Text")).check(isCompletelyLeftOf(withId(R.id.TxtCorreoLogin)));
    }

    @Test
    public void login(){
        onView(ViewMatchers.withId(R.id.TxtCorreoLogin)).perform(ViewAction.typeText("5"));
    }


}