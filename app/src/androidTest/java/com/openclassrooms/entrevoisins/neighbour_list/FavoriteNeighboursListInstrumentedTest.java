package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.matcher.ViewMatchers;
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
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by Alexandre SENEVIRATNE on 11/11/2019.
 */
@RunWith(AndroidJUnit4.class)
public class FavoriteNeighboursListInstrumentedTest {
    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());

        // Move to Favorite when tab is clicked
        onView(allOf(withContentDescription("Favorites"),
                childAtPosition(childAtPosition(withId(R.id.tabs), 0), 1),
                isDisplayed()))
                .perform(click());

        // Move to Favorite when swipe left
        onView(allOf(withId(R.id.container),
                childAtPosition(childAtPosition(withId(android.R.id.content), 0), 1),
                isDisplayed())).perform(swipeLeft());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void favoriteNeighboursList_shouldNotBeEmpty() {
        // Check if there is at least 1 item in the recyclerView
        onView(ViewMatchers.withId(R.id.list_neighbours_favorite))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void favoriteNeighboursList_deleteAction_shouldRemoveItem() {
        // Check if there are 2 items set in the recyclerView
        onView(ViewMatchers.withId(R.id.list_neighbours_favorite))
                .check(withItemCount(2));

        // Click on the delete button of item position 2
        onView(allOf(withId(R.id.item_list_favorite_delete_button),
                childAtPosition(allOf(withId(R.id.favorite_neighbour_list_item), childAtPosition(withClassName(is("android.support.v7.widget.RecyclerView")), 1)), 2),
                isDisplayed())).perform(click());

        // Check if there is 1 items set in the recyclerView
        onView(ViewMatchers.withId(R.id.list_neighbours_favorite))
                .check(withItemCount(1));
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