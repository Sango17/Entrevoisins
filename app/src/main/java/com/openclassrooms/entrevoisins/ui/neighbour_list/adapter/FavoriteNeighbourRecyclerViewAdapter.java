package com.openclassrooms.entrevoisins.ui.neighbour_list.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.FavoriteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_detail.DetailNeighbourActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alexandre SENEVIRATNE on 11/11/2019.
 */

public class FavoriteNeighbourRecyclerViewAdapter extends RecyclerView.Adapter<NeighbourViewHolder> {

    private final List<Neighbour> mNeighbours;
    private Context mContext;

    public FavoriteNeighbourRecyclerViewAdapter(List<Neighbour> items, Context context) {
        mNeighbours = items;
        mContext = context;
    }

    @Override
    public NeighbourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.neighbour_list_item, parent, false);
        return new NeighbourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NeighbourViewHolder holder, int position) {
        Neighbour neighbour = mNeighbours.get(position);
        holder.mNeighbourName.setText(neighbour.getName());
        Glide.with(holder.mNeighbourAvatar.getContext())
                .load(neighbour.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mNeighbourAvatar);

        holder.mNeighbourListItem.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, DetailNeighbourActivity.class);
            intent.putExtra("neighbour", neighbour.getId());
            mContext.startActivity(intent);
        });

        holder.mDeleteButton.setOnClickListener(v -> {
            EventBus.getDefault().post(new FavoriteNeighbourEvent(neighbour, false));
        });
    }

    @Override
    public int getItemCount() {
        return mNeighbours.size();
    }
}
