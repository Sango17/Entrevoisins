package com.openclassrooms.entrevoisins.model;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alexandre SENEVIRATNE on 12/3/2019.
 */
public class NeighbourTest {
    private static final int TEST_ID = 25;
    private static final String TEST_NAME = "TestingNeighbour";
    private static final String TEST_AVATAR_URL = "www.test.com";
    private static final String TEST_ADDRESS = "89, rue de Paris";
    private static final String TEST_PHONE_NUMBER = "0650505050";
    private static final String TEST_MAIL = "test.neighbour@gmail.com";
    Neighbour neighbour;

    @Before
    public void setUp() throws Exception {
        neighbour = new Neighbour(
                TEST_ID,
                TEST_NAME,
                TEST_AVATAR_URL,
                TEST_ADDRESS,
                TEST_PHONE_NUMBER,
                TEST_MAIL,
                false);
    }

    @Test
    public void getId() {
        int result = neighbour.getId();
        Assert.assertTrue(TEST_ID == result);
    }

    @Test
    public void setId() {
        neighbour.setId(22);
        Assert.assertTrue(22 == neighbour.getId());
    }

    @Test
    public void getName() {
        String result = neighbour.getName();
        Assert.assertTrue(TEST_NAME.equals(result));
    }

    @Test
    public void setName() {
        neighbour.setName("Hello");
        Assert.assertTrue("Hello".equals(neighbour.getName()));
    }

    @Test
    public void getAvatarUrl() {
        String result = neighbour.getAvatarUrl();
        Assert.assertTrue(TEST_AVATAR_URL.equals(result));
    }

    @Test
    public void setAvatarUrl() {
        neighbour.setAvatarUrl("TestAvatarUrl");
        Assert.assertTrue("TestAvatarUrl".equals(neighbour.getAvatarUrl()));
    }

    @Test
    public void getAddress() {
        String result = neighbour.getAddress();
        Assert.assertTrue(TEST_ADDRESS.equals(result));
    }

    @Test
    public void setAddress() {
        neighbour.setAddress("TestAddress");
        Assert.assertTrue("TestAddress".equals(neighbour.getAddress()));
    }

    @Test
    public void getPhoneNumber() {
        String result = neighbour.getPhoneNumber();
        Assert.assertTrue(TEST_PHONE_NUMBER.equals(result));
    }

    @Test
    public void setPhoneNumber() {
        neighbour.setPhoneNumber("13371337");
        Assert.assertTrue("13371337".equals(neighbour.getPhoneNumber()));
    }

    @Test
    public void getMail() {
        String result = neighbour.getMail();
        Assert.assertTrue(TEST_MAIL.equals(result));
    }

    @Test
    public void setMail() {
        neighbour.setMail("testmail@test@com");
        Assert.assertTrue("testmail@test@com".equals(neighbour.getMail()));
    }

    @Test
    public void getFavorite() {
        Boolean result = neighbour.getFavorite();
        Assert.assertFalse(result);
    }

    @Test
    public void setFavorite() {
        neighbour.setFavorite(true);
        Assert.assertTrue(neighbour.getFavorite());
    }
}