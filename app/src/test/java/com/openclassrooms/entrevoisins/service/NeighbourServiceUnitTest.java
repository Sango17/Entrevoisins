package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceUnitTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void favoriteNeighbourWithSuccess() {
        Neighbour favoriteNeighbour = service.getNeighbours().get(0);
        service.favoriteNeighbour(favoriteNeighbour, true);
        assertTrue(service.getNeighbours().get(0).getFavorite());
    }

    @Test
    public void getFavoriteNeighboursWithSuccess() {
        Neighbour favoriteNeighbour = service.getNeighbours().get(0);
        service.favoriteNeighbour(favoriteNeighbour, true);
        Neighbour favoriteNeighbour2 = service.getNeighbours().get(1);
        service.favoriteNeighbour(favoriteNeighbour2, true);

        List<Neighbour> favoriteNeighbours = service.getFavoriteNeighbours();

        assertEquals(2, favoriteNeighbours.size());
    }

    @Test
    public void getRandomNeighbourWithSuccess(){
        Neighbour randomNeighbour = service.getRandomNeighbour();
        assertNotNull(randomNeighbour);
    }
}
