package com.openclassrooms.entrevoisins.ui.neighbour_detail;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.util.List;

public class DetailNeighbourActivity extends AppCompatActivity {

    private NeighbourApiService mApiService;
    private Neighbour mNeighbour;
    private List<Neighbour> mNeighbours;
    private FloatingActionButton favoriteFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);


        mApiService = DI.getNeighbourApiService();

        CollapsingToolbarLayout collapsingToolBarLayout = findViewById(R.id.collapsing_toolbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ImageView toolBarImageView = findViewById(R.id.toolbar_image);
        TextView nameTextView = findViewById(R.id.neighbour_name);
        TextView placeTextView = findViewById(R.id.neighbour_place);
        TextView phoneTextView = findViewById(R.id.neighbour_phone);
        TextView mailTextView = findViewById(R.id.neighbour_mail);

        favoriteFab = findViewById(R.id.favorite_fab);


        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_24dp, null));
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });

        if (getIntent().getExtras() != null) {
            int id = getIntent().getIntExtra("neighbour", -1);
            mNeighbours = mApiService.getNeighbours();
            mNeighbour = getNeighbourFromId(id);


            if (mNeighbour != null) {
                collapsingToolBarLayout.setTitle(mNeighbour.getName());
                collapsingToolBarLayout.setExpandedTitleMarginStart(50);
                Glide.with(this)
                        .load(mNeighbour.getAvatarUrl())
                        .into(toolBarImageView);

                nameTextView.setText(mNeighbour.getName());
                placeTextView.setText(mNeighbour.getAddress());
                phoneTextView.setText(mNeighbour.getPhoneNumber());
                mailTextView.setText(mNeighbour.getMail());
                Log.d("alex", mNeighbour.getFavorite().toString());

                setFab();
                initClickListener();
            }
        }
    }

    private void setFab() {
        if (isCheckedFavorite()) {
            favoriteFab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star_yellow_24dp));
        } else {
            favoriteFab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star_border_yellow_24dp));
        }
    }

    private void initClickListener() {
        favoriteFab.setOnClickListener(v -> {
            if (isCheckedFavorite()) {
                mApiService.favoriteNeighbour(mNeighbour, false);
                setFab();

                Log.d("Alex", mNeighbour.getFavorite().toString());
            } else {
                mApiService.favoriteNeighbour(mNeighbour, true);
                setFab();

                Log.d("Alex", mNeighbour.getFavorite().toString());
            }
        });
    }

    /**
     * @return if selected neighbour is favorite or not
     */
    private Boolean isCheckedFavorite() {
        return mNeighbour.getFavorite();
    }

    /**
     * @param id
     * @return selected Neighbour from his ID
     */
    private Neighbour getNeighbourFromId(int id) {
        for (Neighbour neighbour : mNeighbours) {
            if (neighbour.getId() == id) {
                return neighbour;
            }
        }
        return null;
    }
}
