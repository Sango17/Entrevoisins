package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Caroline", "http://i.pravatar.cc/150?u=a042581f4e29026704d", "1, rue de Paris, 75001 Paris", "0650505050", "www.facebook.fr/caroline", false),
            new Neighbour(2, "Jack", "http://i.pravatar.cc/150?u=a042581f4e29026704e", "16, rue de Lyon, 75001 Paris", "0650505050", "www.facebook.fr/jack", false),
            new Neighbour(3, "Chloé", "http://i.pravatar.cc/150?u=a042581f4e29026704f", "51, rue de Voltaire, 75001 Paris", "0650505050", "www.facebook.fr/chloe", false),
            new Neighbour(4, "Vincent", "http://i.pravatar.cc/150?u=a042581f4e29026704a", "125, rue de Lille, 75001 Paris", "0650505050", "www.facebook.fr/vincent", false),
            new Neighbour(5, "Elodie", "http://i.pravatar.cc/150?u=a042581f4e29026704b", "1, rue des Champs-Elysees, 75001 Paris", "0650505050", "www.facebook.fr/elodie", false),
            new Neighbour(6, "Sylvain", "http://i.pravatar.cc/150?u=a042581f4e29026704c", "154, rue de Montesquieu, 75001 Paris", "0650505050", "www.facebook.fr/sylvain", false),
            new Neighbour(7, "Laetitia", "http://i.pravatar.cc/150?u=a042581f4e29026703d", "189, rue d'Apollinaire, 75001 Paris", "0650505050", "www.facebook.fr/laetitia", false),
            new Neighbour(8, "Dan", "http://i.pravatar.cc/150?u=a042581f4e29026703b", "164, rue de Pelletier, 75001 Paris", "0650505050", "www.facebook.fr/dan", false),
            new Neighbour(9, "Joseph", "http://i.pravatar.cc/150?u=a042581f4e29026704d", "12, rue de Livry, 75001 Paris", "0650505050", "www.facebook.fr/joseph", false),
            new Neighbour(10, "Emma", "http://i.pravatar.cc/150?u=a042581f4e29026706d", "165, rue de Sauvage, 75001 Paris", "0650505050", "www.facebook.fr/emma", false),
            new Neighbour(11, "Patrick", "http://i.pravatar.cc/150?u=a042581f4e29026702d", "147, rue du Bac, 75001 Paris", "0650505050", "www.facebook.fr/patrick", false),
            new Neighbour(12, "Ludovic", "http://i.pravatar.cc/150?u=a042581f3e39026702d", "19, rue de Tempo, 75001 Paris", "0650505050", "www.facebook.fr/ludovic", false)
    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }

    static Neighbour generateNeighbour() {
        return DUMMY_NEIGHBOURS.get(new Random().nextInt(DUMMY_NEIGHBOURS.size()));
    }
}
