package com.openclassrooms.entrevoisins.ui.neighbour_list.adapter;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alexandre SENEVIRATNE on 1/10/2020.
 */
public class NeighbourViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_list_avatar)
    public ImageView mNeighbourAvatar;
    @BindView(R.id.item_list_name)
    public TextView mNeighbourName;
    @BindView(R.id.item_list_delete_button)
    public ImageButton mDeleteButton;
    @BindView(R.id.neighbour_list_item)
    public ConstraintLayout mNeighbourListItem;

    public NeighbourViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
