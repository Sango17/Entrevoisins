package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.contrib.ViewPagerActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by Alexandre SENEVIRATNE on 11/11/2019.
 */
@RunWith(AndroidJUnit4.class)
public class FavoriteNeighboursListInstrumentedTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule = new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    @Test
    public void favoriteNeighbourList_addAction_shouldAddItem() {
        // Check the initial count of neighbours
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));

        // Click on first element of Neighbour's list
        onView(withId(R.id.list_neighbours)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // Click on FAB Favorite in order to set that neighbour as favorite
        onView(withId(R.id.favorite_fab)).perform(click());

        // Click onBackPressed()
        Espresso.pressBack();

        // Check the initial count of neighbours
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));

        // Go to Favorite Tab on ViewPager
        onView(withId(R.id.container)).perform(ViewPagerActions.scrollRight());

        // Check if there is at least 1 favorite element in the RecyclerView
        onView(ViewMatchers.withId(R.id.list_neighbours_favorite)).check(withItemCount(1));
    }

    @Test
    public void favoriteNeighboursList_deleteAction_shouldRemoveItem() {
        // Check the initial count of neighbours
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));

        // Click on first element of Neighbour's list
        onView(withId(R.id.list_neighbours)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // Click on FAB Favorite in order to set that neighbour as favorite
        onView(withId(R.id.favorite_fab)).perform(click());

        // Click onBackPressed()
        Espresso.pressBack();

        // Check the initial count of neighbours
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));

        // Go to Favorite Tab on ViewPager
        onView(withId(R.id.container)).perform(ViewPagerActions.scrollRight());

        // Check if there is at least 1 favorite element in the RecyclerView
        onView(ViewMatchers.withId(R.id.list_neighbours_favorite)).check(withItemCount(1));

        // Click on Delete button of the first element
        onView(withId(R.id.list_neighbours_favorite)).perform(RecyclerViewActions.actionOnItemAtPosition(0, new DeleteViewAction()));

        // Check if there is no favorite element in the RecyclerView
        onView(ViewMatchers.withId(R.id.list_neighbours_favorite))
                .check(withItemCount(0));

        // Go to Neighbours Tab on Viewpager
        onView(withId(R.id.container)).perform(ViewPagerActions.scrollLeft());

        // Check the initial count of neighbours
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));
    }
}