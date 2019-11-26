package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.adapter.ListNeighbourPagerAdapter;
import com.openclassrooms.entrevoisins.ui.neighbour_list.fragment.FavoriteNeighbourFragment;
import com.openclassrooms.entrevoisins.ui.neighbour_list.fragment.NeighbourFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListNeighbourActivity extends AppCompatActivity {

    // UI Components
    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.fab_list_neighbour)
    FloatingActionButton mFab;
    NeighbourFragment mNeighbourFragment = new NeighbourFragment();
    FavoriteNeighbourFragment mFavoriteNeighbourFragment = new FavoriteNeighbourFragment();

    ListNeighbourPagerAdapter mPagerAdapter;
    NeighbourApiService mApiService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_neighbour);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mApiService = DI.getNeighbourApiService();

        mPagerAdapter = new ListNeighbourPagerAdapter(getSupportFragmentManager());

        // add fragment
        mPagerAdapter.addFragment(mNeighbourFragment);
        mPagerAdapter.addFragment(mFavoriteNeighbourFragment);

        // adapter setup
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        mFab.setOnClickListener(v -> {
            mNeighbourFragment.updateList();
        });
    }
}
