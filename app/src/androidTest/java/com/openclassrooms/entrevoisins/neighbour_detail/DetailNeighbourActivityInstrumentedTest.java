package com.openclassrooms.entrevoisins.neighbour_detail;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DetailNeighbourActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule = new ActivityTestRule<>(ListNeighbourActivity.class);

    /**
     * We ensure that the selected neighbour in ListNeighbourActivity is shown in DetailNeighbourActivity
     */
    @Test
    public void detailNeighbourActivityTest() {
        // Click on the first item on the recyclerView (Caroline is the selected neighbour)
        // Click on first element of Neighbour's list
        onView(withId(R.id.list_neighbours)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // Check if the FAB is displayed
        onView(allOf(withId(R.id.favorite_fab),
                childAtPosition(childAtPosition(withId(android.R.id.content), 0), 2),
                isDisplayed())).check(matches(isDisplayed()));

        // Check if the name is displayed
        onView(allOf(withId(R.id.neighbour_name),
                withText("Caroline"),
                childAtPosition(childAtPosition(IsInstanceOf.instanceOf(android.widget.FrameLayout.class),0), 0),
                isDisplayed())).check(matches(withText("Caroline")));

        // Check if the address is displayed
        onView(allOf(withId(R.id.neighbour_place),
                withText("1, rue de Paris, 75001 Paris"),
                childAtPosition(childAtPosition(IsInstanceOf.instanceOf(android.widget.LinearLayout.class),1), 1),
                isDisplayed())).check(matches(withText("1, rue de Paris, 75001 Paris")));


        // Check if the phone number is displayed
        onView(allOf(withId(R.id.neighbour_phone),
                withText("0650505050"),
                childAtPosition(childAtPosition(IsInstanceOf.instanceOf(android.widget.LinearLayout.class),2), 1),
                isDisplayed())).check(matches(withText("0650505050")));

        // Check if the URL address is displayed
        onView(allOf(withId(R.id.neighbour_mail),
                withText("www.facebook.fr/caroline"),
                childAtPosition(childAtPosition(IsInstanceOf.instanceOf(android.widget.LinearLayout.class),3), 1),
                isDisplayed())).check(matches(withText("www.facebook.fr/caroline")));

        // Check if the name is displayed in the collapsing toolbar
        onView(allOf(withId(R.id.toolbar_image),
                childAtPosition(allOf(withId(R.id.collapsing_toolbar), withContentDescription("Caroline"),
                        childAtPosition(withId(R.id.appBar), 0)), 0),
                        isDisplayed())).check(matches(isDisplayed()));
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
