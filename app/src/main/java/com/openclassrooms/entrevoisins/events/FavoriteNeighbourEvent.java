package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Created by Alexandre SENEVIRATNE on 11/11/2019.
 */

/**
 * Event fired when a user select favorite a Neighbour
 */
public class FavoriteNeighbourEvent {

        /**
         * Neighbour to set favorite
         */
        public Neighbour neighbour;

        /**
         * Constructor.
         * @param neighbour
         * @param isFavorite
         */
        public FavoriteNeighbourEvent(Neighbour neighbour, Boolean isFavorite) {
            this.neighbour = neighbour;
            neighbour.setFavorite(isFavorite);
        }

}
