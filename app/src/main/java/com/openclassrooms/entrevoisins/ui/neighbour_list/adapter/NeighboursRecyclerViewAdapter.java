package com.openclassrooms.entrevoisins.ui.neighbour_list.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.util.DiffUtil;
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
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_detail.DetailNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.NeighbourDiffCallback;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NeighboursRecyclerViewAdapter extends RecyclerView.Adapter<NeighboursRecyclerViewAdapter.ViewHolder> {

    private List<Neighbour> mNeighbours;
    private Context mContext;

    public NeighboursRecyclerViewAdapter(List<Neighbour> items, Context context) {
        mNeighbours = items;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.neighbour_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Neighbour neighbour = mNeighbours.get(position);
        holder.mNeighbourName.setText(neighbour.getName());
        Glide.with(holder.mNeighbourAvatar.getContext())
                .load(neighbour.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mNeighbourAvatar);

        holder.mDeleteButton.setOnClickListener(v -> EventBus.getDefault().post(new DeleteNeighbourEvent(neighbour)));

        holder.mNeighbourListItem.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, DetailNeighbourActivity.class);
            intent.putExtra("neighbour", neighbour.getId());
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mNeighbours.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_list_avatar)
        public ImageView mNeighbourAvatar;
        @BindView(R.id.item_list_name)
        public TextView mNeighbourName;
        @BindView(R.id.item_list_delete_button)
        public ImageButton mDeleteButton;
        @BindView(R.id.neighbour_list_item)
        public ConstraintLayout mNeighbourListItem;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void updateList(List<Neighbour> newNeighbourList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new NeighbourDiffCallback(newNeighbourList, mNeighbours));
        this.mNeighbours = new ArrayList<>(newNeighbourList);
        diffResult.dispatchUpdatesTo(this);
    }
}
