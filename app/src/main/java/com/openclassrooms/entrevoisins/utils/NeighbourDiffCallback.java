package com.openclassrooms.entrevoisins.utils;

import android.support.v7.util.DiffUtil;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Created by Alexandre SENEVIRATNE on 11/19/2019.
 */
public class NeighbourDiffCallback extends DiffUtil.Callback {
    private  List<Neighbour> newNeighbourList;
    private List<Neighbour> oldNeighbourList;

    public NeighbourDiffCallback(List<Neighbour> newNeighbourList, List<Neighbour>oldNeighbourList) {
        this.newNeighbourList = newNeighbourList;
        this.oldNeighbourList = oldNeighbourList;
    }

    @Override
    public int getOldListSize() {
        return oldNeighbourList.size();
    }

    @Override
    public int getNewListSize() {
        return newNeighbourList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldNeighbourList.get(oldItemPosition).getId() == newNeighbourList.get(newItemPosition).getId() ;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldNeighbourList.get(oldItemPosition).equals(newNeighbourList.get(newItemPosition));
    }
}
