package com.example.fantasytranslator;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AddToFavouritesTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void addToFavouritesTest() {

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.language),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                3),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("sindarin"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.addToFavourites), withText("Add to favourites"),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                4),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction tabView = onView(
                allOf(withContentDescription("Popular languages"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.language_rv), withText("sindarin"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.rv),
                                        2),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("sindarin")));

        ViewInteraction imageView = onView(
                allOf(withId(R.id.image_rv),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.rv),
                                        2),
                                1),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));
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
}
